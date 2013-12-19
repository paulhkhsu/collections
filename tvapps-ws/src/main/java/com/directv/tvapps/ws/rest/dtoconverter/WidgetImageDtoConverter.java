package com.directv.tvapps.ws.rest.dtoconverter;

import javax.ws.rs.core.UriInfo;

import com.directv.tvapps.common.pojo.Widget;
import com.directv.tvapps.common.pojo.WidgetImage;
import com.directv.tvapps.ws.rest.response.OneWidgetDto;
import com.directv.tvapps.ws.rest.response.OneWidgetImageDto;

public class WidgetImageDtoConverter {

	static public OneWidgetImageDto widgetImage2WidgetImageDto(WidgetImage w) {
		OneWidgetImageDto owi = new OneWidgetImageDto();
		owi.setFileName(w.getFileName());
		owi.setFormat(w.getFormat());
		owi.setHeight(w.getHeight());
		owi.setId(w.getId());
		owi.setSeqNumber(w.getSeqNumber());
		owi.setUrl(w.getUrl());
		owi.setUsageType(w.getUsageType().getName());
		owi.setWidgetId(w.getWidgetId());
		owi.setWidth(w.getWidth());
		return owi;
	}
}
