package org.guili.ecshop.business.p2p.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
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
 *宜人贷spider
 * @author Administrator
 *
 */
public class YirenSpider extends NetLicaiParent {
	private static Logger logger=Logger.getLogger(YirenSpider.class);
	//http请求组件封装
//	private HttpComponent httpComponent;
	private static final String HOSTS="http://www.yirendai.com/";
	private static final Integer pagenum=3;
	
	@Override
	public SpiderType[] getSpiderType() {
		return new SpiderType[]{SpiderType.YIRENDAI};
	}
	
	/**
	 * 解析url
	 * @param listurl
	 * @return
	 */
	@Override
	public List<String> resolveUrls(String listurl){
		System.out.println("yirendaiSpider-->listurl:"+listurl);
		long start=System.currentTimeMillis();
		//查询多页数据，并返回
		List<String> urlList=new ArrayList<String>();
        if(listurl!=null && !listurl.isEmpty()){
        	for(int i=1;i<=pagenum;i++){
        		String url=listurl.substring(0, listurl.length()-1)+i;
        		System.out.println("yirendaiSpider-->url:"+url);
        		try {
					urlList.addAll(resolveOneUrl(url));
				} catch (URISyntaxException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        System.out.println("总共耗时："+(System.currentTimeMillis()-start)/1000+"s");
		return urlList;
	}
	
	/**
	 * 解析列表url
	 * @param listurl
	 * @return
	 */
	private List<String> resolveOneUrl(String listurl)throws URISyntaxException, IOException{
		List<String> oneUrlList=new ArrayList<String>();
		if(listurl==null ||listurl.isEmpty()){
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
//		FileTools.write("E:/p2pfile/yirendai_list.txt", pagexml);
//		try {
//			pagexml=FileTools.read("E:/p2pfile/yirendai_list.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		List<String> investUrls=new ArrayList<String>();
		Document doc = Jsoup.parse(pagexml);
		Elements invests=doc.select(".bidList").select("li").select(".m-row-bid");
		Elements titles=doc.select(".bidList").select("li").select("h3");
		if(invests!=null && !invests.isEmpty()){
			for(int i=0;i<invests.size();i++){
				System.out.println("detail url-->"+HOSTS+titles.get(i).select("a").attr("href"));
				String detailurl=titles.get(i).select("a").attr("href");
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
//		FileTools.write("E:/p2pfile/yirendai_detail.txt", pagexml);
//		try {
//			pagexml=FileTools.read("E:/p2pfile/yirendai_detail.txt");
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
		String title=doc.select(".elite_tit").select("strong").text().trim();
		//基本信息
		Elements tabletd1=doc.select(".elite_table").select("tr").get(1).select("td");
		
		String totalMoney_text = tabletd1.get(0).text().trim();
		String income_text = tabletd1.get(1).text().trim();
		String day_text =  tabletd1.get(2).text().trim();
		String jindu_text= doc.select(".tender_completed").text().replace("投标完成", "").replace("%", "");
		String incometype_text=doc.select(".elite_table").select("tr").get(3).select("td").get(1).text().trim();
		String dailiCompany_text="宜人贷";
		String publishTime_text="";
		String detail_text="";
		StringBuffer detail_sub=new StringBuffer();
		
		Elements tds=doc.select(".basic_information").select("li");
		if(tds!=null && !tds.isEmpty()){
			for(int i=0;i<tds.size();i++){
					detail_sub.append(tds.get(i).text().trim()).append(SPLIT);
			}
		}
		Elements tabel_p=doc.select(".elite_left").select("p");
		detail_text=tabel_p.get(7).text();
		
		 System.out.println("LujinsuoSpider-->title:"+(dailiCompany_text+"-"+title));
		 System.out.println("LujinsuoSpider-->totalMoney_text:"+totalMoney_text);
		 System.out.println("LujinsuoSpider-->income_text:"+income_text);
		 System.out.println("LujinsuoSpider-->day_text:"+day_text);
		 System.out.println("LujinsuoSpider-->jindu_text:"+jindu_text);
		 System.out.println("LujinsuoSpider-->incometype_text:"+incometype_text);
		 System.out.println("LujinsuoSpider-->dailiCompany_text:"+dailiCompany_text);
		 System.out.println("LujinsuoSpider-->detail_text:"+detail_text);
		 System.out.println("LujinsuoSpider-->publishTime_text:"+publishTime_text);
		 System.out.println("LujinsuoSpider-->detail_sub:"+detail_sub.toString());
		 System.out.println("LujinsuoSpider-->companyId:"+getSpiderType()[0].getCompanyId());
		 System.out.println("LujinsuoSpider-->companyName:"+getSpiderType()[0].getCompanyName());
		 
		 Double totalMoney=Double.parseDouble(totalMoney_text.replace(",", "").replace(". 00", ""));
//		 创建NetLcProduct对象
		 NetLcProduct netLcProduct=new NetLcProduct();
		 netLcProduct.setCompanyId(getSpiderType()[0].getCompanyId());
		 netLcProduct.setCompanyName(getSpiderType()[0].getCompanyName());
		 netLcProduct.setTitle((dailiCompany_text+"-"+title));
		 netLcProduct.setTitlehash(new Long(netLcProduct.getTitle().hashCode()));
		 netLcProduct.setTotalMoney(totalMoney);
		 netLcProduct.setCreateTime(new Date());
		 netLcProduct.setDailiCompany(dailiCompany_text);
		 netLcProduct.setDays(day_text+"月");
		 
		 income_text=income_text.replace(" %", "");
		 if(income_text!=null && Validator.isNumber(income_text)){
			 netLcProduct.setIncome(Double.parseDouble(income_text));
		 }
		 netLcProduct.setIncometype(incometype_text);
		 if(jindu_text!=null && Validator.isNumber(jindu_text)){
			 netLcProduct.setJindu(Double.parseDouble(jindu_text));
		 }
		 netLcProduct.setDescrip(detail_text+"<br/><br/>"+detail_sub);
		 netLcProduct.setStatus(NetLcStatus.Available.getStatus());
//		 设置第三方网站地址
		 netLcProduct.setLinkurl(url);
		return netLcProduct;
	}
	
	
	public static void main(String[] args) {
		YirenSpider lujinsuoSpider=new YirenSpider();
//		lujinsuoSpider.build("https://www.jimubox.com/Project/ProjectSet/jk/2015-06-06_13:00");
		lujinsuoSpider.resolveUrls("http://www.yirendai.com/loan/list/3");
//		lujinsuoSpider.resolveUrls("https://member.niwodai.com/loan/loan.do?slist=,1,&totalCount=40&pageNo=1");
//		try {
//			lujinsuoSpider.resolveOneUrl("http://www.yirendai.com/loan/list/1");
////			lujinsuoSpider.petDetailHttp("http://www.yirendai.com/loan/view/512359");
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		lujinsuoSpider.createNetLcProduct("","https://member.niwodai.com/xiangmu/v-ADRUNlYxVT8FalRkUDVeago1VWwCYgJhBTAFNwBmU2Y=.html");
	}
}
