package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entities.Userloginfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserLogInfoDAO extends BaseDAO<Userloginfo> {
	@Autowired
	public UserLogInfoDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
