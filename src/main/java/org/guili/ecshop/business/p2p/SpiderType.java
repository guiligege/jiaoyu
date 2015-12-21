package org.guili.ecshop.business.p2p;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 爬虫类型
 * @author Administrator
 *
 */
public enum SpiderType {
	LUJINSUO("LUJINSUO", 1,"陆金所"),
	LUJINSUO_LC("LUJINSUO_LC", 1,"陆金所"),
	LUJINSUO_TZ("LUJINSUO_TZ", 1,"陆金所"),
	RENRENDAI("RENRENDAI", 5,"人人贷"),
	JIMUBOX("JIMUBOX", 2,"积木盒子"),
	NIWIDAI("NIWIDAI", 3,"你我贷"),
	TOUNA("TOUNA", 4,"投哪网"),
	YIRENDAI("YIRENDAI", 6,"宜人贷"),
	LICAI_DIANPING("LICAI_DIANPING", 0,"理财点评"),
	//微信抓取
	WEIXIN("WEIXIN", 0,"微信抓取"),
	;
    // 成员变量
    private String name;
    private int companyId;//companyid
    private String companyName;

    // 构造方法
    private SpiderType(String name, int companyId,String companyName) {
        this.name = name;
        this.companyId = companyId;
        this.companyName=companyName;
    }

    /**
     * 根据名称获取SpiderType
     * @param spiderType
     * @return
     */
    public static SpiderType getSpiderTypeByName(String spiderType){
    	if(StringUtils.isEmpty(spiderType)){
    		return null;
    	}
    	spiderType=spiderType.toUpperCase();
    	if(spiderType.equals("LUJINSUO")){
    		return LUJINSUO;
    	} else if(spiderType.equals("RENRENDAI")){
    		return RENRENDAI;
    	}else if(spiderType.equals("JIMUBOX")){
    		return JIMUBOX;
    	}else{
    		return null;
    	}
    }
    // 普通方法
    public static String getName(int companyId) {
        for (SpiderType c : SpiderType.values()) {
            if (c.getCompanyId() == companyId) {
                return c.name;
            }
        }
        return null;
    }

	public String getName() {
		return name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
}
