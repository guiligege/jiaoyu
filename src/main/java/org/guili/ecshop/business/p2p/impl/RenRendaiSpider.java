package org.guili.ecshop.business.p2p.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.jsoup.select.Elements;

/**
 * 人人贷spider
 * @author Administrator
 *
 */
public class RenRendaiSpider extends NetLicaiParent {
	private static Logger logger=Logger.getLogger(RenRendaiSpider.class);
	//http请求组件封装
	private HttpComponent httpComponent;
	
	private final RenrenListHandler renrenListHandler = new RenrenListHandler();
	
	private static final String USER_AGENT="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36";
	
	private static final String DETAIL_URL="http://www.renrendai.com/lend/detailPage.action?loanId=";
	@Override
	public SpiderType[] getSpiderType() {
		return new SpiderType[]{SpiderType.RENRENDAI};
	}

	/**
	 * 解析url
	 * @param listurl
	 * @return
	 */
	@Override
	public List<String> resolveUrls(String listurl){
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
			String pagexml=httpComponent.execute(httpGet, renrenListHandler);
//		     oneUrlList.addAll(this.build(pagexml));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return oneUrlList;
	}
	
	//renrendai list
	private class RenrenListHandler extends AbstractResponseHandler<String> {
        @Override
        public String handle(HttpEntity entity) throws IOException {
            String entityStr = EntityUtils.toString(entity);

            if (StringUtils.isBlank(entityStr)) {
                throw new RemoteServiceException();
            }
	            FileTools.write("E:/p2pwenda/p2peye_p2p_list.txt", entityStr);
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
//      FileTools.write("E:/p2pfile/renrendai_list.txt", pagexml);
//		try {
//			pagexml=FileTools.read("E:/p2pfile/renrendai_list.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		List<String> investUrls=new ArrayList<String>();
		JSONObject jsonObject = null; 
		jsonObject = JSONObject.fromObject(pagexml);
		JSONArray jsonArray=jsonObject.getJSONObject("data").getJSONArray("loans");
		if(jsonArray!=null && !jsonArray.isEmpty()){
			for(int i=0;i<jsonArray.size();i++){
				JSONObject one=jsonArray.getJSONObject(i);
				if("OPEN".equals(one.getString("status"))){
					System.out.println(DETAIL_URL+new Double(one.getDouble("loanId")).intValue());
					investUrls.add(DETAIL_URL+new Double(one.getDouble("loanId")).intValue());
				}
			}
		}
		
		return investUrls;
	}

	@Override
	public NetLcProduct createNetLcProduct(String pagexml,String url) {
//		FileTools.write("E:/p2pfile/renrendai_detail.txt", pagexml);
		try {
			pagexml=FileTools.read("E:/p2pfile/renrendai_detail.txt");
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
		String titleHead=doc.select(".ui-box-title").select("h3").text().trim();
		//标题
		String title=doc.select(".ui-box-title").select(".ui-box-username").text().trim();
		//基本信息
		Elements detailLis=doc.select(".loaninfo").select("div").select("dd");
		Elements baselis=doc.select(".basic-value");
		String totalMoney_text = detailLis.get(0).text().trim();
		String income_text = detailLis.get(1).text().trim();
		String day_text = detailLis.get(2).text().trim();
		
		String jindu_text= doc.select(".basic-progress-value").text().trim();
		String incometype_text=baselis.get(2).text().trim();
		String dailiCompany_text="无代理公司";
		String publishTime_text="";
		String detail_text=doc.select(".ui-tab-list").html().trim();
		
		 System.out.println("LujinsuoSpider-->totalMoney_text:"+totalMoney_text);
		 System.out.println("LujinsuoSpider-->income_text:"+income_text);
		 System.out.println("LujinsuoSpider-->day_text:"+day_text);
		 System.out.println("LujinsuoSpider-->jindu_text:"+jindu_text);
		 System.out.println("LujinsuoSpider-->incometype_text:"+incometype_text);
		 System.out.println("LujinsuoSpider-->dailiCompany_text:"+dailiCompany_text);
		 System.out.println("LujinsuoSpider-->detail_text:"+detail_text);
		 System.out.println("LujinsuoSpider-->publishTime_text:"+publishTime_text);
		 System.out.println("LujinsuoSpider-->title:"+titleHead+"-"+title);
		 
		 Double totalMoney=Double.parseDouble(totalMoney_text.replace(",", "").replace("￥", ""));
		 //创建NetLcProduct对象
		 NetLcProduct netLcProduct=new NetLcProduct();
		 netLcProduct.setCompanyId(getSpiderType()[0].getCompanyId());
		 netLcProduct.setCompanyName(getSpiderType()[0].getCompanyName());
		 netLcProduct.setTitle(("人人贷"+"-"+titleHead+"-"+title));
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
		 
		 jindu_text=jindu_text.replace("%", "");
		 if(jindu_text!=null && Validator.isNumber(jindu_text)){
			 netLcProduct.setJindu(Double.parseDouble(jindu_text));
		 }
		 netLcProduct.setDescrip(detail_text);
		 netLcProduct.setStatus(NetLcStatus.Available.getStatus());
		 //设置第三方网站地址
		 netLcProduct.setLinkurl(url);
		return netLcProduct;
	}
	
	
	public static void main(String[] args) {
		RenRendaiSpider lujinsuoSpider=new RenRendaiSpider();
		lujinsuoSpider.resolveUrls("http://www.licaime.com/question-993-2-1.htm");
//		lujinsuoSpider.build("aa");
//		try {
//			lujinsuoSpider.petDetailHttp("http://www.renrendai.com/lend/detailPage.action?loanId=606390");
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		lujinsuoSpider.createNetLcProduct("","http://www.renrendai.com/lend/detailPage.action?loanId=601537");
	}

	public HttpComponent getHttpComponent() {
		return httpComponent;
	}

	public void setHttpComponent(HttpComponent httpComponent) {
		this.httpComponent = httpComponent;
	}
	
}
