package com.paul.resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.paul.exception.RestException;
import com.paul.response.StatusDto;
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = { RestException.class, IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		System.out.println(ex.getMessage());
		System.out.println(ex.getClass().getName());

		StatusDto dto = new StatusDto();
		dto.setStatus("failure");
		dto.setErrorCode("" + 13);
		dto.setErrorText(ex.getMessage());

		return handleExceptionInternal(ex, dto, 
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}