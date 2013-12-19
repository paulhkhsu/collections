package com.directv.tvapps.common.dao.impl;
/*
 * @author Paul Hsu
 */

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.directv.tvapps.common.dao.CategoryDao;
import com.directv.tvapps.common.dao.RefreshRateDao;

import com.directv.tvapps.common.pojo.Category;
import com.directv.tvapps.common.pojo.RefreshRate;

@Repository("refreshRateDao")
public class RefreshRateDaoImpl extends DaoBaseImpl<Long, RefreshRate>
		implements RefreshRateDao {
	public RefreshRateDaoImpl() {
	}

}