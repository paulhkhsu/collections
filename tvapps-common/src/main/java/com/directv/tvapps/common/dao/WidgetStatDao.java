package com.directv.tvapps.common.dao;
/*
 * @author Paul Hsu
 */

import java.math.BigDecimal;
import java.util.List;
import com.directv.tvapps.common.pojo.WidgetStat;

public interface WidgetStatDao extends DaoBase<Long, WidgetStat> {
	public void refreshWidgetStatistics();
}