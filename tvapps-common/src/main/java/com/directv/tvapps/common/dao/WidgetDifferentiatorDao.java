package com.directv.tvapps.common.dao;

/*
 * @author Paul Hsu
 */

import java.math.BigDecimal;
import java.util.List;

import com.directv.tvapps.common.pojo.WidgetDifferentiator;

public interface WidgetDifferentiatorDao extends
		DaoBase<Long, WidgetDifferentiator> {
	public List<WidgetDifferentiator> getDifferentiatorWidgets(final String type);
}