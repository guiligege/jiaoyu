package org.guili.ecshop.business.p2p.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.guili.ecshop.business.p2p.SpiderType;
import org.guili.ecshop.business.p2p.bean.NetLcCompany;
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
public class LicaiDianpingSpider extends NetLicaiParent {
	private static Logger logger=Logger.getLogger(LicaiDianpingSpider.class);
	//http请求组件封装
//	private HttpComponent httpComponent;
	private static final String HOSTS="https://www.jimubox.com";
	
	@Override
	public SpiderType[] getSpiderType() {
		return new SpiderType[]{SpiderType.LICAI_DIANPING};
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
        		System.out.println("LujinsuoSpider-->url:"+listurl);
        		try {
					urlList.addAll(resolveOneUrl(listurl));
				} catch (URISyntaxException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
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
//		if(listurl==null ||listurl.isEmpty()){
//			return oneUrlList;
//		}
//		//多url的情况
//		WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
//        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
//        wc.getOptions().setCssEnabled(false); //禁用css支持  
//        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
//        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
//        wc.getOptions().setTimeout(5000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
//        wc.setAjaxController(new NicelyResynchronizingAjaxController());
//        WebRequest innnerRequest = new WebRequest(new URL(listurl), HttpMethod.GET);
//		innnerRequest.setCharset("utf-8"); 
//        HtmlPage innerpage = wc.getPage(innnerRequest);
//        String pagexml = innerpage.asXml();
//        //解析列表页
////        FileTools.write("E:/p2pfile/niwodai_list.txt", pagexml);
        oneUrlList.addAll(this.build("aaa"));
//        wc.closeAllWindows();
		return oneUrlList;
	}
	
	private List<String> build(String pagexml){
//		FileTools.write("E:/p2pfile/licaidianping_list.txt", pagexml);
		if(pagexml.equals("")){
			return null;
		}
		try {
			pagexml=FileTools.read("E:/p2pfile/licaidianping_list.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> investUrls=new ArrayList<String>();
		Document doc = Jsoup.parse(pagexml);
		Elements invests=doc.select(".uibox-con");
		
		for(int i=0;i<=5;i++){
			Element invest=invests.get(i);
			Elements investsa= invest.select(".tit").select("a");
			if(investsa!=null && !investsa.isEmpty()){
				for(Element investa:investsa){
					System.out.println("detail url-->"+investa.attr("href"));
					String detailurl=investa.attr("href");
					investUrls.add(detailurl);
				}
			}
		}
//		Element invest=invests.get(0);
//		Elements investsa= invest.select(".tit").select("a");
//		if(investsa!=null && !investsa.isEmpty()){
//			for(Element investa:investsa){
//				System.out.println("detail url-->"+investa.attr("href"));
//				String detailurl=investa.attr("href");
//				investUrls.add(detailurl);
//			}
//		}
				
				
		return investUrls;
	}
	
	@Override
	public NetLcProduct createNetLcProduct(String pagexml,String url) {
		FileTools.write("E:/p2pfile/licaidianping_detail1.txt", pagexml);
		return null;
	}
	
	
	@Override
	public NetLcCompany createNetLcCompany(String pagexml,String url) {
//		FileTools.write("E:/p2pfile/licaidianping_detail1.txt", pagexml);
//		try {
//			pagexml=FileTools.read("E:/p2pfile/licaidianping_detail1.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		if(pagexml.equals("")){
			return null;
		}
		Document doc = Jsoup.parse(pagexml);
		//图片url
		Element details=doc.select(".details_box2").get(0);
		Elements detaillis=doc.select(".details_right").select(".item").select(".ic_2");
		
		String image=details.select(".t1").select("img").attr("src").trim();
		
		Element details_right=doc.select(".details_right").get(0);
		String companyName=details_right.select("h1").text().replace("人气", "").trim();
		//星级
		String star=details_right.select("h1").select("b").attr("class");
		//基本信息 
		//网址
		String companyurl = detaillis.get(1).select("a").attr("href");
		//运营公司
		String yunyingcompany = detaillis.get(2).attr("title");
		//运营地址
		String companyAddress = detaillis.get(3).attr("title");
		//法人
		String faren=detaillis.get(4).text().trim();
		//注册资金
		String zijin=detaillis.get(5).text().trim();
		//邮件地址
		String youjian=detaillis.get(7).text().trim();
		//公司电话
		String dianhua=detaillis.get(8).text().trim();
		//运营状态
		String yunyingstate=detaillis.get(9).text().trim();
		
		
		//优缺点
		Elements youqueNodes=doc.select(".infobox");
		String youdian=youqueNodes.get(0).select(".info_tab").select(".t2").html();
		String quedian=youqueNodes.get(1).select(".info_tab").get(0).select(".t2").html();
		//逾期处理
		String yuqi=youqueNodes.get(1).select(".info_tab").get(1).select(".t_03").html();
		
		//重要信息
		Elements important_Nodes=doc.select(".important_pro").first().select("li");
		String jiaoyi=important_Nodes.get(0).select(".fn_left").text().trim();
		String lilv=important_Nodes.get(1).select(".ic_2").text().trim();
		String rongzi=important_Nodes.get(2).select(".ic_2").text();
		String beijing=important_Nodes.get(3).select(".ic_2").text().trim().trim();
		
		//标的信息
		Elements otherinfoNodes=doc.select(".tab_content02").select("div");
		Elements oneInfos=otherinfoNodes.get(1).select(".item").select(".ic_2");
		//回款方式
		String shouyiType=oneInfos.get(0).attr("title").trim();
		//投资类型
		String touzitype=oneInfos.get(1).attr("title").trim();
		//产品系列
		String chanping=oneInfos.get(2).attr("title").trim();
		//投资起点
		String touziqidian=oneInfos.get(3).text().trim();
		//投资期限
		String touzishijian=oneInfos.get(4).text().trim();
		//投资规模
		String touziguimo=oneInfos.get(5).text().trim();
		//投资规模
		String qixishijian=oneInfos.get(6).select(".fn_left").text().trim();
		//变现速度
		String bianxiansudu=oneInfos.get(7).select(".fn_left").text().trim();
		
		//第二项
		Elements twoInfos=otherinfoNodes.get(2).select(".item").select(".ic_2");
		//回款方式
		String danbaoCompany=twoInfos.get(0).text().trim();
		//风险保证金
		String fengxianjin=twoInfos.get(1).text().trim();
		//自有风控团队
		String fengkong=twoInfos.get(2).text().trim();
		//抵押物
		String diya=twoInfos.get(3).text().trim();
		
		
		//第三项
		Elements threeInfos=otherinfoNodes.get(3).select(".item").select(".ic_2");
		//充值费
		String chongzhifei=threeInfos.get(0).text().trim();
		//提现费
		String tixianfei=threeInfos.get(1).select(".fn_left").text().trim();
		//其他费用
		String qitafei=threeInfos.get(3).text().trim();
		
		//第四项
		Elements fourInfos=otherinfoNodes.get(4).select(".item").select(".ic_2");
		//转让功能
		String zhuanrang=fourInfos.get(0).text().trim();
		//转让费
		String zhuanrangfei=fourInfos.get(2).select(".fn_left").text().trim();
		
		//第五项
		String rongziinfo=otherinfoNodes.get(5).html();
		
		//第六项
		Elements sixInfos=otherinfoNodes.get(6).select(".item").select("li");
		//支付方式
		String zhifuway=sixInfos.get(0).select("span").get(1).text().trim();
		//电子签章
		String dianziqian=sixInfos.get(1).select("span").get(1).text().trim();
		
		//网站介绍
		String jieshao=otherinfoNodes.get(7).html();
		
		Elements tabs=doc.select(".infobox3").select(".tab_content").select(".con");
		//重要事件汇总
		String importantInfo=tabs.get(0).html();
		String tuandui=tabs.get(1).html();
		
		System.out.println("image url-->companyName:"+companyName);
		System.out.println("image url-->star:"+star);
		System.out.println("image url-->companyurl:"+companyurl);
		System.out.println("image url-->yunyingcompany"+yunyingcompany);
		System.out.println("image url-->companyAddress:"+companyAddress);
		System.out.println("image url-->faren:"+faren);
		System.out.println("image url-->zijin:"+zijin);
		System.out.println("image url-->youjian:"+youjian);
		System.out.println("image url-->dianhua:"+dianhua);
		System.out.println("image url-->yunyingstate:"+yunyingstate);
		System.out.println("image url-->youdian:"+youdian);
		System.out.println("image url-->quedian:"+quedian);
		System.out.println("image url-->yuqi:"+yuqi);
		System.out.println("image url-->jiaoyi:"+jiaoyi);
		System.out.println("image url-->lilv:"+lilv);
		System.out.println("image url-->rongzi:"+rongzi);
		System.out.println("image url-->beijing:"+beijing);
		System.out.println("image url-->shouyiType:"+shouyiType);
		System.out.println("image url-->touzitype:"+touzitype);
		System.out.println("image url-->chanping:"+chanping);
		System.out.println("image url-->touziqidian:"+touziqidian);
		System.out.println("image url-->touzishijian:"+touzishijian);
		System.out.println("image url-->touziguimo:"+touziguimo);
		System.out.println("image url-->qixishijian:"+qixishijian);
		System.out.println("image url-->bianxiansudu:"+bianxiansudu);
		System.out.println("image url-->danbaoCompany:"+danbaoCompany);
		System.out.println("image url-->fengxianjin:"+fengxianjin);
		System.out.println("image url-->fengkong:"+fengkong);
		System.out.println("image url-->diya:"+diya);
		System.out.println("image url-->chongzhifei:"+chongzhifei);
		System.out.println("image url-->tixianfei:"+tixianfei);
		System.out.println("image url-->qitafei:"+qitafei);
		System.out.println("image url-->zhuanrang:"+zhuanrang);
		System.out.println("image url-->zhuanrangfei:"+zhuanrangfei);
		System.out.println("image url-->rongziinfo:"+rongziinfo);
		System.out.println("image url-->zhifuway:"+zhifuway);
		System.out.println("image url-->dianziqian:"+dianziqian);
		System.out.println("image url-->jieshao:"+jieshao);
		System.out.println("image url-->importantInfo:"+importantInfo);
		System.out.println("image url-->tuandui:"+tuandui);
		System.out.println("image url-->tuandui:"+tuandui.length());
		
		//防止超过长度
		if(bianxiansudu!=null && bianxiansudu.length()>20){
			bianxiansudu=bianxiansudu.substring(0, 19);
		}
		//防止超过长度
		if(chongzhifei!=null && chongzhifei.length()>20){
			chongzhifei=chongzhifei.substring(0, 19);
		}
		if(companyName.contains("低到无法统计")){
			companyName=companyName.replace("低到无法统计", "");
		}
		if(qitafei!=null && !qitafei.isEmpty() && qitafei.length()>100){
			qitafei=qitafei.substring(0, 99);
		}
		if(tixianfei.length()>20){
			tixianfei=tixianfei.substring(0, 19);
		}
		if(touzitype.length()>50){
			touzitype=touzitype.substring(0, 49);
		}
		if(yuqi.length()>400){
			yuqi=yuqi.substring(0, 399);
		}
		if(zhifuway.length()>30){
			zhifuway=zhifuway.substring(0, 29);
		}
		if(zhuanrangfei.length()>20){
			zhuanrangfei=zhuanrangfei.substring(0, 19);
		}
		if(dianziqian.length()>10){
			dianziqian="有";
		}
		if(tuandui.length()>3000){
			tuandui=tuandui.substring(0,2999);
		}
		NetLcCompany netLcCompany=new NetLcCompany();
		//0,民营，1国资，2.银行 3.上市公司.
		netLcCompany.setBeijing(getBeijing(beijing));
		netLcCompany.setBianxiansudu(bianxiansudu);
		netLcCompany.setChanping(chanping);
		
		netLcCompany.setChongzhifei(chongzhifei);
		netLcCompany.setCompanyAddress(companyAddress);
		netLcCompany.setCompanyHistory(importantInfo);
		netLcCompany.setCompanyInfo(jieshao);
		netLcCompany.setCompanyName(companyName);
		netLcCompany.setCompanyNameHash(netLcCompany.getCompanyName().hashCode());
		netLcCompany.setCompanyQuedian(quedian);
		netLcCompany.setCompanytuandui(tuandui);
		netLcCompany.setCompanyYoudian(youdian);
		netLcCompany.setCreateTime(new Date());
		netLcCompany.setDanbaoCompany(danbaoCompany);
		netLcCompany.setDianHua(dianhua);
		netLcCompany.setDianziqian(dianziqian);
		netLcCompany.setDiya(diya);
		netLcCompany.setEmail(youjian);
		netLcCompany.setFaRen(faren);
		netLcCompany.setFengkong(fengkong);
		netLcCompany.setFengxianjin(fengxianjin);
		netLcCompany.setHuikuanway(shouyiType);
		netLcCompany.setJiaoyi(jiaoyi);
		netLcCompany.setLilv(lilv);
		netLcCompany.setQitafei(qitafei);
		netLcCompany.setQixishijian(qixishijian);
		netLcCompany.setRegisterMoney(zijin);
		//网站人气   0,没星级，1.一星级，2，二星级，3，三星级，4，四星级，5,五星级
		netLcCompany.setRenQi(getRenqi(star));
		//0,未融资，1.A轮 2.B轮 3.C轮 4 ,D轮
		netLcCompany.setRongzi(getRongzi(rongzi));
		netLcCompany.setRongziinfo(rongziinfo);
		netLcCompany.setRunCompany(yunyingcompany);
		netLcCompany.setRunState(yunyingstate);
		netLcCompany.setSitelogo(image);
		netLcCompany.setSiteurl(companyurl);
		netLcCompany.setStatus(0);
		netLcCompany.setTixianfei(tixianfei);
		netLcCompany.setTouziguimo(touziguimo);
		netLcCompany.setTouziqidian(touziqidian);
		netLcCompany.setTouzishijian(touzishijian);
		netLcCompany.setTouzitype(touzitype);
		netLcCompany.setUpdateTime(new Date());
		netLcCompany.setYuqichuli(yuqi);
		netLcCompany.setZhifuway(zhifuway);
		netLcCompany.setZhuanrang(zhuanrang);
		netLcCompany.setZhuanrangfei(zhuanrangfei);
//		this.makeImg(image, "E:/p2p_image/");
		return netLcCompany; 
	}
	
	/**
	 * 获取背景id
	 * @param beijing
	 * @return
	 */
	private Integer getBeijing(String beijing){
		if(StringUtils.isEmpty(beijing)){
			return 0;
		}else if(beijing.equals("民营")){
			return 0;
		}else if(beijing.equals("国资")){
			return 1;
		}else if(beijing.equals("银行")){
			return 2;
		}else if(beijing.equals("上市公司")){
			return 3;
		}else{
			return 0;
		}
	}
	/**
	 * 获取星级
	 * @param star
	 * @return
	 */
	private Integer getRenqi(String star){
		if(star.isEmpty()){
			return 0;
		}else if(star.contains("star5")){
			return 5;
		}else if(star.contains("star4")){
			return 4;
		}else if(star.contains("star3")){
			return 3;
		}else if(star.contains("star2")){
			return 2;
		}else if(star.contains("star1")){
			return 1;
		}
		else {
			return 0;
		}
	}
	/**
	 * 
	 * @param imgUrl
	 * @param fileURL
	 */
	private Integer getRongzi(String rongzi){
		if(rongzi.isEmpty()){
			return 0;
		}else if(rongzi.contains("暂无融资轮")){
			return 0;
		}else if(rongzi.contains("A轮")){
			return 1;
		}else if(rongzi.contains("B轮")){
			return 2;
		}else if(rongzi.contains("C轮")){
			return 3;
		}else if(rongzi.contains("D轮")){
			return 4;
		}else if(rongzi.contains("E轮")){
			return 5;
		}else if(rongzi.contains("上市")){
			return 6;
		}
		else {
			return 0;
		}
	}
	
	 // 生成图片函数  
    private  void makeImg(String imgUrl,String fileURL) {
        try {  
  
            // 创建流  
            BufferedInputStream in = new BufferedInputStream(new URL(imgUrl)  
                    .openStream());  
            // 生成图片名  
            int index = imgUrl.lastIndexOf("/");  
            String sName = imgUrl.substring(index+1, imgUrl.length());  
            System.out.println(sName);  
            // 存放地址  
            File img = new File(fileURL+sName);  
            // 生成图片  
            BufferedOutputStream out = new BufferedOutputStream(  
                    new FileOutputStream(img));  
            byte[] buf = new byte[2048];  
            int length = in.read(buf);  
            while (length != -1) {  
                out.write(buf, 0, length);  
                length = in.read(buf);  
            }  
            in.close();  
            out.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
	
	public static void main(String[] args) {
		LicaiDianpingSpider lujinsuoSpider=new LicaiDianpingSpider();
//		lujinsuoSpider.build("https://www.jimubox.com/Project/ProjectSet/jk/2015-06-06_13:00");
		lujinsuoSpider.makeImg("http://www.76676.com/uploadfile/p2plogo/jimuhezi_b.jpg","E:/p2p_image/");
//		try {
////			lujinsuoSpider.resolveUrls("https://www.jimubox.com/Project/ProjectSet/jk/2015-06-06_13:00");
////			lujinsuoSpider.resolveOneUrl("http://www.76676.com/html/product/product_p2p/");
//			lujinsuoSpider.petDetailHttp("http://www.76676.com/show-20-104-1.html");
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		lujinsuoSpider.createNetLcCompany("","");
	}
}
