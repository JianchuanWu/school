package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entities.Subjectinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectinfoDAO extends BaseDAO<Subjectinfo> {

	@Autowired
	public SubjectinfoDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
