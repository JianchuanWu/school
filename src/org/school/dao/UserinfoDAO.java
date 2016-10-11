package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entities.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserinfoDAO extends BaseDAO<Userinfo> {
	@Autowired
	public UserinfoDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
