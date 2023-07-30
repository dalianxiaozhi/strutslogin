package com.lz.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression;

public class HibernateUtils {
	static Configuration configuration = null;
	static SessionFactory sessionFactory = null;
	
	static {
		Configuration cfg =new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
