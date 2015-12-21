package org.guili.ecshop.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.guili.ecshop.util.FileTools;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;

/**
 * 代理检查工具
 * @author zhengdong.xiao
 *
 */
public class DailiUtils {
	
	public static List<String> available_Ips=new ArrayList<String>();
	public static   String[] all_ips=new String[1000];
	
	public static Map<String, String> cookies=new HashMap<String, String>();
	
	static{
		all_ips=new String[]{
				"61.220.216.102:8080",
				"101.251.211.234:80",
				"116.211.87.130:80",
				"117.177.243.43:81",
				"117.177.243.43:82",
				"117.177.243.43:83",
				"117.177.243.43:84",
				"117.177.243.43:86",
				"117.177.243.43:8081",
				"117.177.243.43:8082",
				"117.177.243.43:8083",
				"119.147.161.55:3128",
				"119.187.148.35:80",
				"119.188.115.23:8088",
				"122.72.18.160:80",
				"122.228.92.103:80",
				"202.194.101.150:80",
				"111.161.126.99:80",
				"58.242.145.227:8080",
				"60.29.248.142:8080",
				"111.161.126.98:80",
				"111.161.126.99:80",
				"111.161.126.100:80",
				"111.161.126.101:80",
				"117.177.243.43:81",
				"117.177.243.43:82",
				"117.177.243.43:83",
				"117.177.243.43:84",
				"117.177.243.43:86",
				"117.177.243.43:8081",
				"117.177.243.43:8082",
				"117.177.243.43:8083",
				"120.198.237.5:80",
				"120.198.237.5:8088",
				"120.198.237.5:9000",
				"125.88.144.179:8080"

				};
		
		//SNUID,SUID,SUV
		cookies.put("SNUID", "");
		cookies.put("SUID", "");
		cookies.put("SUV", "");
//		cookies=new String[]{
//				"72940BFC888C962B5259520789E0D438,FB1D83752708930A0000000055E4E2EA,007A78B175831DFB55E4E426AD0C6158",
//				"628719EF999C87397B283D9F9A5A7134,FB1D83752708930A0000000055E4E4AB,0056783975831DFB55E4E4ABCF4A7380",
//				"638A14ED979D86347E12CEC998BD964B,FB1D83752708930A0000000055E4E4E7,009C7E8F75831DFB55E4E4E8FBB48320",
//				"FE19877004001AA6ED9FED1D0510956B,FB1D83752708930A0000000055E4E51F,00A7150A75831DFB55E4E51F6D023801",
//				"66831DE89E98833D70ABFF7E9ECE6983,FB1D83752708930A0000000055E4E56D,00517C4F75831DFB55E4E56E85AA4113"};
		
	}
	public void validateIps(){
		//创建wc
			final WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
	        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
	        wc.getOptions().setCssEnabled(false); //禁用css支持  
	        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
	        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
	        wc.getOptions().setTimeout(2000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
	        wc.setAjaxController(new NicelyResynchronizingAjaxController());
	        for(String ip_port:all_ips){
	        	if(StringUtils.isEmpty(ip_port)){
	        		break;
	        	}
	        	System.out.println(ip_port);
	        	String ip=ip_port.split(":")[0];
	        	String port=ip_port.split(":")[1];
	        	ProxyConfig proxyConfig=new ProxyConfig(ip, Integer.parseInt(port));
		        wc.getOptions().setProxyConfig(proxyConfig);
				//所有详细理财产品详细页
		        List<String> urllist=new ArrayList<String>();
				String pageXml="";
				WebRequest request;
				try {
					request = new WebRequest(new URL("https://www.baidu.com/"), HttpMethod.GET);
					request.setCharset("utf-8"); 
					long start=System.currentTimeMillis();
					HtmlPage page = (HtmlPage)wc.getPage(request);
			        if(!page.asXml().isEmpty() && page.asXml().length()>1000){
			        	System.out.println("花费时间:"+(System.currentTimeMillis()-start)+"ms");
			        	if((System.currentTimeMillis()-start)/1000<5){
			        		
			        		available_Ips.add(ip_port);
			        		System.out.println("\""+ip_port+"\",");
			        		FileTools.appendToFile("E:/proxy/success.txt", "\""+ip_port+"\",");
			        	}
			        }
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (FailingHttpStatusCodeException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	}
	
	public static Map<String, String> initCookies(){
		//创建wc
		final WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(false); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        wc.getOptions().setTimeout(2000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
        wc.setAjaxController(new NicelyResynchronizingAjaxController());
        WebRequest request;
		try {
			request = new WebRequest(new URL("http://weixin.sogou.com/gzh?openid=oIWsFtxiqAdkQPc0LRTrOJu1MY5w"), HttpMethod.GET);
			request.setCharset("utf-8"); 
	        HtmlPage page = (HtmlPage)wc.getPage(request);
	        CookieManager cm= wc.getCookieManager();
	        Set<Cookie> cookies=cm.getCookies();
	        for(Cookie ck:cookies){
//	        	System.out.println(ck.getName()+":"+ck.getValue());
	        	if(ck.getName().equals("SNUID")){
	        		DailiUtils.cookies.put("SNUID", ck.getValue());
	        	}
	        	if(ck.getName().equals("SUID")){
	        		DailiUtils.cookies.put("SUID", ck.getValue());
	        	}
	        	if(ck.getName().equals("SUV")){
	        		DailiUtils.cookies.put("SUV", ck.getValue());
	        	}
	        }
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void getips(String sourceFile,String tofile){
        File file = new File(sourceFile);// 指定要读取的文件 
        // 获得该文件的缓冲输入流  
        BufferedReader bufferedReader=null;
        BufferedWriter out = null;  
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tofile, true)));  
	           
			 String line = "";// 用来保存每次读取一行的内容  
	        while ((line = bufferedReader.readLine()) != null) {  
	        	if(line.contains("@")){
	        		String ip=line.substring(0, line.indexOf("@"));
	        		out.write("\""+ip+"\",");
	 	            out.newLine();
	        	}
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			 try {  
	                out.close(); 
	                bufferedReader.close();
	            } catch (IOException e) {  
	                e.printStackTrace();  
	        }  
		}
	} 
	
	public  Map<String, String> testdaili(){
		//创建wc
//		final WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
		WebClient wc = new WebClient(BrowserVersion.FIREFOX_24,"202.194.101.150",80);
		
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(false); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        wc.getOptions().setTimeout(2000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
        wc.setAjaxController(new NicelyResynchronizingAjaxController());
//        String ip_port="202.194.101.150:80";
//		String ip=ip_port.split(":")[0];
//    	String port=ip_port.split(":")[1];
//    	ProxyConfig proxyConfig=new ProxyConfig(ip, Integer.parseInt(port));
//        wc.getOptions().setProxyConfig(proxyConfig);
        WebRequest request;
		try {
			request = new WebRequest(new URL("http://www.licaime.com/question-2194-2-1.htm"), HttpMethod.GET);
			request.setCharset("utf-8"); 
	        HtmlPage page = (HtmlPage)wc.getPage(request);
	        CookieManager cm= wc.getCookieManager();
	        Set<Cookie> cookies=cm.getCookies();
	        for(Cookie ck:cookies){
	        	System.out.println(ck.getName()+":"+ck.getValue());
	        }
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getRandomIp(){
		Random random=new Random();
		return DailiUtils.all_ips[random.nextInt(DailiUtils.all_ips.length)];
	}
	
//	public String getRandomCookie(){
//		Random random=new Random();
//		String cookie=DailiUtils.cookies[random.nextInt(DailiUtils.cookies.length)];
//		System.out.println(cookie);
//		return cookie;
//	}
	public static void main(String[] args) {
		DailiUtils dailiUtils=new DailiUtils();
		dailiUtils.validateIps();
//		dailiUtils.getCookies();
//		DailiUtils.getips("E:/proxy/test.txt", "E:/proxy/temp.txt");
//		dailiUtils.getRandomIp();
//		dailiUtils.getRandomCookie();
//		dailiUtils.initCookies();
//		dailiUtils.testdaili();
	}

}
