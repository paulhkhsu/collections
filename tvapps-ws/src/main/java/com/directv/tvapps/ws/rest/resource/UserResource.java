package com.directv.tvapps.ws.rest.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.directv.tvapps.ws.dto.Customer;
import com.directv.tvapps.ws.rest.response.ResponseRoot;
import com.directv.tvapps.ws.rest.response.TestDto;
import com.directv.tvapps.ws.rest.response.TestListDto;
import com.directv.tvapps.ws.service.TestService;

import com.sun.jersey.spi.resource.Singleton;

@Produces({ "application/xml", "application/json" })
@Path("user")
@Component
@Scope("singleton")
public class UserResource {
	@Autowired
	private TestService testService;

	@GET
	@Path("getagreement/{rid}/{cardid}/{acctid}")

	public TestListDto getAgreement(
			@PathParam("rid") int rid,
			@PathParam("cardid") int cardid,
			@PathParam("acctid") int acctid,
			@DefaultValue("xml") @QueryParam("format") String format) {

		return new TestListDto();
	}

	@GET
	@Path("acceptagreement/{rid}/{cardid}/{acctid}")
	public TestListDto acceptAgreement(
			@PathParam("rid") int rid,
			@PathParam("cardid") int cardid,
			@PathParam("acctid") int acctid,
			@DefaultValue("xml") @QueryParam("format") String format) {

		return new TestListDto();
	}

}