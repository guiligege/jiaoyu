package org.guili.ecshop.business.p2p.bean;

import java.io.Serializable;
/**
 * p2p理财机构信息
 * @author Administrator
 *
 */
public class NetLcCompanyVO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -377322316096522234L;

	private Integer   id;	    	//理财公司id
	private String companyName; 	//理财公司名称
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
