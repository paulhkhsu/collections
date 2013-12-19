package com.directv.tvapps.common.dao.impl;
/*
 * @author Paul Hsu
 */

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.directv.tvapps.common.dao.ProblemDao;
import com.directv.tvapps.common.dao.ReceiverModelDao;
import com.directv.tvapps.common.dao.WidgetStatDao;

import com.directv.tvapps.common.pojo.Problem;
import com.directv.tvapps.common.pojo.ReceiverModel;
import com.directv.tvapps.common.pojo.WidgetStat;

@Repository("widgetStatDao")
public class WidgetStatDaoImpl extends DaoBaseImpl<Long, WidgetStat>
		implements WidgetStatDao {
	public WidgetStatDaoImpl() {
	}
	
	public void refreshWidgetStatistics() {
		this.executeStoreProcedure("dbms_mview.refresh(?)", "widget_stat");
	}

}