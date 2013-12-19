package com.directv.tvapps.ws.rest.response;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tvapps")
@XmlAccessorType(XmlAccessType.NONE)

public class CategoryListDto extends ResponseRoot{
	@XmlElementWrapper(name="categories")
	@XmlElement(name = "category")
	Set <OneCategoryDto> categories = new HashSet<OneCategoryDto>();

	public void addOneCategoryDto(OneCategoryDto wdt)
	{
		categories.add(wdt);
	}
}
