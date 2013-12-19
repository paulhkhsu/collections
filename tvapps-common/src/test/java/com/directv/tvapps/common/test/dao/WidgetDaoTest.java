package com.directv.tvapps.common.test.dao;

import com.directv.tvapps.common.dao.CategoryDao;
import com.directv.tvapps.common.dao.WidgetDao;
import com.directv.tvapps.common.dao.impl.WidgetDaoImpl;
import com.directv.tvapps.common.dao.util.DaoUtil;
import com.directv.tvapps.common.pojo.Category;
import com.directv.tvapps.common.pojo.ReceiverModel;
import com.directv.tvapps.common.pojo.Widget;
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
public class WidgetDaoTest {

	// this instance will be (automatically) dependency injected
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private WidgetDao dao;

	//@Test
	public void testGet() throws Exception {
		Widget m = dao.get(new Long(10007));
		// assertNotNull(m);
		System.out.println(m.getDescription());
	}

	//@Test
	public void testGetWidgets() throws Exception {
		List<Widget> l = dao.getWidgets(0, 2);
		// assertNotNull(l);
		for(Widget w: l)
		{
			System.out.println(w.getName());
			
		}
		

	}
	//@Test
	public void testgetNewAddedWidgets() throws Exception {
		
		List<Widget> l1 = dao.getNewAddedWidgets(0,2,200);
		// assertNotNull(l);
		for(Widget w: l1)
		{
			System.out.println(w.getName());
			
		}

	}
	
	@Test
	public void testTopRated() throws Exception {
		List<Widget> l2 = dao.getTopRatedWidgets(1,10);
		// assertNotNull(l);
		for(Widget w: l2)
		{
			//System.out.println(w.getName() + " " + w.getWidgetStat().getSetupCount());
			System.out.println(w.toString());
		}
	}
	
	
	
	//@Test
	public void testCat() throws Exception {
		List<Widget> l3 = dao.getWidgetsByCategory("F&G", 0,2);
		// assertNotNull(l);
		System.out.println(l3.size());
		for(Widget w: l3)
		{
			System.out.println(w.getName() + " " + w.getWidgetStat().getSetupCount());
			
		}
	}

	@Before
	public void onSetUp() throws Exception {
		DaoUtil.bindSessionFactory(dao);
	}

	@After
	public void onTearDown() throws Exception {
		DaoUtil.unBindSessionFactory(dao);
	}

}
