package com.cch.cz.entity;

import com.cch.cz.base.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * 委案
 */
@Entity
@Table(name = "t_case")
public class Cases extends BaseEntity {
    /**
     * 委案上传后的默认状态，上传后还未做任何处理
     */
    public final static int NORMAL = 0;
    /**
     * 被撤回的case
     */
    public final static int REVOKE = 1;

    /**
     * 留案申请的case
     */
    public final static int RETAIN = 2;
    /**
     * 结案申请
     */
    public final static int END = 3;
    /**
     * 结案
     */
    public final static int FINALLYEND = 4;
    /**
     * 留案5
     */
    public final static int FINALLYRETAIN = 5;
    /**
     * 承诺还款
     */
    public final static int PROMISE = 6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* 合同号*/
    private String contractNum;
    /*委外公司*/
    private String appointCompany;
    /*委派日期*/
    private String appointData;
    /*退案日期*/
    private String stopAppoint;
    /*城市*/
    private String city;
    /*地区*/
    private String region;
    /*CUSTOMERID*/
    private String CUSTOMERID;
    /*客户姓名*/
    private String name;
    /*性别*/
    private String sex;
    /*合同数量*/
    private String contractsNum;
    /*身份证*/
    private String idCard;
    /*合同申请日*/
    private String contractApplyDate;
    /*贷款类型*/
    private String loanType;
    /*贷款本金*/
    private String loanPrincipal;
    /*期款*/
    private String installmentMoney;
    /*期数*/
    private String installmentNum;
    /*已还款金额*/
    private String repaymentMoney;
    /*最后还款日*/
    private String deadline;
    /*逾期天数*/
    private String overrangingDay;
    /*取消分期时间*/
    private String cancelInstalments;
    /*未付期款*/
    private String nnpaidInstallment;
    /*未付滞纳金*/
    private String lateFee;
    /*欠款金额*/
    private String arrears;
    /*委外催收费*/
    private String serviceCharge;
    /*总欠款*/
    private String sumArrears;
    /*还款账号*/
    private String repaymentAccount;
    /*户名*/
    private String accountMaster;
    /*开户行*/
    private String bank;
    /*商品*/
    private String commodity;
    /*品牌*/
    private String brand;
    /*POS点*/
    private String posPlace;
    /*客户手机*/
    private String customerPhoneNumber;
    /*客户户籍地址*/
    private String customerAddress;
    /*客户办公电话*/
    private String customerOfficePhone;
    /*客户公司名称*/
    private String customerCompany;
    /*客户公司地址*/
    private String customerCompanyAddress;
    //    /*客户公司部门*/
    private String customerDepartment;
    //    /*客户住宅电话*/
    private String customerResidencePhone;
    //    /*客户住宅地址*/
    private String customerResidenceAddress;
    //    /*客户配偶姓名*/
    @Transient
    private String customerSpouse;
    //    /*客户配偶联系电话*/
    @Transient
    private String customerSpousePhone;
    //    /*客户亲戚姓名*/
    @Transient
    private String customerRelativeName;
    //    /*客户与亲戚关系*/
    @Transient
    private String customerRelationship;
    //    /*客户亲戚联系电话*/
    @Transient
    private String customerRelativePhone;
    //    /*其他联系人姓名*/
    @Transient
    private String customerRelativeOther;
    //    /*其他联系人关系*/
    @Transient
    private String customerRelaOther;
    /*其他联系人电话*/
    @Transient
    private String customerOtherPhone;
    @Transient
    private List<Extend> extend;
    /*客户邮箱*/
    private String customerMail;
    /*代扣开户行*/
    private String withholding;
    /*代扣账号*/
    private String withholdingAccount;
    /**
     * 分配公司 初始值为-1
     */
    private Long companyId;
    /**
     * 分配人员
     * 0 为未分配
     */
    private String StaffId;
    /**
     * 最后一次催记日期
     * 0 为未分配
     */
    private String lastUrge;
    /**
     * 撤案日期
     * 0 为未分配
     */
    private String revokeDate;
    /**
     * 结案时间
     */
    private String endDate;
    /**
     * 留案时间
     */
    private String rethinDate;

