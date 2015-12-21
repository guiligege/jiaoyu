package org.guili.ecshop.impl.jiaoyu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.guili.ecshop.business.jiaoyu.bean.Course;
import org.guili.ecshop.business.p2p.bean.CwPageParam;
import org.guili.ecshop.business.p2p.bean.NetLcProduct;
import org.guili.ecshop.dao.jiaoyu.ICourseDao;
import org.guili.ecshop.util.BasicSqlSupport;

/**
 * 课程dao
 * @author zhengdong.xiao
 *
 */
public class CourseDao extends BasicSqlSupport  implements ICourseDao {

	
	private static Logger logger=Logger.getLogger(CourseDao.class);
	@Override
	public int addCourse(Course course) {
		int count=0;
		count=this.session.insert("org.guili.ecshop.dao.jiaoyu.ICourseDao.addCourse", course);
		return count;
	}

	@Override
	public Course selectCourseById(Long id) throws Exception {
		Course course=new Course();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("id", id);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.jiaoyu.ICourseDao.selectCourseById", paramMap);
		if(list!=null && list.size()>0){
			course=(Course)list.get(0);
		}else{
			course=null;
		}
		logger.debug("success!");
		return course;
	}

	@Override
	public Integer selectCourseByHash(Integer courseNameHash) {
		int count=0;
		if(courseNameHash==null|| courseNameHash==0){
			return 0;
		}
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("courseNameHash", courseNameHash);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.jiaoyu.ICourseDao.selectCourseByHash", paramMap);
		if(list!=null && list.size()>0){
			count=(Integer)list.get(0);
		}
		logger.debug("success!");
		return count;
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

}
