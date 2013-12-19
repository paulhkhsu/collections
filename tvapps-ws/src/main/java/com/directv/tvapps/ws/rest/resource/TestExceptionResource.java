package com.directv.tvapps.ws.rest.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.directv.tvapps.ws.rest.exception.RestServiceException;
import com.directv.tvapps.ws.rest.response.TestListDto;


@Produces({ "application/xml", "application/json" })
@Path("except")
@Component
@Scope("singleton")
public class TestExceptionResource {

	@GET
	@Path("{yn}")
	public TestListDto test1(@PathParam("yn") String yn){
		if(yn.equalsIgnoreCase("Y"))
		throw new RestServiceException(3, "test mesage");
		return new TestListDto();
	}


}