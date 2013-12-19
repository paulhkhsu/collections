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

public class WidgetRatingDto extends ResponseRoot{
	@XmlElement(name = "widgetRating")
	OneWidgetRatingDto widgetRating;

	public OneWidgetRatingDto getWidgetRating() {
		return widgetRating;
	}

	public void setOneWidgetRating(OneWidgetRatingDto widgetRating) {
		this.widgetRating = widgetRating;
	}

}
