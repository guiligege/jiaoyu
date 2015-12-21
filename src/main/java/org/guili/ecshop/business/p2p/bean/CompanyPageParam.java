package org.guili.ecshop.business.p2p.bean;

/**
 * 用于分页查询的参数
 * @author guili
 */
public class CompanyPageParam {
	//筛选条件
	private Integer beijing;//公司背景 0,民营，1国资，2.银行 3.上市公司.
	private Integer renqi;	//平台人气 0,没星级，1.一星级，2，二星级，3，三星级，4，四星级，5,五星级
	private Integer rongzi;	//融资信息0,未融资，1.A轮 2.B轮 3.C轮 4 ,D轮
	private Integer status; //网站状态
	
	public Integer getBeijing() {
		return beijing;
	}
	public void setBeijing(Integer beijing) {
		this.beijing = beijing;
	}
	public Integer getRenqi() {
		return renqi;
	}
	public void setRenqi(Integer renqi) {
		this.renqi = renqi;
	}
	public Integer getRongzi() {
		return rongzi;
	}
	public void setRongzi(Integer rongzi) {
		this.rongzi = rongzi;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
