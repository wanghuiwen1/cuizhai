
<html lang="en"  xmlns:th="http://www.thymeleaf.org" xmlns:shiro="http://www.pollix.at/thymeleaf/shiro">
<head>
    <meta charset="UTF-8"/>
    <title>委案管理</title>
    <div th:include="fragment/head :: head"></div>
</head>
<body>
#[[$END$]]#
</body>
<script th:src="@{/static/layui/layui.js}"></script>
<script th:inline="javascript">

/*<![CDATA[*/

/*]]>*/
</script>
</html>


类结构
实体类
	注解
	@Entity
	@Table(name = "t_user")
	继承
	extends BaseEntity
mapper接口
	注解
	@Mapper
	继承
	extends BaseMapper<实体类,实体ID类型>
provider类
	继承
	extends BaseProvider<实体类,实体ID类型>
service街口
	继承
	extends BaseService<实现类,实体类型ID>
service实现类
	注解
	@Service
	开启事务
	@Transactional
	继承
	extends BaseServiceImpl<实现类,实体类型ID>
	实现
	implements 实体的Service


1.催记导出不能是所有的，（根据委托日期查询）
2.减免（公式）减免金额=（总欠款-委外催收费）*减免比例+催收费
3.结案审核
4.承诺还款变粉色
5.分公司管理员（委案管理，员工管理）
6.有贝导入
7.撤案不显示
8.同一个案件不能上传两次
9.留案申请
10.结案申请审批
11.公告信息审批
12.补充协查信息导入
13.员工禁用
14.1分钟内不能做两次催记
15.逾期天数分段
16.回款率
17.同一合同号上传时分配到同一人
18.同一合同号或同一身份证号的案件首次分配到同一催收员




,
,
,
,
,
,
,
,
,
,
,


未付滞纳金
--合同申请日,
--合同数量,
--取消分期时间,
--佣金比例,
欠款金额
代扣开户行,
代扣账号,
商品
品牌
POS点
客户办公电话
客户公司名称
客户公司地址
客户公司部门
客户住宅电话
客户住宅地址


客户配偶姓名
客户配偶联系电话
客户亲戚姓名
客户与亲戚关系
客户亲戚联系电话
其他联系人姓名
其他联系人关系
其他联系人电话
客户邮箱
