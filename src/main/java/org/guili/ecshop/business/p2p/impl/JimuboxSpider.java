package org.guili.ecshop.business.p2p.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.guili.ecshop.business.p2p.SpiderType;
import org.guili.ecshop.business.p2p.bean.NetLcProduct;
import org.guili.ecshop.business.p2p.bean.NetLcStatus;
import org.guili.ecshop.util.FileTools;
import org.guili.ecshop.util.HttpComponent;
import org.guili.ecshop.util.common.Validator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * 积木盒子spider
 * @author Administrator
 *
 */
public class JimuboxSpider extends NetLicaiParent {
	private static Logger logger=Logger.getLogger(JimuboxSpider.class);
	//http请求组件封装
//	private HttpComponent httpComponent;
	private static final String HOSTS="https://www.jimubox.com";
	
	@Override
	public SpiderType[] getSpiderType() {
		return new SpiderType[]{SpiderType.JIMUBOX};
	}
	
	/**
	 * 解析url
	 * @param listurl
	 * @return
	 */
	@Override
	public List<String> resolveUrls(String listurl){
		System.out.println("LujinsuoSpider-->listurl:"+listurl);
		//创建wc
		WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(false); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        wc.getOptions().setTimeout(5000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
        wc.setAjaxController(new NicelyResynchronizingAjaxController());
        WebRequest innnerRequest;
        List<String> urlList=new ArrayList<String>();
		try {
			innnerRequest = new WebRequest(new URL(listurl), HttpMethod.GET);
			innnerRequest.setCharset("utf-8"); 
	        HtmlPage innerpage = wc.getPage(innnerRequest);
	        String pagexml = innerpage.asXml();
//	        FileTools.write("E:/p2pfile/jimuboxlist.txt", pagexml);
	        Document doc = Jsoup.parse(pagexml);
	        Elements projectLis=doc.select(".project-name").select("a");
	        if(projectLis!=null && !projectLis.isEmpty()){
	        	for(Element projectLi:projectLis){
	        		String url=projectLi.attr("href");
	        		System.out.println("LujinsuoSpider-->url:"+url);
	        		try {
						urlList.addAll(resolveOneUrl(HOSTS+url));
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
	        	}
	        }
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return urlList;
	}
	
	/**
	 * 解析列表url
	 * @param listurl
	 * @return
	 */
	private List<String> resolveOneUrl(String listurl)throws URISyntaxException, IOException{
		List<String> oneUrlList=new ArrayList<String>();
		if(listurl.contains("/Project/Index")){
			oneUrlList.add(listurl);
			return oneUrlList;
		}
		//多url的情况
		WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(false); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        wc.getOptions().setTimeout(5000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
        wc.setAjaxController(new NicelyResynchronizingAjaxController());
        WebRequest innnerRequest = new WebRequest(new URL(listurl), HttpMethod.GET);
		innnerRequest.setCharset("utf-8"); 
        HtmlPage innerpage = wc.getPage(innnerRequest);
        String pagexml = innerpage.asXml();
        //解析列表页
        oneUrlList.addAll(this.build(pagexml));
        wc.closeAllWindows();
		return oneUrlList;
	}
	
	private List<String> build(String pagexml){
		if(pagexml.equals("")){
			return null;
		}
		List<String> investUrls=new ArrayList<String>();
		Document doc = Jsoup.parse(pagexml);
		Elements invests=doc.select(".invest");
		if(invests!=null && !invests.isEmpty()){
			for(Element invest:invests){
				System.out.println("detail url-->"+invest.attr("href"));
				String detailurl=invest.attr("href");
				if(!detailurl.contains(HOSTS)){
					detailurl=HOSTS+detailurl;
				}
				investUrls.add(detailurl);
			}
		}
		return investUrls;
	}
	
	@Override
	public NetLcProduct createNetLcProduct(String pagexml,String url) {
//		try {
//			pagexml=FileTools.read("E:/p2pfile/jimubox.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		if(pagexml.equals("")){
			return null;
		}
		Document doc = Jsoup.parse(pagexml);
		//标题项目
		String title=doc.select(".project-title").select("h2").text().trim();
		//基本信息
		Elements detailLis=doc.select(".project-base-info").select("li");
		Elements headLis=doc.select(".project-attribute").select("span");
		
		String totalMoney_text = detailLis.get(2).text().trim();
		String income_text = detailLis.get(0).select(".important").text().trim();
		String day_text = detailLis.get(1).select(".data-tips").text().trim();
		String jindu_text= doc.select(".status-container").select("span").text().trim();
		String incometype_text=detailLis.get(0).select(".data-tips").attr("data-content");
		String dailiCompany_text=headLis.get(0).select("a").text().trim();
		String publishTime_text="";
		String detail_text=doc.select(".project-description").html().trim();
		StringBuffer detail_sub=new StringBuffer();
		Elements span6=doc.select(".span6");
		if(span6.size()>0){
			for(int i=0;i<span6.size();i++){
				Elements  span6dd=span6.get(i).select("dd");
				Elements  span6dt=span6.get(i).select("dt");
				if(span6dd.size()>0){
					for(int j=0;j<span6dd.size();j++){
						detail_sub.append(span6dt.get(j).text()+":"+span6dd.get(j).text()+SPLIT);
					}
				}
			}
		}
		Elements span10=doc.select(".span10");
		if(span10.size()>0){
			for(int i=0;i<span10.size();i++){
				Elements  span6dd=span10.get(i).select("dd");
				Elements  span6dt=span10.get(i).select("dt");
				if(span6dd.size()>0){
					for(int j=0;j<span6dd.size();j++){
						detail_sub.append(span6dt.get(j).text()+":"+span6dd.get(j).text()+SPLIT);
					}
				}
			}
		}
		 System.out.println("LujinsuoSpider-->title:"+(dailiCompany_text+"-"+title));
		 System.out.println("LujinsuoSpider-->totalMoney_text:"+totalMoney_text);
		 System.out.println("LujinsuoSpider-->income_text:"+income_text);
		 System.out.println("LujinsuoSpider-->day_text:"+day_text);
		 System.out.println("LujinsuoSpider-->jindu_text:"+jindu_text);
		 System.out.println("LujinsuoSpider-->incometype_text:"+incometype_text);
		 System.out.println("LujinsuoSpider-->dailiCompany_text:"+dailiCompany_text);
		 System.out.println("LujinsuoSpider-->detail_text:"+detail_text);
		 System.out.println("LujinsuoSpider-->publishTime_text:"+publishTime_text);
		 System.out.println("LujinsuoSpider-->detail_sub:"+detail_sub);
		 System.out.println("LujinsuoSpider-->companyId:"+SpiderType.JIMUBOX.getCompanyId());
		 System.out.println("LujinsuoSpider-->companyName:"+SpiderType.JIMUBOX.getCompanyName());
		 
		 Double totalMoney=Double.parseDouble(totalMoney_text.replace(" 万", ""))*10000;
		 //创建NetLcProduct对象
		 NetLcProduct netLcProduct=new NetLcProduct();
		 netLcProduct.setCompanyId(getSpiderType()[0].getCompanyId());
		 netLcProduct.setCompanyName(getSpiderType()[0].getCompanyName());
		 netLcProduct.setTitle((dailiCompany_text+"-"+title));
		 netLcProduct.setTitlehash(new Long(netLcProduct.getTitle().hashCode()));
		 netLcProduct.setTotalMoney(totalMoney);
		 netLcProduct.setCreateTime(new Date());
		 netLcProduct.setDailiCompany(dailiCompany_text);
		 netLcProduct.setDays(day_text);
		 if(income_text!=null && Validator.isNumber(income_text)){
			 netLcProduct.setIncome(Double.parseDouble(income_text));
		 }
		 netLcProduct.setIncometype(incometype_text);
		 if(jindu_text!=null && Validator.isNumber(jindu_text)){
			 netLcProduct.setJindu(Double.parseDouble(jindu_text));
		 }
		 netLcProduct.setDescrip(detail_text+"<br/><br/>"+detail_sub);
		 netLcProduct.setStatus(NetLcStatus.Available.getStatus());
		 //设置第三方网站地址
		 netLcProduct.setLinkurl(url);
		return netLcProduct;
	}
	
	
	public static void main(String[] args) {
		JimuboxSpider lujinsuoSpider=new JimuboxSpider();
//		lujinsuoSpider.build("https://www.jimubox.com/Project/ProjectSet/jk/2015-06-06_13:00");
		lujinsuoSpider.resolveUrls("https://www.jimubox.com/Project/List?status=1&flag=close");
//		try {
//			lujinsuoSpider.resolveUrls("https://www.jimubox.com/Project/ProjectSet/jk/2015-06-06_13:00");
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		lujinsuoSpider.createNetLcProduct("");
	}
}
