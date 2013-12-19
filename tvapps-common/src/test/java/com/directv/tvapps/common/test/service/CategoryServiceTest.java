package com.directv.tvapps.common.test.service;

import java.util.List;

import com.directv.tvapps.common.pojo.Category;
import com.directv.tvapps.common.pojo.Widget;
import com.directv.tvapps.common.service.CategoryService;
import com.directv.tvapps.common.service.WidgetService;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class CategoryServiceTest {

	// this instance will be (automatically) dependency injected
	@Autowired
	private CategoryService svc;

	@Test
	public void testOne() throws Exception {
		List<Category> ws = svc.getCategories();
		for(Category w : ws)
			System.out.println(w.getDescription());
	}

}
