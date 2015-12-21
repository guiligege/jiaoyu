package org.guili.ecshop.controller.product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.guili.ecshop.bean.spider.yinhang.SeoConstants;
import org.guili.ecshop.business.jiaoyu.ICourseService;
import org.guili.ecshop.business.jiaoyu.bean.Course;
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
 * 课程控制controller
 * @author guili
 *
 */
@Controller
public class CourseController extends BaseProfileController{
	@Resource(name="courseService")
	private ICourseService courseService;
			
	//测试课程抓取
	@RequestMapping(value={ "/course/add1.htm"},method={RequestMethod. GET})
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
	
	//测试银行抓取
		@RequestMapping(value={ "/course/add.htm"},method={RequestMethod. GET})
		public void testyinhang(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws Exception{
			
			Course course=new Course();
			course.setCourseImgURL("www.baidu.com");
			course.setCourseUrl("www.baidu.com");
			course.setCourseName("test");
			course.setCourseNameHash(course.getCourseName().hashCode());
			course.setDetail("aaa");
			course.setJigou("新东方");
			course.setKemu("数学");
			course.setGrade("高一");
			course.setGradeId(1);
			course.setKeshi(100);
			course.setPrice(100.0);
			course.setStudyCount(10);
			course.setTeacherId(1);
			course.setTeacherName("刘老师");
			course.setTeachTime("2015年12月25日 下午 13点");
			course.setKemuId(1);
			course.setCourseType(0);
			
			courseService.addCourse(course);
			
			return ;
		}
		
	public static void main(String[] args) {
//		String spiderType="LUJINSUO";
//		SpiderType spiderType1=SpiderType.valueOf(spiderType.toUpperCase());
//		System.out.println(spiderType1.name());
		System.out.println("上海陆家嘴国际金融资产交易".length());
	}
}
