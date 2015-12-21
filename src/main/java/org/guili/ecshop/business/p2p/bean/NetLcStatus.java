package org.guili.ecshop.business.p2p.bean;

/**
 * 爬虫类型
 * @author Administrator
 *
 */
public enum NetLcStatus {
	Available(1),
	UNAvailable(0),
	;
    // 成员变量
    private int status;//companyid

    // 构造方法
    private NetLcStatus(int status) {
        this.status = status;
    }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
