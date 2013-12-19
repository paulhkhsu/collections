package com.directv.tvapps.common.test.dao;

import com.directv.tvapps.common.dao.WidgetRatingDao;
import com.directv.tvapps.common.dao.WidgetStatDao;
import com.directv.tvapps.common.dao.util.DaoUtil;
import com.directv.tvapps.common.pojo.WidgetRating;
import com.directv.tvapps.common.pojo.WidgetStat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import static org.junit.Assert.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class WidgetRatingDaoTest {

	// this instance will be (automatically) dependency injected
	@Autowired
	private WidgetRatingDao dao;

	// a setter method to enable DI
	public void setWidgetRatingDao(WidgetRatingDao dao) {
		this.dao = dao;
	}

	@Test
	public void testGet() throws Exception {
		WidgetRating m = dao.getWidgetRating(2, 14194);

	//	assertNotNull(m);
		System.out.println(m.toString());
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
