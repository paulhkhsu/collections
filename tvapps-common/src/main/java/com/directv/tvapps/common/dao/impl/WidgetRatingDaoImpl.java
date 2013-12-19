package com.directv.tvapps.common.dao.impl;

/*
 * @author Paul Hsu
 */

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import com.directv.tvapps.common.dao.WidgetRatingDao;
import com.directv.tvapps.common.pojo.WidgetRating;

@Repository("widgetRatingDao")
public class WidgetRatingDaoImpl extends DaoBaseImpl<Long, WidgetRating>
		implements WidgetRatingDao {
	public WidgetRatingDaoImpl() {
	}

	public WidgetRating getWidgetRating(final long userAccountId,
			final long widgetId) {
		Criteria c = this.getSession()
				.createCriteria(WidgetRating.class)
				.add(Restrictions.eq("userAccountId", userAccountId))
				.add(Restrictions.eq("widgetId", widgetId));

		return (WidgetRating)c.uniqueResult();
	}
}