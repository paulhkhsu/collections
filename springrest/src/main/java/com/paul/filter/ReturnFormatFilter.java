package com.paul.filter;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Paul Hsu To overwrite accept type if URI has format=xml|json appear
 *         Set up in web.xml <filter> <filter-name>accept-filter</filter-name>
 *         <filter-class>
 *         com.directv.tvapps.stbrest.web.filter.ReturnFormatFilter
 *         </filter-class> <init-param> <param-name>keyword</param-name>
 *         <param-value>format</param-value> </init-param> <init-param>
 *         <param-name>xml</param-name>
 *         <param-value>application/xml</param-value> </init-param> <init-param>
 *         <param-name>json</param-name>
 *         <param-value>application/json</param-value> </init-param> </filter>
 *         <filter-mapping> <filter-name>accept-filter</filter-name>
 *         <url-pattern>/rest/*</url-pattern> </filter-mapping>
 */

public class ReturnFormatFilter implements Filter {
	final Logger logger = LoggerFactory.getLogger(ReturnFormatFilter.class);
	private HashMap<String, String> map = new HashMap<String, String>();

	private String fmt = null;

	private String defaultstr = "default";

	@Override
	@SuppressWarnings("unchecked")
	public void init(FilterConfig config) throws ServletException {
		// logger.debug("in init");
		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements()) {

			String name = names.nextElement();
			System.out.println(name + "===" + config.getInitParameter(name));
			if (name.equals("keyword"))
				fmt = config.getInitParameter(name);
			else
				map.put(name, config.getInitParameter(name));
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest newReq = new RequestWrapper((HttpServletRequest) req);
		chain.doFilter(newReq, res);
	}

	private class RequestWrapper extends HttpServletRequestWrapper {

		public RequestWrapper(HttpServletRequest request) {
			super(request);
		}

		public String getHeader(String name) {
			// get the request object and cast it
			HttpServletRequest request = (HttpServletRequest) getRequest();
			System.out.println(name + "===" + request.getHeader(name));
			// if we are looking for the "username" request header
			if ("Accept".equalsIgnoreCase(name)) {
				String type = request.getParameter(fmt);
				String accept = map.get(type);
				String deft = map.get(defaultstr);
				System.out.println("type=" + type + ";;;" + accept + ";;;"
						+ deft);
				if (StringUtils.isEmpty(type) && StringUtils.isNotEmpty(deft)) {
					accept = deft;
				}
				if (StringUtils.isNotEmpty(accept)) {
					System.out.println("final=" + accept);
					return accept;
				}
			}

			// otherwise fall through to wrapped request object
			return request.getHeader(name);
		}
	}
}