package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO extends BaseDAO<Student> {

	@Autowired
	public StudentDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
