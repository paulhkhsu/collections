package com.directv.tvapps.ws.rest.dtoconverter;

import com.directv.tvapps.common.pojo.WidgetRating;
import com.directv.tvapps.ws.rest.response.OneWidgetRatingDto;

public class WidgetRatingDtoConverter {

	static public OneWidgetRatingDto widgetRating2WidgetRatingDto(WidgetRating w) {
		OneWidgetRatingDto owi = new OneWidgetRatingDto();
		owi.setId(w.getId());
		owi.setRating(w.getRating());
		owi.setUserAccountId(w.getUserAccountId());
		owi.setWidgetId(w.getWidgetId());
		return owi;
	}
}
