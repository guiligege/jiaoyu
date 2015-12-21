package org.guili.ecshop.impl.netlicai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.guili.ecshop.business.p2p.bean.CompanyPageParam;
import org.guili.ecshop.business.p2p.bean.NetLcCompany;
import org.guili.ecshop.business.p2p.bean.NetLcProduct;
import org.guili.ecshop.dao.netlicai.INetLcCompanyDao;
import org.guili.ecshop.util.BasicSqlSupport;

public class NetLcCompanyDao extends BasicSqlSupport  implements INetLcCompanyDao {
	private static Logger logger=Logger.getLogger(NetLcCompanyDao.class);
	@Override
	public NetLcCompany selectNetLcCompanyById(Long id) throws Exception {
		NetLcCompany netLcCompany=new NetLcCompany();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("id", id);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.netlicai.INetLcCompanyDao.selectNetLcCompanyById", paramMap);
		if(list!=null && list.size()>0){
			netLcCompany=(NetLcCompany)list.get(0);
		}else{
			netLcCompany=null;
		}
		logger.debug("success!");
		return netLcCompany;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NetLcCompany> selectAllNetLcCompany() {
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.netlicai.INetLcCompanyDao.selectAllNetLcCompany");
		return list;
	}

	@Override
	public int addNetLcCompany(NetLcCompany netLcCompany) {
		
		int count=0;
		try {
			count=this.session.insert("org.guili.ecshop.dao.netlicai.INetLcCompanyDao.addNetLcCompany", netLcCompany);
		} catch (Exception e) {
			e.printStackTrace();
			return count;
		}
		return count;
	}

	@Override
	public Integer selectNetLcCompanyByHash(Integer companyNameHash) {
		int count=0;
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("companyNameHash", companyNameHash);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.netlicai.INetLcCompanyDao.selectNetLcCompanyByHash", paramMap);
		if(list!=null && list.size()>0){
			count=(Integer)list.get(0);
		}
		logger.debug("success!");
		return count;
	}

	@Override
	public Integer selectNetLcCompanyCount(CompanyPageParam cwPageParam) {
		int count=0;
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("beijing", cwPageParam.getBeijing());
		paramMap.put("renqi", cwPageParam.getRenqi());
		paramMap.put("rongzi", cwPageParam.getRongzi());
		paramMap.put("status", 0);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.netlicai.INetLcCompanyDao.selectNetLcCompanyCount", paramMap);
		if(list!=null && list.size()>0){
			count=(Integer)list.get(0);
		}
		logger.debug("success!");
		return count;
	}

	@Override
	public List<NetLcCompany> selectNetLcCompanyPage(Integer start,
			Integer pageSize, CompanyPageParam cwPageParam) {
		List<NetLcCompany> goodsList=new ArrayList<NetLcCompany>();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("pageSize", pageSize);
		paramMap.put("beijing", cwPageParam.getBeijing());
		paramMap.put("renqi", cwPageParam.getRenqi());
		paramMap.put("rongzi", cwPageParam.getRongzi());
		paramMap.put("status", 0);
		goodsList=this.session.selectList("org.guili.ecshop.dao.netlicai.INetLcCompanyDao.selectNetLcCompanyPage", paramMap);
		logger.debug("success!size is:"+goodsList.size());
		return goodsList;
	}

}
