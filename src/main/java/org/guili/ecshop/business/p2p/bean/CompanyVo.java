package org.guili.ecshop.business.p2p.bean;
import java.io.Serializable;
import java.util.List;
/**
 * 理财问题
 * @author guili
 */
public class CompanyVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 111L;
	private NetLcCompany company;
	
	public NetLcCompany getCompany() {
		return company;
	}
	public void setCompany(NetLcCompany company) {
		this.company = company;
	}
	
}
