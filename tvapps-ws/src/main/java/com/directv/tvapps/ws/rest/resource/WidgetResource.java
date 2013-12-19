package com.directv.tvapps.ws.rest.resource;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.directv.tvapps.common.pojo.Category;
import com.directv.tvapps.common.pojo.Receiver;
import com.directv.tvapps.common.pojo.UserWidget;
import com.directv.tvapps.common.pojo.Widget;
import com.directv.tvapps.common.pojo.WidgetImage;
import com.directv.tvapps.common.pojo.WidgetRating;
import com.directv.tvapps.common.service.ReceiverService;
import com.directv.tvapps.common.service.UserWidgetService;
import com.directv.tvapps.common.service.WidgetImageService;
import com.directv.tvapps.common.service.WidgetRatingService;
import com.directv.tvapps.common.service.WidgetService;
import com.directv.tvapps.ws.rest.dtoconverter.CategoryDtoConverter;
import com.directv.tvapps.ws.rest.dtoconverter.WidgetDtoConverter;
import com.directv.tvapps.ws.rest.dtoconverter.WidgetImageDtoConverter;
import com.directv.tvapps.ws.rest.dtoconverter.WidgetRatingDtoConverter;
import com.directv.tvapps.ws.rest.exception.RestServiceException;
import com.directv.tvapps.ws.rest.response.CategoryListDto;
import com.directv.tvapps.ws.rest.response.OneWidgetDto;
import com.directv.tvapps.ws.rest.response.OneWidgetImageDto;
import com.directv.tvapps.ws.rest.response.OneWidgetRatingDto;
import com.directv.tvapps.ws.rest.response.StatusDto;
import com.directv.tvapps.ws.rest.response.WidgetDto;
import com.directv.tvapps.ws.rest.response.WidgetImageListDto;
import com.directv.tvapps.ws.rest.response.WidgetListDto;
import com.directv.tvapps.ws.rest.response.WidgetRatingDto;

@Produces({ "application/xml", "application/json" })
@Path("widget")
@Component
@Scope("singleton")
public class WidgetResource {
	private static Log log = LogFactory.getLog(WidgetResource.class);
	@Autowired
	private WidgetService widgetService;
	@Autowired
	private WidgetImageService widgetImageService;
	@Autowired
	private WidgetRatingService widgetRatingService;
	@Autowired
	private ReceiverService receiverService;
	@Autowired
	private UserWidgetService userWidgetService;

	/*
	 * Get a list of TV apps by type
	 */
	@GET
	public Response getWidgets(
			// public WidgetListDto getWidgets(
			@DefaultValue("ALL") @QueryParam("type") String type,
			@DefaultValue("0") @QueryParam("count") int count,
			@DefaultValue("0") @QueryParam("pageNum") int pageNum,
			@DefaultValue("false") @QueryParam("expandCollections") boolean expandCollections,
			@DefaultValue("false") @QueryParam("expandMembers") boolean expandMembers,
			@DefaultValue("xml") @QueryParam("format") String format,
			@Context UriInfo uriInfo) {
		List<Widget> widgets = widgetService.getWidgetsByType(type, pageNum,
				count);

		if (expandMembers) {
			WidgetListDto widgetListDto = prepareWidgetListDto(widgets, uriInfo);
			return Response.ok(widgetListDto).build();
		} else {
			WidgetListDto widgetListDto = prepareWidgetListDto(widgets, uriInfo);
			return Response.ok(widgetListDto).build();
		}
	}

	@GET
	@Path("{widgetid}")
	public WidgetDto getWidget(@PathParam("widgetid") long widgetId,
			@DefaultValue("xml") @QueryParam("format") String format,
			@Context UriInfo uriInfo) {
		Widget w = widgetService.getWidget(widgetId);
		WidgetDto widgetDto = new WidgetDto();
		String link = uriInfo.getAbsolutePath().toString();
		OneWidgetDto wdt = WidgetDtoConverter.widget2WidgetDto(w, link);
		widgetDto.setOneWidget(wdt);
		widgetDto.setLink(uriInfo);
		return widgetDto;
	}

	@GET
	@Path("{widgetid}/getrating/{rid}/{cardid}/{acctid}")
	public WidgetRatingDto getWidgetRating(
			@PathParam("widgetid") long widgetid, @PathParam("rid") String rid,
			@PathParam("cardid") String cardid,
			@PathParam("acctid") long acctid,
			@DefaultValue("xml") @QueryParam("format") String format,
			@Context UriInfo uriInfo) {
		WidgetRating wr = widgetRatingService.getWidgetRating(acctid, widgetid);
		if (wr == null)
			throw new RestServiceException(1, "No record found.");

		OneWidgetRatingDto onewr = WidgetRatingDtoConverter
				.widgetRating2WidgetRatingDto(wr);

		WidgetRatingDto result = new WidgetRatingDto();
		result.setOneWidgetRating(onewr);
		return result;
	}

