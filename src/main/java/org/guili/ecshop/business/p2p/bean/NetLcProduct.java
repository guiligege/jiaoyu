package org.guili.ecshop.business.p2p.bean;
import java.io.Serializable;
import java.util.Date;
/**
 * p2p理财产品对象
 * @author guili
 */
public class NetLcProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2545603327029547399L;
	private Long   id;		 	//产品主键
	//商品基本信息
	private String title;		//机构名称
	private Long titlehash; 	//产品名称
	private String days; 			//投资期限
	private Double income;		//预期年化收益率
	private Double totalMoney;  //项目总金额
	private Double nowMoney; 	//可投资总金额
	private Double leastMoney; 	//最少投资金额
	private Integer companyId;	//理财公司id
	private String companyName; //理财公司名称
	private String dailiCompany;//代理方名称
	private Date createTime; 	//项目开始时间
	private Date endTime;		//项目结束时间
	private String descrip;		//项目描述
	private String licaimeDescrip;		//理财么描述
	private Integer status;  		//项目状态
	private Double jindu;		//项目进度
	private String incometype;  //收益类型
	private String linkurl;  //收益类型
	
	
	public String getIncometype() {
		return incometype;
	}
	public void setIncometype(String incometype) {
		this.incometype = incometype;
	}
	public Double getJindu() {
		return jindu;
	}
	public void setJindu(Double jindu) {
		this.jindu = jindu;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Double getNowMoney() {
		return nowMoney;
	}
	public void setNowMoney(Double nowMoney) {
		this.nowMoney = nowMoney;
	}
	public Double getLeastMoney() {
		return leastMoney;
	}
	public void setLeastMoney(Double leastMoney) {
		this.leastMoney = leastMoney;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDailiCompany() {
		return dailiCompany;
	}
	public void setDailiCompany(String dailiCompany) {
		this.dailiCompany = dailiCompany;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getLicaimeDescrip() {
		return licaimeDescrip;
	}
	public void setLicaimeDescrip(String licaimeDescrip) {
		this.licaimeDescrip = licaimeDescrip;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getTitlehash() {
		return titlehash;
	}
	public void setTitlehash(Long titlehash) {
		this.titlehash = titlehash;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getLinkurl() {
		return linkurl;
	}
	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}
	
}
