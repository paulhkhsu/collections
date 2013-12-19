package com.directv.tvapps.common.dao.impl;

/*
 * @author Paul Hsu
 */

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import com.directv.tvapps.common.dao.WidgetImageDao;
import com.directv.tvapps.common.pojo.WidgetImage;

@Repository("widgetImageDao")
public class WidgetImageDaoImpl extends DaoBaseImpl<Long, WidgetImage>
		implements WidgetImageDao {
	public WidgetImageDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<WidgetImage> getWidgetImages(final long widgetId) {
		Criteria c = this.getSession().createCriteria(WidgetImage.class)
				.add(Restrictions.eq("widgetId", widgetId));
		return c.list();
	}

}