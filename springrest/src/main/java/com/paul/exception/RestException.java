package com.paul.exception;

public class RestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestException(String exceptionMsg) {
		super(exceptionMsg);
	}

}
