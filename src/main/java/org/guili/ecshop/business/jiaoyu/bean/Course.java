package org.guili.ecshop.business.jiaoyu.bean;
import java.io.Serializable;
/**
 * 课程
 * @author guili
 */
public class Course implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2545607527029547399L;
	private Long   id;		 	//课程主键
	//课程基本信息
	private String courseName;	//课程名称
	private Integer courseNameHash;	//课程名称Hash
	private Integer gradeId; 	//年级id
	private String grade; 		//年级名次
	private Integer kemuId;		//科目id
	private String kemu;  		//科目名
	private Integer pingTaiId; 	//来源平台id
	private String pingTaiName; //来源平台名称
	private String detail;		//课程简介
	private Integer teacherId;  //教师id
	private String teacherName; //教师名 
	private String jigou; 		//机构
	private String teachTime;	//教学时间
	private Integer keshi;		//课程课时
	private String courseImgURL;//课程图片链接
	private Integer studyCount; //课程学习人数
	private Double price;		//课程价格
	private String courseUrl;   //课程链接地址
	private Integer courseType;  //课程类型  0,其他网站抓取课程  1，本站点课程
	private Integer status;  //课程状态  0,无效  1，有效
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getKemuId() {
		return kemuId;
	}
	public void setKemuId(Integer kemuId) {
		this.kemuId = kemuId;
	}
	public String getKemu() {
		return kemu;
	}
	public void setKemu(String kemu) {
		this.kemu = kemu;
	}
	public Integer getPingTaiId() {
		return pingTaiId;
	}
	public void setPingTaiId(Integer pingTaiId) {
		this.pingTaiId = pingTaiId;
	}
	public String getPingTaiName() {
		return pingTaiName;
	}
	public void setPingTaiName(String pingTaiName) {
		this.pingTaiName = pingTaiName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getJigou() {
		return jigou;
	}
	public void setJigou(String jigou) {
		this.jigou = jigou;
	}
	public String getTeachTime() {
		return teachTime;
	}
	public void setTeachTime(String teachTime) {
		this.teachTime = teachTime;
	}
	public Integer getKeshi() {
		return keshi;
	}
	public void setKeshi(Integer keshi) {
		this.keshi = keshi;
	}
	public String getCourseImgURL() {
		return courseImgURL;
	}
	public void setCourseImgURL(String courseImgURL) {
		this.courseImgURL = courseImgURL;
	}
	public Integer getStudyCount() {
		return studyCount;
	}
	public void setStudyCount(Integer studyCount) {
		this.studyCount = studyCount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCourseUrl() {
		return courseUrl;
	}
	public void setCourseUrl(String courseUrl) {
		this.courseUrl = courseUrl;
	}
	public Integer getCourseNameHash() {
		return courseNameHash;
	}
	public void setCourseNameHash(Integer courseNameHash) {
		this.courseNameHash = courseNameHash;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCourseType() {
		return courseType;
	}
	public void setCourseType(Integer courseType) {
		this.courseType = courseType;
	}
	
}
