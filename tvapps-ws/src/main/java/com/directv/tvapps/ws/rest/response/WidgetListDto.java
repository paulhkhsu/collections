package com.directv.tvapps.ws.rest.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tvapps")
@XmlAccessorType(XmlAccessType.NONE)

public class WidgetListDto extends ResponseRoot{
	@XmlElementWrapper(name="widgets")
	@XmlElement(name = "widget")
	List <OneWidgetDto> widgets = new ArrayList<OneWidgetDto>();

	public void addOneWidgetDto(OneWidgetDto wdt)
	{
		widgets.add(wdt);
	}
}
