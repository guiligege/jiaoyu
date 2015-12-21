package org.guili.ecshop.impl.netlicai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.guili.ecshop.business.p2p.bean.CwPageParam;
import org.guili.ecshop.business.p2p.bean.NetLcProduct;
import org.guili.ecshop.dao.netlicai.INetLcDetailDao;
import org.guili.ecshop.util.BasicSqlSupport;

/**
 * 用户注册登录dao
 * @author jumbo
 */
public class NetLcDetailDao extends BasicSqlSupport  implements INetLcDetailDao {

	private static Logger logger=Logger.getLogger(NetLcDetailDao.class);

	@Override
	public int addNetLcProduct(NetLcProduct netLcProduct) {
		int count=0;
		count=this.session.insert("org.guili.ecshop.dao.netlicai.INetLcDetailDao.addNetLcProduct", netLcProduct);
		return count;
	}

	@Override
	public NetLcProduct selectNetLcProductById(Long id) throws Exception {
		NetLcProduct lcProduct=new NetLcProduct();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("id", id);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.netlicai.INetLcDetailDao.selectNetLcProductById", paramMap);
		if(list!=null && list.size()>0){
			lcProduct=(NetLcProduct)list.get(0);
		}else{
			lcProduct=null;
		}
		logger.debug("success!");
		return lcProduct;
	}

	@Override
	public Integer selectNetLcProductByHash(Long titlehash) {
		int count=0;
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("titlehash", titlehash);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.netlicai.INetLcDetailDao.selectNetLcProductByHash", paramMap);
		if(list!=null && list.size()>0){
			count=(Integer)list.get(0);
		}
		logger.debug("success!");
		return count;
	}

	@Override
	public Integer selectNetLcProductCount(CwPageParam cwPageParam) {
		int count=0;
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("companyId", cwPageParam.getCompanyId());
		paramMap.put("status", cwPageParam.getStatus());
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.netlicai.INetLcDetailDao.selectNetLcProductCount", paramMap);
		if(list!=null && list.size()>0){
			count=(Integer)list.get(0);
		}
		logger.debug("success!");
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NetLcProduct> selectNetLcProductPage(Integer start,
			Integer pageSize, CwPageParam cwPageParam) {
		List<NetLcProduct> goodsList=new ArrayList<NetLcProduct>();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("pageSize", pageSize);
		paramMap.put("companyId", cwPageParam.getCompanyId());
		paramMap.put("status", cwPageParam.getStatus());
		goodsList=this.session.selectList("org.guili.ecshop.dao.netlicai.INetLcDetailDao.selectNetLcProductPage", paramMap);
		logger.debug("success!size is:"+goodsList.size());
		return goodsList;
	}

	@Override
	public List<NetLcProduct> selectLikeThis(Integer size,
			CwPageParam cwPageParam) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("companyId", cwPageParam.getCompanyId());
		paramMap.put("status", cwPageParam.getStatus());
		paramMap.put("size", size);
		@SuppressWarnings("unchecked")
		List<NetLcProduct> list=this.session.selectList("org.guili.ecshop.dao.netlicai.INetLcDetailDao.selectLikeThis", paramMap);
		logger.debug("success!");
		return list;
	}

	@Override
	public List<NetLcProduct> selectTuijian(Integer size) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("size", size);
		@SuppressWarnings("unchecked")
		List<NetLcProduct> list=this.session.selectList("org.guili.ecshop.dao.netlicai.INetLcDetailDao.selectTuijian", paramMap);
		logger.debug("success!");
		return list;
	}
	

}
