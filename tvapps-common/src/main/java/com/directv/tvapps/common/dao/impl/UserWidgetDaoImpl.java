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
import com.directv.tvapps.common.dao.UserWidgetDao;
import com.directv.tvapps.common.dao.WidgetDao;

import com.directv.tvapps.common.pojo.Problem;
import com.directv.tvapps.common.pojo.ReceiverModel;
import com.directv.tvapps.common.pojo.UserWidget;
import com.directv.tvapps.common.pojo.Widget;

@Repository("userWidgetDao")
public class UserWidgetDaoImpl extends DaoBaseImpl<Long, UserWidget>
		implements UserWidgetDao {
	public UserWidgetDaoImpl() {
	}

}