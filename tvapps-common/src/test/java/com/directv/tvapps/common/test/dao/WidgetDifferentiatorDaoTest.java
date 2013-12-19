package com.directv.tvapps.common.test.dao;

import com.directv.tvapps.common.dao.CategoryDao;
import com.directv.tvapps.common.dao.WidgetDao;
import com.directv.tvapps.common.dao.impl.WidgetDaoImpl;
import com.directv.tvapps.common.dao.impl.WidgetDifferentiatorDaoImpl;
import com.directv.tvapps.common.dao.util.DaoUtil;
import com.directv.tvapps.common.pojo.Category;
import com.directv.tvapps.common.pojo.ReceiverModel;
import com.directv.tvapps.common.pojo.Widget;
import com.directv.tvapps.common.pojo.WidgetDifferentiator;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.math.BigDecimal;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class WidgetDifferentiatorDaoTest {

	// this instance will be (automatically) dependency injected
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private WidgetDifferentiatorDaoImpl dao;


	@Before
	public void onSetUp() throws Exception {
		DaoUtil.bindSessionFactory(dao);
	}

	@After
	public void onTearDown() throws Exception {
		DaoUtil.unBindSessionFactory(dao);
	}

}
