package org.guili.ecshop.controller.product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.guili.ecshop.bean.spider.yinhang.SeoConstants;
import org.guili.ecshop.business.p2p.INetLcDetailService;
import org.guili.ecshop.business.p2p.IProductService;
import org.guili.ecshop.business.p2p.SpiderType;
import org.guili.ecshop.business.p2p.bean.CompanyPageParam;
import org.guili.ecshop.business.p2p.bean.CompanySeoEnum;
import org.guili.ecshop.business.p2p.bean.CwPageParam;
import org.guili.ecshop.business.p2p.bean.NetLcCompany;
import org.guili.ecshop.business.p2p.bean.NetLcProduct;
import org.guili.ecshop.business.p2p.impl.Spiders;
import org.guili.ecshop.controller.common.BaseProfileController;
import org.guili.ecshop.util.common.UrlHelper;
import org.guili.ecshop.util.common.page.Pager;
import org.guili.ecshop.util.common.page.PagerHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 产品控制controller
 * @author guili
 *
 */
@Controller
public class NetLcController extends BaseProfileController{
	@Resource(name="netLcDetailService")
	private INetLcDetailService netLcDetailService;
	
	private static final int pagesize=15;
	private static final int companyPageSize=30;
	private static final String DEFAULT_KEYWORDS="理财机构,理财平台,理财网站";
	private static final String DEFAULT_TITLE="理财机构,理财平台,理财网站";
	
			
	//测试银行抓取
	@RequestMapping(value={ "/netlc/add.htm"},method={RequestMethod. GET})
	public void testyinhang(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
					@RequestParam(value = "url", required = false) String url,@RequestParam(value = "spiderType", required = false) String spiderType
					  	) throws Exception{
		if(StringUtils.isEmpty(spiderType)){
			return;
		}
		//积木盒子
		IProductService productService=Spiders.getHandler(SpiderType.valueOf(spiderType.toUpperCase()));
//		productService.createNetLcProduct("","https://www.jimubox.com/Project/Index/48525");
		String innerurl="";
		if(SpiderType.valueOf(spiderType.toUpperCase())==SpiderType.JIMUBOX){
			innerurl="https://www.jimubox.com/Project/List?status=1&flag=close";
		}else if(SpiderType.valueOf(spiderType.toUpperCase())==SpiderType.NIWIDAI){
			innerurl="https://member.niwodai.com/loan/loan.do?slist=,1,&totalCount=40&pageNo=1";
		}else if(SpiderType.valueOf(spiderType.toUpperCase())==SpiderType.RENRENDAI){
			innerurl="http://www.renrendai.com/lend/loanList!json.action?pageIndex=1&_=1433949424923";
		}else if(SpiderType.valueOf(spiderType.toUpperCase())==SpiderType.TOUNA){
			innerurl="http://www.touna.cn/borrow.do?method=list&status=0&size=10&subtime=1433955135795&page=2";
		}else if(SpiderType.valueOf(spiderType.toUpperCase())==SpiderType.YIRENDAI){
			innerurl="http://www.yirendai.com/loan/list/3";
		}
		else if(SpiderType.valueOf(spiderType.toUpperCase())==SpiderType.LICAI_DIANPING){
			//innerurl="http://www.76676.com/show-20-133-1.html";
			if(url!=null && !url.isEmpty()){
				innerurl=url;
			}else{
				innerurl="http://www.76676.com/show-20-112-1.html";
			}
		}
		productService.batCrawlPet(innerurl);
		
		return ;
	}
	
		
		//跳转p2p公司列表页
		@RequestMapping(value={ "/netlc/company.htm"},method={RequestMethod. GET})
		public String licaicompany(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
				@RequestParam(value = "beijing", required = false) Integer beijing,
				@RequestParam(value = "renqi", required = false) Integer renqi,
				@RequestParam(value = "rongzi", required = false) Integer rongzi,
				@RequestParam(value = "pageNum", required = false) String pageNum
				 ) throws Exception{
			List<NetLcCompany> netLcCompanyList=new ArrayList<NetLcCompany>();
			CompanyPageParam cwPageParam=new CompanyPageParam();
			//用于回显的url部分
			String urlParam=this.setCompanyParams(beijing, renqi,rongzi,cwPageParam);
			int totalRow=netLcDetailService.selectNetLcCompanyCount(cwPageParam);
			//分页信息
	        Pager pager=null;
	        String basePath=UrlHelper.getRealPath(request); 			  //基础绝对路径
	        if(StringUtils.isNotEmpty(pageNum)){
	        	pager = PagerHelper.getPager(pageNum, totalRow,pagesize); //初始化分页对象  
	        }else{
	        	pager = PagerHelper.getPager("1", totalRow,pagesize); 	  //初始化分页对象  
	        }
	        pager.setLinkUrl(basePath+request.getRequestURI()); 		  //设置跳转路径  
	        request.setAttribute("pager", pager); 						  //将分页信息保存在Request对象  
	        //分页参数
	        request.setAttribute("urlParam", urlParam);
	        netLcCompanyList=netLcDetailService.selectNetLcCompanyPage(pager.getStartRow(), pager.getPageSize(), cwPageParam);
	        request.setAttribute("bList", netLcCompanyList);
	        request.setAttribute("pageParam", cwPageParam);
			
			return "ptop/netlc_product_company_list";
		}
		
