package org.guili.ecshop.business.p2p.bean;
/**
 * 关键字
 * @author Administrator
 *
 */
public enum SeoEnum {
	
	P2P_LICAI("P2P网络借贷平台","P2P网络借贷平台,p2p投资理财平台,p2p网贷平台,p2p理财论坛","P2P网络借贷平台,p2p投资理财平台"),
	P2P_LICAI_PRODUCT("理财产品","理财产品,高收益理财产品,互联网理财产品,个人理财产品,个人投资理财产品","理财产品,短期理财产品"),
	NET_LICAI("互联网理财","互联网理财,互联网理财产品,互联网投资理财,互联网理财产品排行榜","互联网理财,互联网投资"),
	ZHUANQIAN("赚钱","赚钱,互联网赚钱,钱生钱","赚钱,钱生钱"),
	PERSON_LICAI("个人理财","个人理财,个人投资理财,小额投资理财,个人如何理财投资 ,个人投资理财入门","个人理财,个人投资理财方法")
	;
	private String biaoqian;
	private String keywords;
	private String title;
	
	
	private SeoEnum(String biaoqian,String keywords,String title){
		this.biaoqian=biaoqian;
		this.keywords=keywords;
		this.title=title;
	}
	
	public String getKeywords(){
		return this.keywords;
	}
	
	//查找标签对应关键字
	public static String getKeyOneWords(String biaoqian){
		for(SeoEnum seoEnum:SeoEnum.values()){
			if(seoEnum.biaoqian.equals(biaoqian)){
				return seoEnum.keywords;
			}
		}
		return null;
	}
	
	public static String getOneTitle(String biaoqian){
		for(SeoEnum seoEnum:SeoEnum.values()){
			if(seoEnum.biaoqian.equals(biaoqian)){
				return seoEnum.title;
			}
		}
		return null;
	}
}
