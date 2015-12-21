package org.guili.ecshop.dao.jiaoyu;
import java.util.List;

import org.guili.ecshop.business.jiaoyu.bean.Course;
import org.guili.ecshop.business.p2p.bean.CwPageParam;
/**
 * Course dao
 * @author guili
 */
public interface ICourseDao {
	/**
	 * 添加课程信息
	 * @param lcProduct
	 * @return
	 * @throws Exception
	 */
	public int addCourse(Course course);
	
	/**
	 * 根据Id查询课程信息
	 * @param pageParam
	 * @return
	 */
	public Course selectCourseById(Long id) throws Exception;
	
	/**
	 * 根据title的hash值，查询课程
	 * @param Hash
	 * @return
	 */
	public Integer selectCourseByHash(Integer titlehash) ;
	
	
	/**
	 * 根据条件，查询课程总数
	 * @param cwPageParam
	 * @return
	 */
	public Integer selectCourseCount(CwPageParam cwPageParam);
	
	/**
	 * 分页查询课程信息
	 * @param start
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<Course> selectCoursePage(Integer start, Integer pageSize,
			CwPageParam cwPageParam) ;
	
	/**
	 * 查找相关课程
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<Course> selectLikeThis(Integer size,CwPageParam cwPageParam);
	
	/**
	 * 查找推荐课程
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<Course> selectTuijian(Integer size);
}
