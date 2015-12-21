package org.guili.ecshop.business.jiaoyu.bean;
import java.io.Serializable;
/**
 * 讲师
 * @author guili
 */
public class Teacher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2545601227029547399L;
	private Long   id;		 		//课程主键
	//教师基本信息
	private String teacherName;		//教师姓名
	private String zhuanye; 		//专业
	private String teacherDesc;		//描述
	private String zhengjian; 		//教师证件
	private String jigou;			//所属机构
	private Integer pingjia;  		//教师教学总评
	private String teacherImg;		//教师头像
	private Integer teacherType;  	//课程类型  0,其他网站抓取课程  1，本站点课程
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getZhuanye() {
		return zhuanye;
	}
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	public String getTeacherDesc() {
		return teacherDesc;
	}
	public void setTeacherDesc(String teacherDesc) {
		this.teacherDesc = teacherDesc;
	}
	public String getZhengjian() {
		return zhengjian;
	}
	public void setZhengjian(String zhengjian) {
		this.zhengjian = zhengjian;
	}
	public String getJigou() {
		return jigou;
	}
	public void setJigou(String jigou) {
		this.jigou = jigou;
	}
	public Integer getPingjia() {
		return pingjia;
	}
	public void setPingjia(Integer pingjia) {
		this.pingjia = pingjia;
	}
	public String getTeacherImg() {
		return teacherImg;
	}
	public void setTeacherImg(String teacherImg) {
		this.teacherImg = teacherImg;
	}
	public Integer getTeacherType() {
		return teacherType;
	}
	public void setTeacherType(Integer teacherType) {
		this.teacherType = teacherType;
	}
	
}
