package com.directv.tvapps.ws.rest.web.filter;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;

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

	private HashMap<String, String> map = new HashMap<String, String>();

	private String keyword = "format";

	private String defaultstr = "default";

	@Override
	@SuppressWarnings("unchecked")
	public void init(FilterConfig config) throws ServletException {
		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements()) {

			String name = names.nextElement();
			// System.out.println(name + "===" + config.getInitParameter(name));
			if (name.equals("keyword"))
				keyword = config.getInitParameter(name);
			else
				map.put(name, config.getInitParameter(name));
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(new RequestWrapper((HttpServletRequest) request),
				response);
	}

	private class RequestWrapper extends HttpServletRequestWrapper {

		public RequestWrapper(HttpServletRequest request) {
			super(request);
		}

		@Override
		@SuppressWarnings("unchecked")
		public Enumeration getHeaders(String name) {
			// System.out.println("name" + name);
			if ("accept".equals(name)) {
				String type = super.getParameter(keyword);
				String accept = map.get(type);
				String deft = map.get(defaultstr);
				// System.out.println("type=" + type + ";;;" + accept +";;;" +
				// deft);

				if (StringUtils.isEmpty(type) && StringUtils.isNotEmpty(deft)) {
					accept = deft;
				}
				if (StringUtils.isNotEmpty(accept)) {
					Vector<String> values = new Vector<String>();
					values.add(accept);
					return values.elements();
				}
			}
			return super.getHeaders(name);
		}
	}
}