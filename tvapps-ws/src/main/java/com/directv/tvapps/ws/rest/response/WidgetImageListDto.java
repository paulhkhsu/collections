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

public class WidgetImageListDto extends ResponseRoot{
	@XmlElementWrapper(name="widgetImages")
	@XmlElement(name = "widgetImage")
	List <OneWidgetImageDto> widgetImages = new ArrayList<OneWidgetImageDto>();

	public void addOneWidgetImageDto(OneWidgetImageDto wdt)
	{
		widgetImages.add(wdt);
	}
}
