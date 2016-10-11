package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDAO extends BaseDAO<Teacher> {

	@Autowired
	public TeacherDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
