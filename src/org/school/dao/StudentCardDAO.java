package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entities.Studentcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentCardDAO extends BaseDAO<Studentcard> {

	@Autowired
	public StudentCardDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
