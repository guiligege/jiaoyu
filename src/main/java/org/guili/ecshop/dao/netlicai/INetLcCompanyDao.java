package org.guili.ecshop.dao.netlicai;
import java.util.List;

import org.guili.ecshop.business.p2p.bean.CompanyPageParam;
import org.guili.ecshop.business.p2p.bean.CwPageParam;
import org.guili.ecshop.business.p2p.bean.NetLcCompany;
import org.guili.ecshop.business.p2p.bean.NetLcProduct;
/**
 * p2p理财dao
 * @author guili
 */
public interface INetLcCompanyDao {
	
	/**
	 * 根据Id查询p2p理财信息
	 * @param pageParam
	 * @return
	 */
	public NetLcCompany selectNetLcCompanyById(Long id) throws Exception;
	
	/**
	 * 根据title的hash值，查询p2p理财
	 * @param Hash
	 * @return
	 */
	public Integer selectNetLcCompanyByHash(Integer companyNameHash);
	
	/**
	 * 查找推荐p2p理财
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<NetLcCompany> selectAllNetLcCompany();
	
	/**
	 * 添加p2p理财公司
	 * @param netLcCompany
	 * @return
	 * @throws Exception
	 */
	public int addNetLcCompany(NetLcCompany netLcCompany);
	
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
