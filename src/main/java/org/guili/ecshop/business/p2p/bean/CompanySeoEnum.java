package org.guili.ecshop.business.p2p.bean;
/**
 * 关键字
 * @author Administrator
 *
 */
public enum CompanySeoEnum {
	
	JIMUBOX("积木盒子","积木盒子 ,积木盒子安全吗 ,积木盒子怎么样,积木盒子可靠吗","积木盒子 ,积木盒子怎么样"),
	LUXFUN("陆金所","平安陆金所 , 陆金所理财产品 陆金所官网 ,陆金所怎么样","平安陆金所 ,陆金所理财产品,陆金所怎么样"),
	YOULI("有利网","有利网怎么样 ,有利网, 有利网理财可靠吗","有利网,有利网怎么样"),
	RENRENDAI("人人贷","人人贷官网,人人贷怎么样 ,人人贷可靠吗","人人贷 ,人人贷怎么样 "),
	YILONGDAI("翼龙贷","翼龙贷网可靠吗,翼龙贷网,翼龙贷网怎么样","翼龙贷网 ,翼龙贷网怎么样 "),
	;
	private String company;
	private String keywords;
	private String title;
	
	
	private CompanySeoEnum(String company,String keywords,String title){
		this.company=company;
		this.keywords=keywords;
		this.title=title;
	}
	
	public String getKeywords(){
		return this.keywords;
	}
	
	//查找标签对应关键字
	public static String getKeyOneWords(String company){
		for(CompanySeoEnum seoEnum:CompanySeoEnum.values()){
			if(seoEnum.company.equals(company)){
				return seoEnum.keywords;
			}
		}
		String title=company+","+company+"怎么样,"+company+"可靠吗,"+company+"安全吗 ";
		return title;
	}
	
	public static String getOneTitle(String company){
		for(CompanySeoEnum seoEnum:CompanySeoEnum.values()){
			if(seoEnum.company.equals(company)){
				return seoEnum.title;
			}
		}
		String title=company+","+company+"怎么样"+","+company+"安全吗";
		return title;
	}
}
