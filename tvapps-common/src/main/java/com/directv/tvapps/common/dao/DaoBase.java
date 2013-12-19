/*
 * Copyright (c) 2007 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.tvapps.common.dao;
/*
 * @author Paul Hsu
 */

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface DaoBase<K extends Serializable, T> {
	public SessionFactory getSessionFactory();
	public Session getCurrentSession();

	public T get(K id);

	public void save(T record);

	public void delete(T record);

	public void update(T record);

	public void saveOrUpdate(T record);

	public List<T> findByExample(T record);

	public T merge(T record);

	public List<T> getAll();

	// example String orderBys={"col1", "col2"}; char[] ascOrDesc={'A', 'D'};
	public List<T> getAllOrderBy(String[] orderBys, char[] ascOrDesc);

	public void executeStoreProcedure(final String procedure,
			final String... parameters);

}
