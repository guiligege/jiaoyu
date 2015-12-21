package org.guili.ecshop.dao.netlicai;
import java.util.List;

import org.guili.ecshop.business.p2p.bean.CwPageParam;
import org.guili.ecshop.business.p2p.bean.NetLcProduct;
/**
 * p2p理财dao
 * @author guili
 */
public interface INetLcDetailDao {
	/**
	 * 添加p2p理财信息
	 * @param lcProduct
	 * @return
	 * @throws Exception
	 */
	public int addNetLcProduct(NetLcProduct netLcProduct);
	
	/**
	 * 根据Id查询p2p理财信息
	 * @param pageParam
	 * @return
	 */
	public NetLcProduct selectNetLcProductById(Long id) throws Exception;
	
	/**
	 * 根据title的hash值，查询p2p理财
	 * @param Hash
	 * @return
	 */
	public Integer selectNetLcProductByHash(Long titlehash);
	
	
	/**
	 * 根据条件，查询p2p理财总数
	 * @param cwPageParam
	 * @return
	 */
	public Integer selectNetLcProductCount(CwPageParam cwPageParam);
	
	/**
	 * 分页查询p2p理财信息
	 * @param start
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<NetLcProduct> selectNetLcProductPage(Integer start, Integer pageSize,
			CwPageParam cwPageParam) ;
	
	/**
	 * 查找相关p2p理财
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<NetLcProduct> selectLikeThis(Integer size,CwPageParam cwPageParam);
	
	/**
	 * 查找推荐p2p理财
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<NetLcProduct> selectTuijian(Integer size);
}
