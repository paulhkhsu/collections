package com.directv.tvapps.common.dao;
/*
 * @author Paul Hsu
 */

import com.directv.tvapps.common.pojo.WidgetRating;

public interface WidgetRatingDao extends DaoBase<Long, WidgetRating> {
	public WidgetRating getWidgetRating(final long userAccountId,
			final long widgetId);

}