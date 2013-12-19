package com.directv.tvapps.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.directv.tvapps.common.dao.CategoryDao;
import com.directv.tvapps.common.pojo.Category;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	public List<Category> getCategories() {

		return categoryDao.getAll();
	}

}
