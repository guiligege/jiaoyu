package org.guili.ecshop.business.p2p.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.guili.ecshop.business.p2p.SpiderType;
import org.guili.ecshop.business.p2p.bean.NetLcProduct;
import org.guili.ecshop.business.p2p.bean.NetLcStatus;
import org.guili.ecshop.exception.RemoteServiceException;
import org.guili.ecshop.util.AbstractResponseHandler;
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
 *你我贷spider
 * @author Administrator
 *
 */
public class TounaSpider extends NetLicaiParent {
	private static Logger logger=Logger.getLogger(TounaSpider.class);
	//http请求组件封装
//	private HttpComponent httpComponent;
	private static final String HOSTS="http://www.touna.cn/";
	private static final Integer pagenum=2;
	//http请求组件封装
	private HttpComponent httpComponent;
	
	private final TounaListHandler tounaListHandler = new TounaListHandler();
	
	private static final String USER_AGENT="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36";
	
	private static final String DETAIL_URL="http://www.touna.cn/borrow-detail.do?borrowid=";
	
	@Override
	public SpiderType[] getSpiderType() {
		return new SpiderType[]{SpiderType.TOUNA};
	}
	
	/**
	 * 解析url
	 * @param listurl
	 * @return
	 */
	@Override
	public List<String> resolveUrls(String listurl){
		System.out.println("LujinsuoSpider-->listurl:"+listurl);
		long start=System.currentTimeMillis();
		//查询多页数据，并返回
		List<String> urlList=new ArrayList<String>();
        if(listurl!=null && !listurl.isEmpty()){
        	for(int i=0;i<=pagenum;i++){
        		String url=listurl.substring(0, listurl.length()-1)+i;
        		System.out.println("tounaSpider-->url:"+url);
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
        httpComponent=new HttpComponent();
		HttpGet httpGet = new HttpGet(listurl);
		//设置user-Agent
		httpGet.addHeader("User-Agent", USER_AGENT);
//		httpComponent.setProxy("116.66.40.220",8080 );
		try {
			String pagexml=httpComponent.execute(httpGet, tounaListHandler);
		     oneUrlList.addAll(this.build(pagexml));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return oneUrlList;
	}
	
	//renrendai list
	private class TounaListHandler extends AbstractResponseHandler<String> {
	        @Override
	        public String handle(HttpEntity entity) throws IOException {
	            String entityStr = EntityUtils.toString(entity);

	            if (StringUtils.isBlank(entityStr)) {
	                throw new RemoteServiceException();
	            }
//		            FileTools.write("E:/spiderfile/ganjitestdetail1.txt", entityStr);
	            if(entityStr==null || entityStr.length()<20384){
	            	logger.error("connect Exception----entityStr.length() is so short");
	            }
	            return entityStr;
	        }
		}
	
	private List<String> build(String pagexml){
		if(pagexml.equals("")){
			return null;
		}
//		FileTools.write("E:/p2pfile/touna_list.txt", pagexml);
//		try {
//			pagexml=FileTools.read("E:/p2pfile/touna_list.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		List<String> investUrls=new ArrayList<String>();
		JSONObject jsonObject = null; 
		jsonObject = JSONObject.fromObject(pagexml);
		JSONArray jsonArray=jsonObject.getJSONObject("result").getJSONArray("list");
		if(jsonArray!=null && !jsonArray.isEmpty()){
			for(int i=0;i<jsonArray.size();i++){
				JSONObject one=jsonArray.getJSONObject(i);
				if("1".equals(one.getString("status"))){
					System.out.println(DETAIL_URL+new Double(one.getDouble("id")).intValue());
					investUrls.add(DETAIL_URL+new Double(one.getDouble("id")).intValue());
				}
			}
		}
		return investUrls;
	}
	
	@Override
	public NetLcProduct createNetLcProduct(String pagexml,String url) {
//		FileTools.write("E:/p2pfile/touna_detail.txt", pagexml);
//		try {
//			pagexml=FileTools.read("E:/p2pfile/touna_detail.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		if(pagexml.equals("")){
//			return null;
//		}
		Document doc = Jsoup.parse(pagexml);
		//标题项目
		String title=doc.select("#bname").text().trim();
		//基本信息
		String totalMoney_text = doc.select("#account").text().trim();
		String income_text = doc.select("#apr").text().trim();
		String day_text = doc.select("#time_limit").text().trim();
		String jindu_text= doc.select(".progress-percent").text().replace("%", "").trim();
		String incometype_text= doc.select("#repay_type").text().trim();
		String dailiCompany_text="投哪网";
		String publishTime_text="";
		String detail_text="";
		
		 System.out.println("LujinsuoSpider-->title:"+(dailiCompany_text+"-"+title));
		 System.out.println("LujinsuoSpider-->totalMoney_text:"+totalMoney_text);
		 System.out.println("LujinsuoSpider-->income_text:"+income_text);
		 System.out.println("LujinsuoSpider-->day_text:"+day_text);
		 System.out.println("LujinsuoSpider-->jindu_text:"+jindu_text);
		 System.out.println("LujinsuoSpider-->incometype_text:"+incometype_text);
		 System.out.println("LujinsuoSpider-->dailiCompany_text:"+dailiCompany_text);
		 System.out.println("LujinsuoSpider-->detail_text:"+detail_text);
		 System.out.println("LujinsuoSpider-->publishTime_text:"+publishTime_text);
		 System.out.println("LujinsuoSpider-->companyId:"+getSpiderType()[0].getCompanyId());
		 System.out.println("LujinsuoSpider-->companyName:"+getSpiderType()[0].getCompanyName());
		 
		 Double totalMoney=Double.parseDouble(totalMoney_text.replace(",", ""));
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
		 netLcProduct.setDescrip(detail_text);
		 netLcProduct.setStatus(NetLcStatus.Available.getStatus());
//		 设置第三方网站地址
		 netLcProduct.setLinkurl(url);
		return netLcProduct;
	}
	
	
	public static void main(String[] args) {
		TounaSpider lujinsuoSpider=new TounaSpider();
//		lujinsuoSpider.build("https://www.jimubox.com/Project/ProjectSet/jk/2015-06-06_13:00");
		lujinsuoSpider.resolveUrls("http://www.touna.cn/borrow.do?method=list&status=0&size=10&subtime=1433955135795&page=2");
		
//		try {
//			lujinsuoSpider.resolveOneUrl("http://www.touna.cn/borrow.do?method=list&status=0&size=10&subtime=1433955135795&page=0");
////			lujinsuoSpider.petDetailHttp("http://www.touna.cn/borrow-detail.do?borrowid=247049");
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		lujinsuoSpider.createNetLcProduct("","https://member.niwodai.com/xiangmu/v-ADRUNlYxVT8FalRkUDVeago1VWwCYgJhBTAFNwBmU2Y=.html");
	}

	public HttpComponent getHttpComponent() {
		return httpComponent;
	}

	public void setHttpComponent(HttpComponent httpComponent) {
		this.httpComponent = httpComponent;
	}
	
	
}
