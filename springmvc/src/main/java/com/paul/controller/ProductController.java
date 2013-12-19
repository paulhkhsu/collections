package com.paul.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.paul.dto.Product;
import com.paul.exception.MVCException;;


// exception handler in xml define
//<bean
//class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
//<property name="exceptionMappings">
//	<props>
//		<prop key="com.paul.exception.MVCException">
//			exceptionpage
//		</prop>
//	</props>
//</property>
//<property name="defaultErrorView" value="error" />
//</bean>

@Controller
public class ProductController {
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView product() {
		return new ModelAndView("product", "command", new Product());
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("HelloWeb") Product product,
			ModelMap model) {

		if (product.getName().length() < 5) {
			throw new MVCException("Product Name entered is too short");
		} else {
			model.addAttribute("name", product.getName());
		}

		return "result";
	}
}
