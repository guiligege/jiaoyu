package org.guili.ecshop.business.p2p.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.guili.ecshop.business.p2p.INetLcDetailService;
import org.guili.ecshop.business.p2p.IProductService;
import org.guili.ecshop.business.p2p.bean.NetLcCompany;
import org.guili.ecshop.business.p2p.bean.NetLcProduct;
import org.guili.ecshop.util.FileTools;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * 对所有p2p理财抓取的抽象
 * @author Administrator
 *
 */
public abstract class NetLicaiParent implements IProductService {

	private static Logger logger=Logger.getLogger(NetLicaiParent.class);
	private INetLcDetailService netLcDetailService;
	protected  final String SPLIT="<br/>";
	protected static final Integer TIME_OUT=2500;
	/**
	 * 批量抓取宠物数据
	 * @param listurl
	 */
	@Override
	public void batCrawlPet(String listurl){
		Date start=new Date(); 
		if(listurl.isEmpty()){
			return;
		}
		if(listurl.startsWith("http://www.76676.com/") && listurl.contains("ONE") ){
			//理财公司
			try {
				NetLcCompany netLcCompany=this.netLcCompanyDetailHttp(listurl);
				//添加单个理财公司
				netLcDetailService.addNetLcCompany(netLcCompany);
			} catch (URISyntaxException e) {
				logger.error("batCrawlPet URISyntaxException listurl is not a url:"+e.getStackTrace());
			} catch (IOException e) {
				logger.error("batCrawlPet IOException :"+e.getStackTrace());
			}
			return;
			//写入理财产品
//			netLcDetailService.addNetLcCompany(netLcCompanys.get(0));
//			netLcDetailService.saveNetLcProductList(batPetSaleInfo);
//			netLcDetailService.batSaveNetLcCompany(netLcCompanys);
		}else if(listurl.startsWith("http://www.76676.com/")){
			//理财公司
			List<NetLcCompany>  netLcCompanys=new ArrayList<NetLcCompany>();
			try {
				netLcCompanys=this.getCompanyListInfo(listurl);
			} catch (URISyntaxException e) {
				logger.error("batCrawlPet URISyntaxException listurl is not a url:"+e.getStackTrace());
			} catch (IOException e) {
				logger.error("batCrawlPet IOException :"+e.getStackTrace());
			}
			if(netLcCompanys.isEmpty()){
				logger.info("batPetSaleInfo.isEmpty !!");
				return;
			}
			//写入理财产品
//			netLcDetailService.addNetLcCompany(netLcCompanys.get(0));
//			netLcDetailService.saveNetLcProductList(batPetSaleInfo);
//			netLcDetailService.batSaveNetLcCompany(netLcCompanys);
		}else{
			//理财产品
			List<NetLcProduct>  batPetSaleInfo=new ArrayList<NetLcProduct>();
			try {
				batPetSaleInfo=this.getPetListInfo(listurl);
			} catch (URISyntaxException e) {
				logger.error("batCrawlPet URISyntaxException listurl is not a url:"+e.getStackTrace());
			} catch (IOException e) {
				logger.error("batCrawlPet IOException :"+e.getStackTrace());
			}
			if(batPetSaleInfo.isEmpty()){
				logger.info("batPetSaleInfo.isEmpty !!");
				return;
			}
			//写入理财产品
			netLcDetailService.saveNetLcProductList(batPetSaleInfo);
		}
        logger.info("spider cost total time:"+(new Date().getTime()-start.getTime()));
	}
	
	@Override
	public List<NetLcProduct> getPetListInfo(String listurl)
			throws URISyntaxException, IOException {
		logger.info("LujinsuoSpider-->getPetListInfo:url:"+listurl);
		List<String> listurls=resolveUrls(listurl);
		List<NetLcProduct> netLcProductList=new ArrayList<NetLcProduct>();
		if(listurls!=null && !listurls.isEmpty()){
			for(String detailUrl:listurls){
				try {
					NetLcProduct netLcProduct=this.petDetailHttp(detailUrl);
					if(netLcProduct!=null){ 
						netLcProductList.add(netLcProduct);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		return netLcProductList;
	}
	
	private  List<NetLcCompany> getCompanyListInfo(String listurl)
			throws URISyntaxException, IOException {
		logger.info("LujinsuoSpider-->getPetListInfo:url:"+listurl);
		List<String> listurls=resolveUrls(listurl);
		List<NetLcCompany> netLcCompanyList=new ArrayList<NetLcCompany>();
		if(listurls!=null && !listurls.isEmpty()){
			for(String detailUrl:listurls){
				try {
					NetLcCompany netLcCompany=this.netLcCompanyDetailHttp(detailUrl);
					//添加单个理财公司
					netLcDetailService.addNetLcCompany(netLcCompany);
					if(netLcCompany!=null){ 
						netLcCompanyList.add(netLcCompany);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		return netLcCompanyList;
	}
	
	private NetLcCompany netLcCompanyDetailHttp(String detailUrl)throws URISyntaxException, IOException {
		
		System.out.println("LujinsuoSpider-->petDetailHttp:detailUrl:"+detailUrl);
		//创建wc
		WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(false); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        wc.getOptions().setTimeout(TIME_OUT); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
        wc.setAjaxController(new NicelyResynchronizingAjaxController());
        WebRequest innnerRequest = new WebRequest(new URL(detailUrl), HttpMethod.GET);
		innnerRequest.setCharset("utf-8"); 
        HtmlPage innerpage = wc.getPage(innnerRequest);
        String pagexml = innerpage.asXml();
        //构造p2p理财对象
        NetLcCompany netLcProduct=createNetLcCompany(pagexml,detailUrl);
        wc.closeAllWindows();
		return netLcProduct;
	}
	
	/**
	 * 父类默认实现一个方法，子类再实现才可覆盖
	 * @param pagexml
	 * @param detailUrl
	 * @return
	 */
	public  NetLcCompany createNetLcCompany(String pagexml,String detailUrl){
		NetLcCompany netLcCompany=new NetLcCompany();
		return netLcCompany;
	}
	
	@Override
	public NetLcProduct petDetailHttp(String detailUrl)throws URISyntaxException, IOException {
		
		System.out.println("LujinsuoSpider-->petDetailHttp:detailUrl:"+detailUrl);
		//创建wc
		WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(false); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        wc.getOptions().setTimeout(TIME_OUT); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
        wc.setAjaxController(new NicelyResynchronizingAjaxController());
        WebRequest innnerRequest = new WebRequest(new URL(detailUrl), HttpMethod.GET);
		innnerRequest.setCharset("utf-8"); 
        HtmlPage innerpage = wc.getPage(innnerRequest);
        String pagexml = innerpage.asXml();
        //构造p2p理财对象
        NetLcProduct netLcProduct=createNetLcProduct(pagexml,detailUrl);
        wc.closeAllWindows();
		return netLcProduct;
	}
	
	/*****************getter and setter***************/
	public INetLcDetailService getNetLcDetailService() {
		return netLcDetailService;
	}
	public void setNetLcDetailService(INetLcDetailService netLcDetailService) {
		this.netLcDetailService = netLcDetailService;
	}

}
