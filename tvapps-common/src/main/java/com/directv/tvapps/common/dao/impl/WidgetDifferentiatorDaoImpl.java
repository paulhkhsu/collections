package com.directv.tvapps.common.dao.impl;

/*
 * @author Paul Hsu
 */

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.directv.tvapps.common.dao.WidgetDao;
import com.directv.tvapps.common.dao.WidgetDifferentiatorDao;
import com.directv.tvapps.common.enums.WidgetDifferentiatorCode;
import com.directv.tvapps.common.enums.WidgetStatus;
import com.directv.tvapps.common.pojo.Widget;
import com.directv.tvapps.common.pojo.WidgetDifferentiator;

@Repository("widgetDifferentiatorDao")
public class WidgetDifferentiatorDaoImpl extends
		DaoBaseImpl<Long, WidgetDifferentiator> implements
		WidgetDifferentiatorDao {

	public WidgetDifferentiatorDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<WidgetDifferentiator> getDifferentiatorWidgets(final String type) {

		Criteria c = this.getSession()
				.createCriteria(WidgetDifferentiator.class)
				.setFetchMode("widget", FetchMode.JOIN)
				.add(Restrictions.eq("differentiator", type))
				.addOrder(Order.asc("seqNumber"));
		return c.list();
	}

}