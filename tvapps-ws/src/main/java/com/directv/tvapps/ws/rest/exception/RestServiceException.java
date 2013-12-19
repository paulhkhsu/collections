package com.directv.tvapps.ws.rest.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.directv.tvapps.ws.rest.response.ErrorDto;

public class RestServiceException extends WebApplicationException{

	private static final long serialVersionUID = 1L;

	public RestServiceException(int errorCode, String message)
	{
		super(buildResponse(errorCode, message));
	}

	static private Response buildResponse(int errorCode, String message)
	{
		ErrorDto dto = new ErrorDto();
		dto.setErrorCode(""+errorCode);
		dto.setErrorText(message);
		Response r = Response.status(Response.Status.OK).entity(dto).build();
		return r;
	}
}