		//设置回显参数
		private String setCompanyParams(Integer beijing,Integer renqi,Integer rongzi,CompanyPageParam cwPageParam){
			StringBuffer urlParam=new StringBuffer();
			urlParam.append("company-");
			//构造背景
			if(beijing!=null){
				urlParam.append(beijing+"-");
				cwPageParam.setBeijing(beijing);
			}else{
				urlParam.append("-");
			}
			//构造人气
			if(renqi!=null){
				urlParam.append(renqi+"-");
				cwPageParam.setRenqi(renqi);
			}else{
				urlParam.append("-");
			}
			//构造融资
			if(rongzi!=null){
				urlParam.append(rongzi+"-");
				cwPageParam.setRongzi(rongzi);
			}else{
				urlParam.append("-");
			}
	        return urlParam.toString();
		}
		
		
		
		//测试添加p2p公司
		@RequestMapping(value={ "/netlc/addCompany.htm"},method={RequestMethod. GET})
		public void addCompany(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws Exception{
			NetLcCompany netLcCompany=new NetLcCompany();
			netLcCompany.setBeijing(0);
			netLcCompany.setBianxiansudu("T+1");
			netLcCompany.setChanping("核心商圈贷/房产抵押贷/企业经营贷");
			netLcCompany.setChongzhifei("免费");
			netLcCompany.setCompanyAddress("北京乐融多源信息技术有限公司");
			netLcCompany.setCompanyCode("JIMUBOX");
			netLcCompany.setCompanyHistory("积木盒子于2014年9月获得B轮：数千万美元 （小米公司、顺为资本）");
			netLcCompany.setCompanyInfo("积木盒子");
			netLcCompany.setCompanyName("积木盒子");
			netLcCompany.setCompanyQuedian("1.降息严重2.前期担保公司法人和平台是同一个3.无电子签章");
			netLcCompany.setCompanytuandui("积木盒子");
			netLcCompany.setCompanyYoudian("豪华创始团队阵容");
			netLcCompany.setCreateTime(new Date());
			netLcCompany.setDanbaoCompany("有");
			netLcCompany.setDianHua("400-068-1176");
			netLcCompany.setDianziqian("CFCA");
			netLcCompany.setDiya("有");
			netLcCompany.setEmail("info@jimubox.com");
			netLcCompany.setFaRen("董骏");
			netLcCompany.setFengkong("有");
			netLcCompany.setFengxianjin("10000万");
			netLcCompany.setHuikuanway("先息后本/等额本息");
			netLcCompany.setJiaoyi("62.92 亿元");
			netLcCompany.setLilv("7% - 12.5%");
			netLcCompany.setOrderid(1);
			netLcCompany.setQitafei("无");
			netLcCompany.setQixishijian("T+1");
			netLcCompany.setRegisterMoney("10000 万人民币");
			netLcCompany.setRenQi(5);
			netLcCompany.setRongzi(3);
			netLcCompany.setRongziinfo("A轮：千万美元 （银泰资本）B轮：3719万美元 （小米公司、顺为资本领投，经纬中国、淡马锡旗下祥峰投资等跟投）");
			netLcCompany.setRunCompany("北京乐融多源信息技术有限公司");
			netLcCompany.setRunState("正常");
			netLcCompany.setSitelogo("http://www.76676.com/uploadfile/p2plogo/jimuhezi_b.jpg");
			netLcCompany.setSiteurl("www.jimubox.com");
			netLcCompany.setStatus(1);
			netLcCompany.setTixianfei("1元(每笔)");
			netLcCompany.setTouziguimo("10万-500万元");
			netLcCompany.setTouziqidian("100 元");
			netLcCompany.setTouzishijian("0.5-24 个月");
			netLcCompany.setTouzitype("车贷/房贷/企业贷/信用贷");
			netLcCompany.setUpdateTime(new Date());
			netLcCompany.setYuqichuli("担保公司保证金先行垫付，如无法完成垫付，则积木盒子通过风险保证金等手段进行代偿。逾期期间投资者可获得借款利率4倍的违约金。");
			netLcCompany.setZhifuway("汇付天下");
			netLcCompany.setZhuanrang("有");
			netLcCompany.setZhuanrangfei("0/0.5%");
			netLcCompany.setCompanyNameHash(netLcCompany.getCompanyName().hashCode());
			//添加理财公司
			netLcDetailService.addNetLcCompany(netLcCompany);
		}
		
	public static void main(String[] args) {
//		String spiderType="LUJINSUO";
//		SpiderType spiderType1=SpiderType.valueOf(spiderType.toUpperCase());
//		System.out.println(spiderType1.name());
		System.out.println("上海陆家嘴国际金融资产交易".length());
	}
}
