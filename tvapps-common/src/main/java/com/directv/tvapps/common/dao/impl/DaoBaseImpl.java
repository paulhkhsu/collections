/*
 * Copyright (c) 2007 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.tvapps.common.dao.impl;

/*
 * @author Paul Hsu
 */

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.directv.tvapps.common.dao.DaoBase;

public class DaoBaseImpl<K extends Serializable, T> extends HibernateDaoSupport
		implements DaoBase<K, T> {

	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public DaoBaseImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass
				.getActualTypeArguments()[1];
	}

	public Session getCurrentSession() {
		return super.getSessionFactory().getCurrentSession();
	}

	@Autowired
	public void SetSessionFactory(SessionFactory sess) {
		super.setSessionFactory(sess);
	}

	@SuppressWarnings("unchecked")
	public T get(K id) {
		return (T) getCurrentSession().get(entityClass, id);
	}

	public void save(T record) {
		getCurrentSession().save(record);
	}

	public void saveOrUpdate(T record) {
		getCurrentSession().saveOrUpdate(record);
	}

	public void delete(T record) {
		getCurrentSession().delete(record);
	}

	public void update(T record) {
		getCurrentSession().update(record);
	}

	@SuppressWarnings("unchecked")
	public T merge(T record) {
		return (T) getCurrentSession().merge(record);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T record) {
		return (List<T>) getHibernateTemplate().findByExample(record);
	}

	public List<T> getAll() {
		return (List<T>) getHibernateTemplate().loadAll(entityClass);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllOrderBy(final String[] orderBys, final char[] ascOrDesc) {
		if (orderBys != null && ascOrDesc != null
				&& orderBys.length != ascOrDesc.length) {
			throw new IllegalArgumentException(
					"Length of array paramsters must be equal.");
		}
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		for (int i = 0; i < orderBys.length; i++) {
			String by = (String) orderBys[i];
			char aord = (char) ascOrDesc[i];
			if (aord == 'A' || aord == 'a')
				criteria.addOrder(Order.asc(by));
			if (aord == 'D' || aord == 'd')
				criteria.addOrder(Order.desc(by));
		}
		return criteria.list();
	}

	public void executeStoreProcedure(final String procedure,
			final String... parameters) {
		Session session = getCurrentSession();

		Query q = session.createSQLQuery(" { call " + procedure + " }");

		for (int i = 0; i < parameters.length; i++)
			q.setString(i, parameters[i]);

		q.executeUpdate();

	}
}
