package org.guili.ecshop.business.p2p;

import java.util.List;

import org.guili.ecshop.business.p2p.bean.CompanyPageParam;
import org.guili.ecshop.business.p2p.bean.CwPageParam;
import org.guili.ecshop.business.p2p.bean.NetLcCompany;
import org.guili.ecshop.business.p2p.bean.NetLcProduct;

/**
 * p2p理财产品接口
 * @author Administrator
 *
 */
public interface INetLcDetailService {

	/**
	 * 新增p2p理财信息
	 * @param petSaleInfo
	 * @return
	 */
	public int addNetLcProduct(NetLcProduct netLcProduct);
	
	/**
	 * 根据信息id查询p2p理财
	 * @param id
	 * @return
	 */
	public NetLcProduct selectNetLcProductById(Long id);
	
	/**
	 * 批量新增p2p理财信息
	 * @param petSaleInfo
	 * @return
	 */
	public void saveNetLcProductList(List<NetLcProduct> netLcProductList);
	
	/**
	 * 根据titlehash查询是否重复
	 * @param Hash
	 * @return
	 */
	public Integer selectNetLcProductByHash(Long Hash);
	
	/**
	 * 根据条件，查询p2p理财总数
	 * @param cwPageParam
	 * @return
	 */
	public Integer selectNetLcProductCount(CwPageParam cwPageParam);
	
	/**
	 * 分页查询p2p理财
	 * @param start
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<NetLcProduct> selectNetLcProductPage(int start,int pageSize,CwPageParam cwPageParam);
	
	/**
	 * 查找相关p2p理财
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<NetLcProduct> selectLikeThis(Integer size,
			CwPageParam cwPageParam);
	
	
	/**
	 * 查找推荐p2p理财
	 * @param size
	 * @return
	 */
	public List<NetLcProduct> selectTuijian(Integer size);
	
	/**
	 * 根据Id查询p2p理财信息
	 * @param pageParam
	 * @return
	 */
	public NetLcCompany selectNetLcCompanyById(Long id) throws Exception;
	
	/**
	 * 查找推荐p2p理财
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<NetLcCompany> selectAllNetLcCompany();
	
	/**
	 * 添加理财银行
	 * @param netLcCompany
	 * @return
	 */
	public int addNetLcCompany(NetLcCompany netLcCompany);
	
	public void batSaveNetLcCompany(List<NetLcCompany> netLcCompanyList);
	
	/**
	 * 根据条件，查询p2p理财总数
	 * @param cwPageParam
	 * @return
	 */
	public Integer selectNetLcCompanyCount(CompanyPageParam cwPageParam);
	
	/**
	 * 分页查询p2p理财信息
	 * @param start
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<NetLcCompany> selectNetLcCompanyPage(Integer start, Integer pageSize,
			CompanyPageParam cwPageParam) ;
}
