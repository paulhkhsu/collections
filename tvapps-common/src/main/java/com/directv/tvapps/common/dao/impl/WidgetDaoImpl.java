package com.directv.tvapps.common.dao.impl;

/*
 * @author Paul Hsu
 */

import java.util.ArrayList;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.directv.tvapps.common.dao.WidgetDao;
import com.directv.tvapps.common.dao.WidgetDifferentiatorDao;
import com.directv.tvapps.common.enums.WidgetDifferentiatorCode;
import com.directv.tvapps.common.enums.WidgetStatus;
import com.directv.tvapps.common.pojo.Category;
import com.directv.tvapps.common.pojo.Widget;
import com.directv.tvapps.common.pojo.WidgetDifferentiator;

@Repository("widgetDao")
public class WidgetDaoImpl extends DaoBaseImpl<Long, Widget> implements
		WidgetDao {
	@Autowired
	WidgetDifferentiatorDao widgetDifferentiatorDao;

	public WidgetDaoImpl() {
	}

	public List<Widget> getWidgets() {
		return getWidgets(0, 0);
	}

	@SuppressWarnings("unchecked")
	public List<Widget> getWidgets(final int start, final int totalRecords) {
		Criteria c = this
				.getSession()
				.createCriteria(Widget.class)
				.setCacheable(true)
				.add(Restrictions.eq("active", true))
				.add(Restrictions.eq("approved",
						WidgetStatus.APPROVED.getValue()))
				.addOrder(Order.asc("name").ignoreCase())
				.addOrder(Order.desc("created"));

		if (totalRecords > 0) {
			c.setFirstResult(start).setMaxResults(totalRecords);

		}
		return c.list();
	}

	public List<Widget> getNewAddedWidgets(final int days) {
		return getNewAddedWidgets(0, 0, days);
	}

	@SuppressWarnings("unchecked")
	public List<Widget> getNewAddedWidgets(final int start,
			final int totalRecords, final int days) {
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DAY_OF_MONTH, -days);
		Date date = cal.getTime();
		Criteria c = this
				.getCurrentSession()
				.createCriteria(Widget.class)
				.add(Restrictions.eq("active", true))
				.setCacheable(true)
				.add(Restrictions.eq("approved",
						WidgetStatus.APPROVED.getValue()))
				.add(Restrictions.ge("created", date))
				.addOrder(Order.desc("created"));
		if (totalRecords > 0) {
			c.setFirstResult(start).setMaxResults(totalRecords);

		}

		return c.list();
	}

	public List<Widget> getTopRatedWidgets() {
		return getTopRatedWidgets(0, 0);
	}

	@SuppressWarnings("unchecked")
	public List<Widget> getTopRatedWidgets(final int start,
			final int totalRecords) {

		Criteria c = this
				.getCurrentSession()
				.createCriteria(Widget.class)
				.createAlias("widgetStat", "widgetStat")
				.add(Restrictions.eq("active", true))
				.add(Restrictions.eq("approved",
						WidgetStatus.APPROVED.getValue())).setCacheable(true)
				.addOrder(Order.desc("widgetStat.setupCount"));
		if (totalRecords > 0) {
			c.setFirstResult(start).setMaxResults(totalRecords);

		}
		return c.list();
	}

	public List<Widget> getWidgetsByCategory(final String categoryCode) {
		return getWidgetsByCategory(categoryCode, 0, 0);
	}

	@SuppressWarnings("unchecked")
	public List<Widget> getWidgetsByCategory(final String categoryCode,
			final int start, final int totalRecords) {

		Criteria c = this
				.getCurrentSession()
				.createCriteria(Widget.class)
				.setFetchMode("categories", FetchMode.JOIN)
				.createAlias("categories", "categories")
				.add(Restrictions.eq("categories.shortName",
						categoryCode.toUpperCase()))
				.add(Restrictions.eq("active", true))
				.add(Restrictions.eq("approved",
						WidgetStatus.APPROVED.getValue())).setCacheable(true)
				.addOrder(Order.asc("name").ignoreCase());
		if (totalRecords > 0) {
			c.setFirstResult(start).setMaxResults(totalRecords);

		}
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<Widget> getNewNotableWidgets() {
		List<WidgetDifferentiator> wdts = widgetDifferentiatorDao
				.getDifferentiatorWidgets(WidgetDifferentiatorCode.NEWNOTABLE
						.getValue());
		return getwidgetList(wdts);
	}

	@SuppressWarnings("unchecked")
	public List<Widget> getFeaturedWidgets() {
		List<WidgetDifferentiator> wdts = widgetDifferentiatorDao
				.getDifferentiatorWidgets(WidgetDifferentiatorCode.FEATURED
						.getValue());
		return getwidgetList(wdts);
	}

	@SuppressWarnings("unchecked")
	public List<Widget> getPromoWidgets() {
		List<WidgetDifferentiator> wdts = widgetDifferentiatorDao
				.getDifferentiatorWidgets(WidgetDifferentiatorCode.PROMO
						.getValue());
		return getwidgetList(wdts);
	}

	@SuppressWarnings("unchecked")
	public List<Widget> getDefaultWidgets() {
		List<WidgetDifferentiator> wdts = widgetDifferentiatorDao
				.getDifferentiatorWidgets(WidgetDifferentiatorCode.DEFAULT
						.getValue());
		return getwidgetList(wdts);
	}

	private List<Widget> getwidgetList(List<WidgetDifferentiator> wdts) {
		List<Widget> result = new ArrayList<Widget>();
		for (WidgetDifferentiator wdt : wdts) {
			result.add(wdt.getWidget());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Widget> getWidgetsByCategory(final long categoryId,
			final int start, final int totalRecords) {
		Criteria c = this
				.getCurrentSession()
				.createCriteria(Category.class)
				.add(Restrictions.eq("id", categoryId))
				.setFetchMode("widgets", FetchMode.JOIN)
				.createAlias("widgets", "widgets")
				.add(Restrictions.eq("widgets.active", true))
				.add(Restrictions.eq("widgets.approved",
						WidgetStatus.APPROVED.getValue()))
				.addOrder(Order.asc("name").ignoreCase())
				.addOrder(Order.desc("created"));

		if (totalRecords > 0) {
			c.setFirstResult(start).setMaxResults(totalRecords);

		}
		return c.list();
	}

}