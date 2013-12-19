package com.directv.tvapps.common.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.directv.tvapps.common.dao.WidgetDao;
import com.directv.tvapps.common.dao.impl.WidgetDaoImpl;
import com.directv.tvapps.common.dao.impl.WidgetDifferentiatorDaoImpl;
import com.directv.tvapps.common.enums.WidgetType;
import com.directv.tvapps.common.pojo.Widget;
import com.directv.tvapps.common.pojo.WidgetDifferentiator;
import com.directv.tvapps.common.pojo.WidgetStat;
import com.directv.tvapps.common.util.SpringBeanUtil;

@Service("widgetService")
@Transactional(rollbackFor = RuntimeException.class)
public class WidgetService {
	private static Log log = LogFactory.getLog(WidgetService.class);
	@Autowired
	private WidgetDao widgetDao;

	public List<Widget> getWidgets() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Widget> getWidgets(boolean active, short status) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Widget> getWidgets(boolean active, short status, String category) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get widgets list by different type request.
	 * 
	 * @param type
	 *            : ALL, NEW, TOPRATED, NEWNOTABLE, FEATURED, PROMO
	 * @param pageNumber
	 *            : 1 .. n
	 * @param pageSize
	 *            : 1 .. n
	 */

	public List<Widget> getWidgetsByType(String type, int pageNumber,
			int pageSize) {
		if (StringUtils.isEmpty(type))
			type = "ALL";
		type = type.toUpperCase();
		WidgetType wt = WidgetType.valueOf(type);
		int page = pageNumber < 0 ? 0 : pageNumber - 1;
		int start = pageSize * page;
		List<Widget> result = null;

		log.debug(start + " : " + pageSize);
		switch (wt) {
		case ALL:
			result = widgetDao.getWidgets(start, pageSize);
			break;
		case NEW:
			result = widgetDao.getNewAddedWidgets(start, pageSize, 7);
			break;
		case TOPRATED:
			result = widgetDao.getTopRatedWidgets(start, pageSize);
			break;
		case NEWNOTABLE:
			result = widgetDao.getNewNotableWidgets();
			break;
		case FEATURED:
			result = widgetDao.getFeaturedWidgets();
			break;
		case PROMO:
			result = widgetDao.getPromoWidgets();
		default:
			break;
		}
		return result;
	}

	public Widget getWidget(long widgetId) {
		return widgetDao.get(widgetId);
	}

	public long getWidgetRating(long widgetId) {
		Widget widget = widgetDao.get(widgetId);
		WidgetStat widgetStat = widget.getWidgetStat();
		if (widgetStat == null)
			return 0;
		return widgetStat.getAvgRating();
	}

	public int getWidgetUserRating(long widgetId, long acctId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getWidgetUserRating(long widgetId, String rid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int setWidgetUserRating(long widgetId, long acctId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int setWidgetUserRating(long widgetId, String rid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addWidgetToUser(long widgetId, long acctId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addWidgetToUser(long widgetId, String rid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getWidgetCategories(long widgetId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
