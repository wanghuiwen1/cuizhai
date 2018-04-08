package com.cch.cz.mapper;

import com.cch.cz.base.dao.BaseMapper;
import com.cch.cz.base.dao.provider.BaseProvider;
import com.cch.cz.entity.Cases;
import com.cch.cz.mapper.provider.CasesProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 委案
 */
@Mapper
public interface CasesMapper extends BaseMapper<Cases,Long> {
    /**
     * 按地区分组
     * @return
     */
    @Select("SELECT count(*) count,left(customer_residence_address,instr(customer_residence_address,'市')) as area FROM cuizhai.t_case  where company_id is null and status!=1  group by area")
    @Results({
            @Result(property = "count", column = "count"),
            @Result(property = "area",column = "area"),
    })
    List<Map> groupCasesByArea();

    /**
     * 按地区更新company
     * @param company
     * @param area
     */
    @Update("UPDATE t_case SET company_id=#{company} WHERE customer_residence_address like #{area}")
    void allotCompany(@Param("company") String company,@Param("area") String area);

    /**
     * 按id更新staffid
     * @param caseId
     * @param staff
     */
    @Update("UPDATE t_case SET staff_id=#{staff} WHERE id=#{case}")
    void allotStaff(@Param("case") Long caseId, @Param("staff") String staff);

    /**
     *
     * @param company
     * @return 某个公司还未分配的case
     */
    @SelectProvider(type = CasesProvider.class,method = "listByCompanyNoStaff")
    List<Cases> listByCompanyNoStaff(@Param("company") Long company);

    /**
     *
     * @param staff 员工id
     * @return 属于某个员工的case
     *
     */
    @SelectProvider(type = CasesProvider.class,method = "listByStaff")
    List<Cases> listByStaff(@Param("staff") String staff);
}
