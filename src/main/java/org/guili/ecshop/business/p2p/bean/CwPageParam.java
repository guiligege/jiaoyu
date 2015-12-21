package org.guili.ecshop.business.p2p.bean;

/**
 * 用于分页查询的参数
 * @author guili
 */
public class CwPageParam {
	//筛选条件
	private Integer companyId;//公司id
	private Integer status;//理财产品状态
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
