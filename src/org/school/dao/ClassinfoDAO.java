package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entities.Classinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClassinfoDAO extends BaseDAO<Classinfo> {

	@Autowired
	public ClassinfoDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
