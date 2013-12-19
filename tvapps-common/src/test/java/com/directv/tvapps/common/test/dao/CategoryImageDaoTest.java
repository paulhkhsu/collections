package com.directv.tvapps.common.test.dao;

import com.directv.tvapps.common.dao.CategoryImageDao;
import com.directv.tvapps.common.dao.WidgetImageDao;
import com.directv.tvapps.common.dao.util.DaoUtil;
import com.directv.tvapps.common.pojo.CategoryImage;
import com.directv.tvapps.common.pojo.WidgetImage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class CategoryImageDaoTest {

	// this instance will be (automatically) dependency injected
	@Autowired
	private CategoryImageDao dao;

	// a setter method to enable DI
	public void setCategoryImageDao(CategoryImageDao dao) {
		this.dao = dao;
	}

	@Test
	public void testGet() throws Exception {
		CategoryImage m = dao.get(new Long(6044));

		if (m != null)
			System.out.println(m.toString());
	}

	@Test
	public void testGetall() throws Exception {
		List<CategoryImage> l = dao.getAll();
		// assertNotNull(l);
		System.out.println(l.get(0));
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
