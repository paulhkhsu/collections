package com.directv.tvapps.common.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.directv.tvapps.common.dao.DaoBase;

public class DaoUtil {

	public static void bindSessionFactory(DaoBase dao) {
		SessionFactory sessionFactory = dao.getSessionFactory();
		bindSessionFactory(sessionFactory);
	}

	public static void bindSessionFactory(SessionFactory sessionFactory) {
		Session session = SessionFactoryUtils.getSession(sessionFactory, true);
		TransactionSynchronizationManager.bindResource(sessionFactory,
				new SessionHolder(session));
	}

	public static void unBindSessionFactory(DaoBase dao) {
		SessionFactory sessionFactory = dao.getSessionFactory();
		unBindSessionFactory(sessionFactory);
	}

	public static void unBindSessionFactory(SessionFactory sessionFactory) {
		SessionHolder sessionHolder = (SessionHolder) TransactionSynchronizationManager
				.unbindResourceIfPossible(sessionFactory);
		SessionFactoryUtils.releaseSession(sessionHolder.getSession(),
				sessionFactory);
		SessionFactoryUtils.closeSession(sessionHolder.getSession());
		
	}

}
