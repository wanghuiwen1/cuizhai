package com.cch.cz.service.impl;

import com.cch.cz.base.service.impl.BaseServiceImpl;
import com.cch.cz.common.UtilFun;
import com.cch.cz.entity.AdjustLog;
import com.cch.cz.entity.Cases;
import com.cch.cz.entity.Staff;
import com.cch.cz.mapper.AdjustLogMapper;
import com.cch.cz.mapper.CasesMapper;
import com.cch.cz.service.CasesService;
import org.apache.poi.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/18.
 */
@Service
public class CasesServiceImpl extends BaseServiceImpl<Cases, Long> implements CasesService {
    @Resource
    private CasesMapper casesMapper;
    @Resource
    private AdjustLogMapper adjustLogMapper;

    @Override
    @Transactional
    public void expCase(List<Cases> casesList) {
        for (Cases c : casesList) {
            casesMapper.save(c);
        }
    }

    @Override
    public List<Map> groupCasesByArea() {
        return casesMapper.groupCasesByArea();
    }

    @Override
    @Transactional
    public void allotCaseToCompany(List<String> areas, String company) {
        for (String area : areas) {
            casesMapper.allotCompany(company, "%" + area + "%");
        }
    }

    @Override
    @Transactional
    public void allotStaff(List<Cases> cases, Staff staff) {
        for (Cases c : cases) {
            casesMapper.allotStaff(c.getId(), staff.getLoginName());
        }
    }

    @Override
    public List<Cases> listByCompanyNoStaff(Cases cases) {
        return casesMapper.listByCompanyNoStaff(cases);
    }

    @Override
    public List<Cases> listByStaff(String staff) {
        return casesMapper.listByStaff(staff);
    }

    @Override
    public Long countByStaff(String staff) {
        return casesMapper.countByStaff(staff);
    }

    @Override
    public List<Map> listByCompany(Long company, String staff, int status) {
        List<Map> list = casesMapper.listByCompany(company, staff, status);
        Map map = new HashMap();
        map.put("money", 0);
        map.put("num", 0);
        if (!UtilFun.isEmptyList(list) || list.size() <= 0) list.add(map);
        return list;
    }

    @Override
    public void managerCase(Long[] id, int status, int day) {
        for (int i = 0; i < id.length; i++) {
            Cases cases = this.findOne(id[i]);
            cases.setStatus(status);

            if (status == Cases.REVOKE) cases.setRevokeDate(UtilFun.DateToString(new Date(), UtilFun.YYYYMMDD));

            if (status == Cases.END) cases.setEndDate(UtilFun.DateToString(new Date(), UtilFun.YYYYMMDD));

            if (status == Cases.RETAIN) {
                cases.setRethinDate(UtilFun.DateToString(new Date(), UtilFun.YYYYMMDD));
                cases.setStopAppoint(UtilFun.DateToString(UtilFun.addDay(cases.getStopAppoint(),day,UtilFun.YYYYMMDD2),UtilFun.YYYYMMDD2));
                cases.setRethinDay(day);
            }
            this.update(cases);
        }

    }

    @Override
    public List<Cases> dynamicList(Cases cases) {
        return casesMapper.dynamicList(cases);
    }

    @Override
    public void randomAllot(String[] company,List<Map> cases) {
        for (int i = 0; i < cases.size(); i++) {
            for (int j = 0; j <company.length ; j++) {
                casesMapper.randomAllot(company[j],
                        cases.get(i).get("caseName").toString(),
                        Integer.parseInt(cases.get(i).get("count").toString())/company.length+1);
            }
        }
    }

    @Override
    public List<Map> groupByCaseName() {
        return casesMapper.groupCasesByCaseName();
    }

    @Override
    public void randomToStaff(String[] staff,int num,Long company) {
        int yu = num%staff.length;
        for (int i = 0; i < staff.length; i++) {
            casesMapper.randomToStaff(staff[i], num/staff.length,company);
        }
        for (int i=0;i<yu;i++){
            casesMapper.randomToStaff(staff[i], 1,company);
        }
    }

    @Override
    @Transactional
    public void adjust(List<Cases> ids, String staffid) {
        AdjustLog adjustLog = new AdjustLog();
        adjustLog.setNewStaff(staffid);
        adjustLog.setDate(new Date());
        for (Cases cases :ids) {
            adjustLog.setCaseId(cases.getId());
            adjustLog.setOldStaff(cases.getStaffId());
            adjustLogMapper.save(adjustLog);
            cases.setStaffId(staffid);
            update(cases);
        }
    }

    @Override
    public void listByAdjust() {

    }

    @Override
    @Transactional
    public void allotToCompany(List<Cases> cases, String company) {
        for (Cases c :cases) {
            c.setCompanyId(Long.parseLong(company));
            update(c);
        }
    }


}
