package org.guili.ecshop.business.jiaoyu.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.guili.ecshop.business.jiaoyu.ICourseService;
import org.guili.ecshop.business.jiaoyu.bean.Course;
import org.guili.ecshop.business.p2p.bean.CwPageParam;
import org.guili.ecshop.dao.jiaoyu.ICourseDao;

/**
 * 课程服务类
 * @author zhengdong.xiao
 *
 */
public class CourseServiceImpl implements ICourseService {

	private static Logger logger=Logger.getLogger(CourseServiceImpl.class);
	//课程dao
	private ICourseDao courseDao;
	private static final int ERROR_FLAG=-1;
	private static final int RECOMMIT_FLAG=-2;
	
	@Override
	public int addCourse(Course course) {
		//验证信息
		if(!validateCourse(course)){
			logger.info("course validate not complete!");
			return ERROR_FLAG;
		}
		//防止重复插入。
		if(courseDao.selectCourseByHash(course.getCourseNameHash())>0){
			 return RECOMMIT_FLAG;
		}
		try {
			return courseDao.addCourse(course);
		} catch (Exception e) {
			logger.error("course insert  is error:"+course.getCourseName());
			e.printStackTrace();
			return ERROR_FLAG;
		}
	}
	
	/**
	 * 验证宠物信息
	 * @param petSaleInfo
	 * @return
	 */
	private boolean validateCourse(Course course){
		if(course==null){
			return false;
		}
		if(StringUtils.isEmpty(course.getCourseName())
				|| StringUtils.isEmpty(course.getCourseUrl())
				|| course.getCourseNameHash()==null
				){
			return false;
		}
		return true;
	}

	@Override
	public Course selectCourseById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectCourseByHash(Long titlehash) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectCourseCount(CwPageParam cwPageParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> selectCoursePage(Integer start, Integer pageSize,
			CwPageParam cwPageParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> selectLikeThis(Integer size, CwPageParam cwPageParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> selectTuijian(Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	public ICourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(ICourseDao courseDao) {
		this.courseDao = courseDao;
	}

}
