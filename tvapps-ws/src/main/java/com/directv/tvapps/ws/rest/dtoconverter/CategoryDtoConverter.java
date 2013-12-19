package com.directv.tvapps.ws.rest.dtoconverter;

import com.directv.tvapps.common.pojo.Category;
import com.directv.tvapps.ws.rest.response.OneCategoryDto;

public class CategoryDtoConverter {

	static public OneCategoryDto category2CategoryDto(Category w)
	{
		OneCategoryDto wdto = new OneCategoryDto();
		wdto.setDescription(w.getDescription());
		wdto.setId(w.getId());
		wdto.setLongName(w.getLongName());
		wdto.setParentId(w.getParentId());
		wdto.setShortName(w.getShortName());
		return wdto;
	}
}
