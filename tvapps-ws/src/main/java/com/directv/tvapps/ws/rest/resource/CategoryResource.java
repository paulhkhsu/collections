package com.directv.tvapps.ws.rest.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.directv.tvapps.common.pojo.Category;
import com.directv.tvapps.common.service.CategoryService;
import com.directv.tvapps.ws.rest.dtoconverter.CategoryDtoConverter;
import com.directv.tvapps.ws.rest.response.CategoryListDto;

import com.sun.jersey.spi.resource.Singleton;

@Produces({ "application/xml", "application/json" })
@Path("category")
@Component
@Scope("singleton")
public class CategoryResource {
	@Autowired
	private CategoryService categoryService;

	@GET
	public CategoryListDto getCategory(
			@DefaultValue("xml") @QueryParam("format") String format,
			@Context UriInfo uriInfo) {
		CategoryListDto categoryListDto = new CategoryListDto();
		List<Category> cats = categoryService.getCategories();
		for(Category c : cats)
			categoryListDto.addOneCategoryDto(CategoryDtoConverter.category2CategoryDto(c));
		categoryListDto.setLink(uriInfo);
		return categoryListDto;
	}

	@GET
	@Path("{categoryid}/listwidget")
	public CategoryListDto acceptAgreement(
			@PathParam("categoryid") int categoryid,
			@DefaultValue("xml") @QueryParam("format") String format) {

		return new CategoryListDto();
	}

}