package com.directv.tvapps.ws.rest.dtoconverter;

import javax.ws.rs.core.UriInfo;

import com.directv.tvapps.common.pojo.Widget;
import com.directv.tvapps.ws.rest.response.OneWidgetDto;

public class WidgetDtoConverter {

	static public OneWidgetDto widget2WidgetDto(Widget w, String link)
	{
		OneWidgetDto wdto = new OneWidgetDto();
		wdto.setActive(true);
		wdto.setAdditionalMetadata(w.getAdditionalMetadata());
		wdto.setApproved(w.getApproved());
		wdto.setClassificationCode(w.getClassificationCode());
		wdto.setCreated(w.getCreated());
		wdto.setCreatorName(w.getCreatorName());
		wdto.setCustomerInfo(w.getCustomerInfo());
		wdto.setDefaultDockiconUrl(w.getDefaultDockiconUrl());
		wdto.setDescription(w.getDescription());
		wdto.setDockRefreshRate(w.getDockRefreshRate());
		wdto.setId(w.getId());
		wdto.setLink(link);
		wdto.setManifestUrl(w.getManifestUrl());
		wdto.setMaxSubscriptions(w.getMaxSubscriptions());
		wdto.setName(w.getName());
		wdto.setSecondaryUrl(w.getSecondaryUrl());
		wdto.setTypeCode(w.getTypeCode());
		
		return wdto;
	}
}
