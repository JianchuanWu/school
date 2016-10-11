package org.school.hb.entities;

/**
 * StudentSubject entity. @author MyEclipse Persistence Tools
 */

public class StudentSubject implements java.io.Serializable {

	// Fields

	private StudentSubjectId id;

	// Constructors

	/** default constructor */
	public StudentSubject() {
	}

	/** full constructor */
	public StudentSubject(StudentSubjectId id) {
		this.id = id;
	}

	// Property accessors

	public StudentSubjectId getId() {
		return this.id;
	}

	public void setId(StudentSubjectId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "StudentSubject [id=" + id + "]";
	}

}