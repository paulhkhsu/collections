package com.paul.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.paul.dto.Product;

import com.paul.exception.RestException;
import com.paul.response.ProductResponse;
import com.paul.response.ProductsResponse;

//exception handler in xml define using @ControllerAdvice

@Controller
public class RestController {
	// http://localhost:8080/springexcept/exptest?error=false|true
	@RequestMapping(value = "/exptest", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody
	ProductResponse extest(@RequestParam("error") boolean er) {

		System.out.println("here");
		// Call service here
		ProductResponse result = new ProductResponse();

		if (!er)
			return result;
		else {

			throw new RestException("errrrrrrrr");

		}

	}

	// http://localhost:8080/springexcept/products?error=false|true
	@RequestMapping(value = "/products", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody
	ProductsResponse extest1(@RequestParam("error") boolean er) {

		System.out.println("here");
		// Call service here
		ProductsResponse result = new ProductsResponse();

		if (!er)
			return result;
		else {

			throw new RestException("errrrrrrrr");

		}

	}

}
