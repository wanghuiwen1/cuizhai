package com.cch.cz.service;

import com.cch.cz.base.service.BaseService;
import com.cch.cz.entity.Cases;
import com.cch.cz.entity.Staff;
import com.cch.cz.exception.ObjectNullException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/18.
 * 员工service
 */
public interface CasesService extends BaseService<Cases,Long>  {


    @Transactional
    void expCase(List<Cases> casesList) throws IllegalAccessException;

    List<Map> groupCasesByArea();

    void allotCaseToCompany(List<String> data, String company);

    void allotStaff(List<Cases> cases, Staff staff);

    /**
     * 根据公司id查找未分配的case
     * @param company
     */
    List<Cases> listByCompanyNoStaff(Cases company);

    /**
     * 查找某个员工的cases
     * @param cases
     * @return
     */
    List<Cases> listByStaff(Cases cases);
    /**
     *
     * @param company 公司id
     * @param status 状态id
     * @return
     */
    List<Map> listByCompany(Long company,String staff,int status );

    /**
     *留案 撤案 结案
     */
    void managerCase(List<Cases> cases) throws ObjectNullException;

    /**
     * 动态查询
     * @param cases
     */
    List<Cases> dynamicList(Cases cases);


    /**
     * 分配ｃａｓｅ　根据案件名称
     * @param company 公司ｉｄ
     * @param cases　要分配的ｃａｓｅ数量和案件名称
     */
    void randomAllot(String[] company,List<Map> cases);

    /**
     * 按案件名称分组查询
     */
    List<Map> groupByCaseName();

    /**
     *
     * @param staff，
     */
    void randomToStaff(String[] staff,List<Cases> cases);

    /**
     * 调案
     * @param cases case
     * @param staffid 要分配到的员工
     */
    void adjust(List<Cases> cases, String staffid);

    /**
     *
     */
    List<Map> listByAdjust();

    /**
     *
     * @param cases
     * @param company
     */
    void allotToCompany(List<Cases> cases, String company);

    /**
     * 到期撤案
     */
    void autoRevoke();

    /**
     * @param cellValue
     */
    Staff findStaffByIdcard(String cellValue);

    /**
     * 已崔记和未崔记
     *
     * @param isUrge
     * @param company
     */
    List<Map> isUrge(String isUrge, Long company, String staff);

    /**
     * 今日催记
     * @param s
     * @return
     */
    List<Cases> todayUrge(String s);
}
