package org.guili.ecshop.business.p2p.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * p2p理财机构信息
 * @author Administrator
 *
 */
public class NetLcCompany  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3773223160965017234L;

	private Integer   id;	    	//理财公司id
	private String companyName; 	//理财公司名称
	private Integer   companyNameHash;	    	//理财公司id
	private String companyCode; 	//理财公司编码
	private String companyAddress; 	//公司地址
	private String registerMoney;	//注册资金
	private String runState;	 	//运营状态
	private String email;			//公司邮箱
	private String runCompany;			//运营公司
	private String faRen;			//公司法人
	private Integer renQi;			//网站人气   0,没星级，1.一星级，2，二星级，3，三星级，4，四星级，5,五星级
	private String dianHua;			//网站电话
	private String companyYoudian;			//网站优点
	private String companyQuedian;			//网站缺点
	private String sitelogo;			//网站logo
	private String siteurl;			//网址
	private String jiaoyi;			//网站交易
	private String lilv;			//网站利率范围
	private Integer rongzi;			//网站融资信息 0,未融资，1.A轮 2.B轮 3.C轮 4 ,D轮
	private Integer beijing;			//#网站背景信息 0,民营，1国资，2.银行 3.上市公司.
	private String yuqichuli;			//#网站逾期处理
	private String huikuanway;			//#网站收益方式
	private String chanping;			//#网站产品系列
	private String touzishijian;			//#网站投资时间
	private String qixishijian;			//#网站起息时间
	private String touzitype;			//#网站投资类型(车贷/房贷/企业贷/信用贷)
	private String touziqidian;			//#网站投资起点金额
	private String touziguimo;			//#网站投资规模
	private String bianxiansudu;			//#网站提现速度
	private String danbaoCompany;			//#网站担保公司
	private String fengkong;			//#网站风控团队
	private String fengxianjin;			//#网站风险保证金
	private String diya;			//#网站抵押物
	private String chongzhifei;			//#网站充值费
	private String tixianfei;			//#网站提现费
	private String qitafei;			//#网站其他费
	private String zhuanrang;			//#网站转让功能
	private String zhuanrangfei;			//#转让手续费
	private String rongziinfo;			//#融资情况
	private String zhifuway;			//#支付方式
	private String dianziqian;			//#电子签章
	private String companyInfo;			//#网站介绍
	private String companyHistory;			//#网站大事记
	private String companytuandui;			//#网站创始团队
	private Date createTime; 		//项目开始时间
	private Date updateTime;			//#更新时间
	private Integer orderid; 		//排序
	private Integer status; 		//状态 1.有效，0，无效
	
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getRegisterMoney() {
		return registerMoney;
	}
	public void setRegisterMoney(String registerMoney) {
		this.registerMoney = registerMoney;
	}
	public String getRunState() {
		return runState;
	}
	public void setRunState(String runState) {
		this.runState = runState;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRunCompany() {
		return runCompany;
	}
	public void setRunCompany(String runCompany) {
		this.runCompany = runCompany;
	}
	public String getFaRen() {
		return faRen;
	}
	public void setFaRen(String faRen) {
		this.faRen = faRen;
	}
	public String getDianHua() {
		return dianHua;
	}
	public void setDianHua(String dianHua) {
		this.dianHua = dianHua;
	}
	public String getCompanyYoudian() {
		return companyYoudian;
	}
	public void setCompanyYoudian(String companyYoudian) {
		this.companyYoudian = companyYoudian;
	}
	public String getCompanyQuedian() {
		return companyQuedian;
	}
	public void setCompanyQuedian(String companyQuedian) {
		this.companyQuedian = companyQuedian;
	}
	public String getSitelogo() {
		return sitelogo;
	}
	public void setSitelogo(String sitelogo) {
		this.sitelogo = sitelogo;
	}
	public String getSiteurl() {
		return siteurl;
	}
	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}
	public String getJiaoyi() {
		return jiaoyi;
	}
	public void setJiaoyi(String jiaoyi) {
		this.jiaoyi = jiaoyi;
	}
	public String getLilv() {
		return lilv;
	}
	public void setLilv(String lilv) {
		this.lilv = lilv;
	}
	public Integer getRongzi() {
		return rongzi;
	}
	public void setRongzi(Integer rongzi) {
		this.rongzi = rongzi;
	}
	public Integer getBeijing() {
		return beijing;
	}
	public void setBeijing(Integer beijing) {
		this.beijing = beijing;
	}
	public String getYuqichuli() {
		return yuqichuli;
	}
	public void setYuqichuli(String yuqichuli) {
		this.yuqichuli = yuqichuli;
	}
	public String getHuikuanway() {
		return huikuanway;
	}
	public void setHuikuanway(String huikuanway) {
		this.huikuanway = huikuanway;
	}
	public String getChanping() {
		return chanping;
	}
	public void setChanping(String chanping) {
		this.chanping = chanping;
	}
	public String getTouzishijian() {
		return touzishijian;
	}
	public void setTouzishijian(String touzishijian) {
		this.touzishijian = touzishijian;
	}
	public String getQixishijian() {
		return qixishijian;
	}
	public void setQixishijian(String qixishijian) {
		this.qixishijian = qixishijian;
	}
	public String getTouzitype() {
		return touzitype;
	}
	public void setTouzitype(String touzitype) {
		this.touzitype = touzitype;
	}
	public String getTouziqidian() {
		return touziqidian;
	}
	public void setTouziqidian(String touziqidian) {
		this.touziqidian = touziqidian;
	}
	public String getTouziguimo() {
		return touziguimo;
	}
	public void setTouziguimo(String touziguimo) {
		this.touziguimo = touziguimo;
	}
	public String getBianxiansudu() {
		return bianxiansudu;
	}
	public void setBianxiansudu(String bianxiansudu) {
		this.bianxiansudu = bianxiansudu;
	}
	public String getDanbaoCompany() {
		return danbaoCompany;
	}
	public void setDanbaoCompany(String danbaoCompany) {
		this.danbaoCompany = danbaoCompany;
	}
	public String getFengkong() {
		return fengkong;
	}
	public void setFengkong(String fengkong) {
		this.fengkong = fengkong;
	}
	public String getFengxianjin() {
		return fengxianjin;
	}
	public void setFengxianjin(String fengxianjin) {
		this.fengxianjin = fengxianjin;
	}
	public String getDiya() {
		return diya;
	}
	public void setDiya(String diya) {
		this.diya = diya;
	}
	public String getChongzhifei() {
		return chongzhifei;
	}
	public void setChongzhifei(String chongzhifei) {
		this.chongzhifei = chongzhifei;
	}
	public String getTixianfei() {
		return tixianfei;
	}
	public void setTixianfei(String tixianfei) {
		this.tixianfei = tixianfei;
	}
	public String getQitafei() {
		return qitafei;
	}
	public void setQitafei(String qitafei) {
		this.qitafei = qitafei;
	}
	public String getZhuanrang() {
		return zhuanrang;
	}
	public void setZhuanrang(String zhuanrang) {
		this.zhuanrang = zhuanrang;
	}
	public String getZhuanrangfei() {
		return zhuanrangfei;
	}
	public void setZhuanrangfei(String zhuanrangfei) {
		this.zhuanrangfei = zhuanrangfei;
	}
	public String getRongziinfo() {
		return rongziinfo;
	}
	public void setRongziinfo(String rongziinfo) {
		this.rongziinfo = rongziinfo;
	}
	public String getZhifuway() {
		return zhifuway;
	}
	public void setZhifuway(String zhifuway) {
		this.zhifuway = zhifuway;
	}
	public String getDianziqian() {
		return dianziqian;
	}
	public void setDianziqian(String dianziqian) {
		this.dianziqian = dianziqian;
	}
	public String getCompanyHistory() {
		return companyHistory;
	}
	public void setCompanyHistory(String companyHistory) {
		this.companyHistory = companyHistory;
	}
	public String getCompanytuandui() {
		return companytuandui;
	}
	public void setCompanytuandui(String companytuandui) {
		this.companytuandui = companytuandui;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getRenQi() {
		return renQi;
	}
	public void setRenQi(Integer renQi) {
		this.renQi = renQi;
	}
	public Integer getCompanyNameHash() {
		return companyNameHash;
	}
	public void setCompanyNameHash(Integer companyNameHash) {
		this.companyNameHash = companyNameHash;
	}
	
	public NetLcCompanyVO getNetLcCompanyVO(){
		NetLcCompanyVO netLcCompanyVO=new NetLcCompanyVO();
		netLcCompanyVO.setCompanyName(this.companyName);
		netLcCompanyVO.setId(this.id);
		return netLcCompanyVO;
	}
	
}
