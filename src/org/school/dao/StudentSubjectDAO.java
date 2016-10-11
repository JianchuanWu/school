package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entities.StudentSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentSubjectDAO extends BaseDAO<StudentSubject> {

	@Autowired
	public StudentSubjectDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
