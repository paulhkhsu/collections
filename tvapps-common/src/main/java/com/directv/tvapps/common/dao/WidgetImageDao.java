package com.directv.tvapps.common.dao;
/*
 * @author Paul Hsu
 */

import java.math.BigDecimal;
import java.util.List;

import com.directv.tvapps.common.pojo.WidgetImage;

public interface WidgetImageDao extends DaoBase<Long, WidgetImage> {
	public List<WidgetImage> getWidgetImages(final long widgetId);

}