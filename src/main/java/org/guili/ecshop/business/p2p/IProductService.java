package org.guili.ecshop.business.p2p;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.guili.ecshop.business.p2p.bean.NetLcProduct;

/**
 * 商品服务接口
 * @ClassName:   IProductService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2014-1-13 下午4:11:27 
 */
public interface IProductService {
	
	
	public SpiderType [] getSpiderType();
	
	/**
	 * 抓取理财信息列表
	 * @param listurl 宠物信息列表url
	 * 	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public List<NetLcProduct> getPetListInfo(String listurl) throws URISyntaxException, IOException;
	
	/**
	 * 获取单个p2p理财信息
	 * @param detailturl
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public NetLcProduct petDetailHttp(String detailUrl)throws URISyntaxException, IOException;
	
	/**
	 * 抓取并保持信息
	 * @param listurl
	 */
	public void batCrawlPet(String listurl);
	
	public NetLcProduct createNetLcProduct(String pagexml,String url) ;
	
	public List<String> resolveUrls(String listurl);
	
	
}