    /**
     * 留案日期
     */
    private String rethinDay;

    /**
     * case 的状态 撤案=1 留案=-2 正常=0 已完成=3
     *
     * @return
     */
    private Integer status;
    /**
     * 案件类型
     */
    private  String type;
    /**
     * 案件名称
     */
    private String caseName;

    /**
     * 结案原因
     */
    private String endReason;
    /**
     * 留案原因
     */
    private String retainReason;
    /**
     * 撤案原因
     */
    private String revokeReason;
    /**
     * 补充信息
     */
    @Column(length = 80000)
    private String supplement;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public String getAppointCompany() {
        return appointCompany;
    }

    public void setAppointCompany(String appointCompany) {
        this.appointCompany = appointCompany;
    }

    public String getAppointData() {
        return appointData;
    }

    public void setAppointData(String appointData) {
        this.appointData = appointData;
    }

    public String getStopAppoint() {
        return stopAppoint;
    }

    public void setStopAppoint(String stopAppoint) {
        this.stopAppoint = stopAppoint;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCUSTOMERID() {
        return CUSTOMERID;
    }

    public void setCUSTOMERID(String CUSTOMERID) {
        this.CUSTOMERID = CUSTOMERID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getContractsNum() {
        return contractsNum;
    }

    public void setContractsNum(String contractsNum) {
        this.contractsNum = contractsNum;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getContractApplyDate() {
        return contractApplyDate;
    }

    public void setContractApplyDate(String contractApplyDate) {
        this.contractApplyDate = contractApplyDate;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanPrincipal() {
        return loanPrincipal;
    }

    public void setLoanPrincipal(String loanPrincipal) {
        this.loanPrincipal = loanPrincipal;
    }

    public String getInstallmentMoney() {
        return installmentMoney;
    }

    public void setInstallmentMoney(String installmentMoney) {
        this.installmentMoney = installmentMoney;
    }

    public String getInstallmentNum() {
        return installmentNum;
    }

    public void setInstallmentNum(String installmentNum) {
        this.installmentNum = installmentNum;
    }

    public String getRepaymentMoney() {
        return repaymentMoney;
    }

    public void setRepaymentMoney(String repaymentMoney) {
        this.repaymentMoney = repaymentMoney;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getOverrangingDay() {
        return overrangingDay;
    }

    public void setOverrangingDay(String overrangingDay) {
        this.overrangingDay = overrangingDay;
    }

    public String getCancelInstalments() {
        return cancelInstalments;
    }

    public void setCancelInstalments(String cancelInstalments) {
        this.cancelInstalments = cancelInstalments;
    }

    public String getNnpaidInstallment() {
        return nnpaidInstallment;
    }

    public void setNnpaidInstallment(String nnpaidInstallment) {
        this.nnpaidInstallment = nnpaidInstallment;
    }

    public String getLateFee() {
        return lateFee;
    }

    public void setLateFee(String lateFee) {
        this.lateFee = lateFee;
    }

    public String getArrears() {
        return arrears;
    }

    public void setArrears(String arrears) {
        this.arrears = arrears;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getSumArrears() {
        return sumArrears;
    }

    public void setSumArrears(String sumArrears) {
        this.sumArrears = sumArrears;
    }

    public String getRepaymentAccount() {
        return repaymentAccount;
    }

    public void setRepaymentAccount(String repaymentAccount) {
        this.repaymentAccount = repaymentAccount;
    }

    public String getAccountMaster() {
        return accountMaster;
    }

    public void setAccountMaster(String accountMaster) {
        this.accountMaster = accountMaster;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPosPlace() {
        return posPlace;
    }

    public void setPosPlace(String posPlace) {
        this.posPlace = posPlace;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerOfficePhone(){ return customerOfficePhone; }

    public void setCustomerOfficePhone(String customerOfficePhone){ this.customerOfficePhone = customerOfficePhone;
    }
    public String getCustomerCompany(){ return customerCompany; }

    public void setCustomerCompany(String customerCompany){ this.customerCompany = customerCompany; }

    public String getCustomerCompanyAddress(){ return customerCompanyAddress; }

    public void setCustomerCompanyAddress(String customerCompanyAddress) {
        this.customerCompanyAddress = customerCompanyAddress;
    }

    public String getCustomerDepartment() {
        return customerDepartment;
    }

    public void setCustomerDepartment(String customerDepartment) {
        this.customerDepartment = customerDepartment;
    }

    public String getCustomerResidencePhone() {
        return customerResidencePhone;
    }

    public void setCustomerResidencePhone(String customerResidencePhone) {
        this.customerResidencePhone = customerResidencePhone;
    }

    public String getCustomerResidenceAddress() {
        return customerResidenceAddress;
    }

    public void setCustomerResidenceAddress(String customerResidenceAddress) {
        this.customerResidenceAddress = customerResidenceAddress;
    }

    public String getCustomerSpouse() {
        return customerSpouse;
    }

    public void setCustomerSpouse(String customerSpouse) {
        this.customerSpouse = customerSpouse;
    }

    public String getCustomerSpousePhone() {
        return customerSpousePhone;
    }

    public void setCustomerSpousePhone(String customerSpousePhone) {
        this.customerSpousePhone = customerSpousePhone;
    }

    public String getCustomerRelativeName() {
        return customerRelativeName;
    }

    public void setCustomerRelativeName(String customerRelativeName) {
        this.customerRelativeName = customerRelativeName;
    }

    public String getCustomerRelationship() {
        return customerRelationship;
    }

    public void setCustomerRelationship(String customerRelationship) {
        this.customerRelationship = customerRelationship;
    }

    public String getCustomerRelativePhone() {
        return customerRelativePhone;
    }

    public void setCustomerRelativePhone(String customerRelativePhone) {
        this.customerRelativePhone = customerRelativePhone;
    }

    public String getCustomerRelativeOther() {
        return customerRelativeOther;
    }

    public void setCustomerRelativeOther(String customerRelativeOther) {
        this.customerRelativeOther = customerRelativeOther;
    }

    public String getCustomerRelaOther() {
        return customerRelaOther;
    }

    public void setCustomerRelaOther(String customerRelaOther) {
        this.customerRelaOther = customerRelaOther;
    }

    public String getCustomerOtherPhone() {
        return customerOtherPhone;
    }

    public void setCustomerOtherPhone(String customerOtherPhone) {
        this.customerOtherPhone = customerOtherPhone;
    }
    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public String getWithholding() {
        return withholding;
    }

    public void setWithholding(String withholding) {
        this.withholding = withholding;
    }

    public String getWithholdingAccount() {
        return withholdingAccount;
    }

    public void setWithholdingAccount(String withholdingAccount) {
        this.withholdingAccount = withholdingAccount;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getStaffId() {
        return StaffId;
    }

    public void setStaffId(String staffId) {
        StaffId = staffId;
    }

    public String getLastUrge() {
        return lastUrge;
    }

    public void setLastUrge(String lastUrge) {
        this.lastUrge = lastUrge;
    }

    public String getRevokeDate() {
        return revokeDate;
    }

    public void setRevokeDate(String revokeDate) {
        this.revokeDate = revokeDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRethinDate() {
        return rethinDate;
    }

    public void setRethinDate(String rethinDate) {
        this.rethinDate = rethinDate;
    }

    public String getRethinDay() {
        return rethinDay;
    }

    public void setRethinDay(String rethinDay) {
        this.rethinDay = rethinDay;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEndReason() {
        return endReason;
    }

    public void setEndReason(String endReason) {
        this.endReason = endReason;
    }

    public String getRetainReason() {
        return retainReason;
    }

    public void setRetainReason(String retainReason) {
        this.retainReason = retainReason;
    }

    public String getRevokeReason() {
        return revokeReason;
    }

    public void setRevokeReason(String revokeReason) {
        this.revokeReason = revokeReason;
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    public List<Extend> getExtend() {
        return extend;
    }

    public void setExtend(List<Extend> extend) {
        this.extend = extend;
    }
}
