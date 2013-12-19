package com.directv.tvapps.common.dao;

/*
 * @author Paul Hsu
 */

import java.util.List;

import com.directv.tvapps.common.pojo.Widget;
import com.directv.tvapps.common.pojo.WidgetDifferentiator;

public interface WidgetDao extends DaoBase<Long, Widget> {
	public List<Widget> getWidgets();
	public List<Widget> getWidgets(final int start, final int totalRecords);

	public List<Widget> getNewAddedWidgets(final int days);
	public List<Widget> getNewAddedWidgets(final int start,
			final int totalRecords, final int days);

	public List<Widget> getTopRatedWidgets();
	public List<Widget> getTopRatedWidgets(final int start,
			final int totalRecords);

	public List<Widget> getWidgetsByCategory(final String categoryCode);
	public List<Widget> getWidgetsByCategory(final String categoryCode,
			final int start, final int totalRecords);

	
	public List<Widget> getNewNotableWidgets();

	public List<Widget> getFeaturedWidgets();

	public List<Widget> getPromoWidgets();

	public List<Widget> getDefaultWidgets();

}