	@GET
	@Path("{widgetid}/setrating/{rid}/{cardid}/{acctid}")
	public StatusDto setWidgetRating(@PathParam("widgetid") long widgetid,
			@PathParam("rid") String rid, @PathParam("cardid") String cardid,
			@PathParam("acctid") long acctid,
			@DefaultValue("0") @QueryParam("rate") int rate,
			@DefaultValue("xml") @QueryParam("format") String format,
			@Context UriInfo uriInfo) {

		log.debug(rid + " " + cardid);
		WidgetRating wr = widgetRatingService.getWidgetRating(acctid, widgetid);

		if (wr == null) {
			wr = new WidgetRating();
			wr.setRating(rate);
			wr.setUserAccountId(acctid);
			wr.setWidgetId(widgetid);
		}
		wr.setRating(rate);
		widgetRatingService.saveUpdateWidgetRating(wr);
		StatusDto result = new StatusDto();

		return result;
	}

	@POST
	@Path("{widgetid}/addmywidget/{rid}/{cardid}/{acctid}")
	public StatusDto addMyWidget(@PathParam("widgetid") long widgetid,
			@PathParam("rid") String rid, @PathParam("cardid") String cardid,
			@PathParam("acctid") long acctid,
			@DefaultValue("xml") @QueryParam("format") String format,
			@Context UriInfo uriInfo) {

		Receiver receiver = receiverService.getReceiver(rid, cardid, acctid);
		if (receiver == null)
			throw new RestServiceException(2, "Reciever not found.");
		Widget widget = widgetService.getWidget(widgetid);
		if (widget == null)
			throw new RestServiceException(2, "Widget not found.");
		UserWidget userWidget = userWidgetService.createUserWidget(widget,
				receiver);
		userWidgetService.saveUserWidget(userWidget);
		StatusDto result = new StatusDto();

		return result;
	}

	@GET
	@Path("{widgetid}/image")
	public WidgetImageListDto getImage(@PathParam("widgetid") int widgetId,
			@DefaultValue("xml") @QueryParam("format") String format,
			@Context UriInfo uriInfo) {

		List<WidgetImage> wis = widgetImageService.getWidgetImages(widgetId);
		WidgetImageListDto widgetImageListDto = new WidgetImageListDto();
		for (WidgetImage w : wis) {
			OneWidgetImageDto wdt = WidgetImageDtoConverter
					.widgetImage2WidgetImageDto(w);
			widgetImageListDto.addOneWidgetImageDto(wdt);
		}
		widgetImageListDto.setLink(uriInfo);
		return widgetImageListDto;
	}

	@GET
	@Path("{widgetid}/category")
	public CategoryListDto getCategory(@PathParam("widgetid") long widgetid,
			@DefaultValue("xml") @QueryParam("format") String format,
			@Context UriInfo uriInfo) {

		Widget widget = widgetService.getWidget(widgetid);
		CategoryListDto categoryListDto = new CategoryListDto();
		Set<Category> cats = widget.getCategories();
		for (Category c : cats)
			categoryListDto.addOneCategoryDto(CategoryDtoConverter
					.category2CategoryDto(c));
		categoryListDto.setLink(uriInfo);
		return categoryListDto;
	}

	private WidgetListDto prepareWidgetListDto(List<Widget> widgets,
			UriInfo uriInfo) {
		WidgetListDto widgetListDto = new WidgetListDto();
		for (Widget w : widgets) {
			String link = uriInfo.getAbsolutePath() + "/" + w.getId();
			OneWidgetDto wdt = WidgetDtoConverter.widget2WidgetDto(w, link);
			widgetListDto.addOneWidgetDto(wdt);
			// Set<RefreshRate> set1 = w.getRefreshRates();
			// Iterator i1 = set1.iterator();
			// while(i1.hasNext()) System.out.println(i1.next().toString());
			Set<Category> cats = w.getCategories();
			Iterator<Category> it = cats.iterator();
			while (it.hasNext()) {
				Category cat = (Category) it.next();
				wdt.addOneCategoryDto(CategoryDtoConverter
						.category2CategoryDto(cat));
			}

		}
		widgetListDto.setLink(uriInfo);

		return widgetListDto;

	}

}