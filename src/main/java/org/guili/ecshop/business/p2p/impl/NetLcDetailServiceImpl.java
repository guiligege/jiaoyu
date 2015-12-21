package org.guili.ecshop.business.p2p.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.guili.ecshop.business.p2p.INetLcDetailService;
import org.guili.ecshop.business.p2p.bean.CompanyPageParam;
import org.guili.ecshop.business.p2p.bean.CwPageParam;
import org.guili.ecshop.business.p2p.bean.NetLcCompany;
import org.guili.ecshop.business.p2p.bean.NetLcProduct;
import org.guili.ecshop.dao.netlicai.INetLcCompanyDao;
import org.guili.ecshop.dao.netlicai.INetLcDetailDao;
import org.guili.ecshop.util.common.Validator;


/**
 * p2p理财接口实现
 * @author Administrator
 *
 */
public class NetLcDetailServiceImpl implements INetLcDetailService {
	private static Logger logger=Logger.getLogger(NetLcDetailServiceImpl.class);
	private INetLcDetailDao netLcDetailDao;
	private INetLcCompanyDao netLcCompanyDao;
	private static final int ERROR_FLAG=-1;
	private static final int RECOMMIT_FLAG=-2;
	
	/**
	 * 添加p2p理财信息
	 */
	@Override
	public int addNetLcProduct(NetLcProduct netLcProduct) {
		//验证信息
		if(!validatePetSaleInfo(netLcProduct)){
			logger.info("petSaleInfo validate not complete!");
			return ERROR_FLAG;
		}
		//防止重复插入。
		if(netLcDetailDao.selectNetLcProductByHash(netLcProduct.getTitlehash())>0L){
			 return RECOMMIT_FLAG;
		}
		try {
			return netLcDetailDao.addNetLcProduct(netLcProduct);
		} catch (Exception e) {
			logger.error("petSaleInfo is error:"+netLcProduct.getTitle());
			e.printStackTrace();
			return ERROR_FLAG;
		}
	}
	/**
	 * 验证宠物信息
	 * @param petSaleInfo
	 * @return
	 */
	private boolean validatePetSaleInfo(NetLcProduct netLcProduct){
		if(netLcProduct==null){
			return false;
		}
		if(netLcProduct.getCompanyId()==null 
				|| StringUtils.isEmpty(netLcProduct.getTitle())
				|| netLcProduct.getTitlehash()==null
				|| StringUtils.isEmpty(netLcProduct.getCompanyName())
				){
			return false;
		}
		return true;
	}

	/**
	 * 根据id查询p2p理财信息
	 */
	@Override
	public NetLcProduct selectNetLcProductById(Long id) {
		//验证传入是否是数字
		if(!Validator.isNumber(id+"")){
			return null;
		}
		try {
			return netLcDetailDao.selectNetLcProductById(id);
		} catch (Exception e) {
			logger.error("selectPetSaleInfoById is error id=:"+id);
			return null;
		}
	}

	/***
	 * 批量保存
	 */
	@Override
	public void saveNetLcProductList(List<NetLcProduct> netLcProductList) {
		if(netLcProductList.isEmpty()){
			 return ;
		 }
		 for(NetLcProduct netLcProduct:netLcProductList){
			 if(netLcProduct!=null){
				 //防止脏数据
				 if(netLcProduct.getTitle()==null  ||netLcProduct.getTitle().isEmpty()){
					 continue;
				 }
				 //防止重复插入。
				 if(this.selectNetLcProductByHash(netLcProduct.getTitlehash())>0){
					 continue;
				 }
				 try {
					 netLcProduct.setCreateTime(new Date());
					 netLcDetailDao.addNetLcProduct(netLcProduct);
				} catch (Exception e) {
					e.printStackTrace();
				}
			 }
		 }

	}

	/**
	 * 根据hash查询
	 */
	@Override
	public Integer selectNetLcProductByHash(Long titleHash) {
		try {
			return netLcDetailDao.selectNetLcProductByHash(titleHash);
		} catch (Exception e) {
			logger.error("selectPetSaleInfoByHash is error titlehash=:"+titleHash);
			return null;
		}
	}

	/**
	 * 统计分页查询理财信息数量
	 */
	@Override
	public Integer selectNetLcProductCount(CwPageParam cwPageParam) {
		try {
			return netLcDetailDao.selectNetLcProductCount(cwPageParam);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 分页查询理财信息
	 */
	@Override
	public List<NetLcProduct> selectNetLcProductPage(int start, int pageSize,
			CwPageParam cwPageParam) {
		try {
			return netLcDetailDao.selectNetLcProductPage(start, pageSize, cwPageParam);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<NetLcProduct> selectLikeThis(Integer size,
			CwPageParam cwPageParam) {
		try {
			return netLcDetailDao.selectLikeThis(size, cwPageParam);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<NetLcProduct> selectTuijian(Integer size) {
		try {
			return netLcDetailDao.selectTuijian(size);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public NetLcCompany selectNetLcCompanyById(Long id) throws Exception {
		if(id==null){
			return null;
		}
		return netLcCompanyDao.selectNetLcCompanyById(id);
	}
	@Override
	public List<NetLcCompany> selectAllNetLcCompany() {
		return netLcCompanyDao.selectAllNetLcCompany();
	}
	
	
	public INetLcDetailDao getNetLcDetailDao() {
		return netLcDetailDao;
	}
	public void setNetLcDetailDao(INetLcDetailDao netLcDetailDao) {
		this.netLcDetailDao = netLcDetailDao;
	}
	public INetLcCompanyDao getNetLcCompanyDao() {
		return netLcCompanyDao;
	}
	public void setNetLcCompanyDao(INetLcCompanyDao netLcCompanyDao) {
		this.netLcCompanyDao = netLcCompanyDao;
	}
	@Override
	public int addNetLcCompany(NetLcCompany netLcCompany) {
		 //防止重复插入。
		 if(netLcCompanyDao.selectNetLcCompanyByHash(netLcCompany.getCompanyNameHash())>0){
			 return 0;
		 }
		return netLcCompanyDao.addNetLcCompany(netLcCompany);
	}
	
	/***
	 * 批量保存
	 */
	@Override
	public void batSaveNetLcCompany(List<NetLcCompany> netLcCompanyList) {
		if(netLcCompanyList.isEmpty()){
			 return ;
		 }
		 for(NetLcCompany netLcCompany:netLcCompanyList){
			 if(netLcCompany!=null){
				 //防止脏数据
				 if(netLcCompany.getCompanyName()==null || netLcCompany.getCompanyName().isEmpty()){
					 continue;
				 }
				 //防止重复插入。
				 if(netLcCompanyDao.selectNetLcCompanyByHash(netLcCompany.getCompanyNameHash())>0){
					 continue;
				 }
				 try {
					 netLcCompanyDao.addNetLcCompany(netLcCompany);
				} catch (Exception e) {
					e.printStackTrace();
				}
			 }
		 }

	}
	@Override
	public Integer selectNetLcCompanyCount(CompanyPageParam cwPageParam) {
		try {
			return netLcCompanyDao.selectNetLcCompanyCount(cwPageParam);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public List<NetLcCompany> selectNetLcCompanyPage(Integer start,
			Integer pageSize, CompanyPageParam cwPageParam) {
		try {
			return netLcCompanyDao.selectNetLcCompanyPage(start, pageSize, cwPageParam);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
