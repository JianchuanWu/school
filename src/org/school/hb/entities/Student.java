package org.school.hb.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String stid;
	private Classinfo classinfo;
	private String stname;
	private Date stbirthday;
	private Integer stsex;
	private Studentcard studentcard;

	// Constructors

	/** default constructor */
	public Student() {
	}

	// Property accessors

	public String getStid() {
		return this.stid;
	}

	public Studentcard getStudentcard() {
		return studentcard;
	}

	public void setStudentcard(Studentcard studentcard) {
		this.studentcard = studentcard;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public Classinfo getClassinfo() {
		return this.classinfo;
	}

	public void setClassinfo(Classinfo classinfo) {
		this.classinfo = classinfo;
	}

	public String getStname() {
		return this.stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public Date getStbirthday() {
		return this.stbirthday;
	}

	public void setStbirthday(Date stbirthday) {
		this.stbirthday = stbirthday;
	}

	public Integer getStsex() {
		return this.stsex;
	}

	public void setStsex(Integer stsex) {
		this.stsex = stsex;
	}

	@Override
	public String toString() {
		return "Student [stid=" + stid + ", stname=" + stname + ", stbirthday="
				+ stbirthday + ", stsex=" + stsex + "]";
	}

}