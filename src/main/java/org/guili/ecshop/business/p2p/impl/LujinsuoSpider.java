package org.guili.ecshop.business.p2p.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.apache.log4j.Logger;
import org.guili.ecshop.business.p2p.SpiderType;
import org.guili.ecshop.business.p2p.bean.NetLcProduct;
import org.guili.ecshop.util.FileTools;
import org.guili.ecshop.util.HttpComponent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * 陆金所spider
 * @author Administrator
 *
 */
public class LujinsuoSpider extends NetLicaiParent {
	private static Logger logger=Logger.getLogger(LujinsuoSpider.class);
	//http请求组件封装
	private HttpComponent httpComponent;
	
	@Override
	public SpiderType[] getSpiderType() {
		return new SpiderType[]{SpiderType.LUJINSUO,SpiderType.LUJINSUO_LC,SpiderType.LUJINSUO_TZ};
	}

	/**
	 * 解析url
	 * @param listurl
	 * @return
	 */
	@Override
	public List<String> resolveUrls(String listurl){
		return null;
	}

	@Override
	public NetLcProduct createNetLcProduct(String pagexml,String url) {
		try {
			pagexml=FileTools.read("E:/p2pfile/lujinsuodetail.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(pagexml.equals("")){
			return null;
		}
		Document doc = Jsoup.parse(pagexml);
		//标题项目
		Elements headlis=doc.select(".breadcrumb").get(0).select("li");
		String titleHead="";
		if(headlis.size()>3){
			titleHead=headlis.get(2).select("a").html();
		}
		//标题
		String title=doc.select(".product-code").html().trim();
		//基本信息
		Elements detailLis=doc.select(".product-detail-info").select(".detail-info-list").select("li");
		String totalMoney_text = detailLis.get(0).select("strong").html().trim();
		String income_text = detailLis.get(1).select("strong").html().trim();
		String day_text = detailLis.get(2).select("strong").html().trim();
		String jindu_text= doc.select(".progressTxt").html().trim();
		String incometype_text=doc.select(".tips-title").html().trim();
		String dailiCompany_text=doc.select(".bank-support").html().trim();
		String publishTime_text=doc.select(".product-published-date").html().trim();
		String detail_text=doc.select(".detail-content-body").select(".info").html().trim();
		 System.out.println("LujinsuoSpider-->totalMoney_text:"+totalMoney_text);
		 System.out.println("LujinsuoSpider-->income_text:"+income_text);
		 System.out.println("LujinsuoSpider-->day_text:"+day_text);
		 System.out.println("LujinsuoSpider-->jindu_text:"+jindu_text);
		 System.out.println("LujinsuoSpider-->incometype_text:"+incometype_text);
		 System.out.println("LujinsuoSpider-->dailiCompany_text:"+dailiCompany_text);
		 System.out.println("LujinsuoSpider-->detail_text:"+detail_text);
		 System.out.println("LujinsuoSpider-->publishTime_text:"+publishTime_text);
		return null;
	}
	
	
	public static void main(String[] args) {
		LujinsuoSpider lujinsuoSpider=new LujinsuoSpider();
//		try {
//			lujinsuoSpider.petDetailHttp("https://list.lufax.com/list/productDetail?productId=1457843&lufax_ref=https%3A%2F%2Flist.lufax.com%2Flist%2Fpiaoju");
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		lujinsuoSpider.createNetLcProduct("","https://list.lufax.com/list/productDetail?productId=1465735");
	}
	
	/********getter setter*******/
	public HttpComponent getHttpComponent() {
		return httpComponent;
	}

	public void setHttpComponent(HttpComponent httpComponent) {
		this.httpComponent = httpComponent;
	}

}
