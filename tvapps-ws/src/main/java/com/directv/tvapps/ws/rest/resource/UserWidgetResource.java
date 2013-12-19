package com.directv.tvapps.ws.rest.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.directv.tvapps.ws.rest.response.TestDto;
import com.directv.tvapps.ws.rest.response.TestListDto;
import com.directv.tvapps.ws.service.TestService;

@Produces({ "application/xml", "application/json" })
@Path("userwidget")
@Component
@Scope("singleton")
public class UserWidgetResource {
	@Autowired
	private TestService testService;

	/*
	 * Get a list of user TV apps
	 */
	@GET
	@Path("list/{rid}/{cardid}/{acctid}")
	public TestListDto getUserWidgets(
			@PathParam("rid") int rid,
			@PathParam("cardid") int cardid,
			@PathParam("acctid") int acctid,
			@DefaultValue("xml") @QueryParam("format") String format) {

		return new TestListDto();
	}

	@GET
	@Path("{userwidgetid}/remove/{rid}/{cardid}/{acctid}")
	public TestDto removeUserWidget(
			@PathParam("userwidgetid") int userwidgetid,
			@PathParam("rid") int rid,
			@PathParam("cardid") int cardid,
			@PathParam("acctid") int acctid,
			@DefaultValue("xml") @QueryParam("format") String format) {

		return new TestDto();
	}

	@GET
	@Path("{userwidgetid}/duplicate/{rid}/{cardid}/{acctid}")
	public TestDto duplicateUserWidget(
			@PathParam("userwidgetid") int userwidgetid,
			@PathParam("rid") int rid,
			@PathParam("cardid") int cardid,
			@PathParam("acctid") int acctid,
			@DefaultValue("xml") @QueryParam("format") String format) {

		return new TestDto();
	}

	@GET
	@Path("{userwidgetid}/resort/{rid}/{cardid}/{acctid}")
	public TestDto resortUserWidget(@QueryParam("newposition") int newPosition,
			@PathParam("userwidgetid") int userwidgetid,
			@PathParam("rid") int rid,
			@PathParam("cardid") int cardid,
			@PathParam("acctid") int acctid,
			@DefaultValue("xml") @QueryParam("format") String format) {

		return new TestDto();
	}

	@GET
	@Path("{userwidgetid}/setoptions/{rid}/{cardid}/{acctid}")
	public TestDto setOptions(
			@PathParam("userwidgetid") int userwidgetid,
			@PathParam("rid") int rid,
			@PathParam("cardid") int cardid,
			@PathParam("acctid") int acctid,
			@DefaultValue("") @QueryParam("options") String options,
			@DefaultValue("xml") @QueryParam("format") String format) {

		return new TestDto();
	}

}