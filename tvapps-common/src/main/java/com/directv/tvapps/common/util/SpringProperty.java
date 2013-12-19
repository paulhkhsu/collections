package com.directv.tvapps.common.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.directv.tvapps.common.service.CacheUtil;

public class SpringProperty extends PropertyPlaceholderConfigurer {
	Properties pro;
	private static final Log log = LogFactory.getLog(SpringProperty.class);

	public String getProperty(String key) {
		if (pro == null) {
			try {
				pro = mergeProperties();
			} catch (IOException e) {
				log.error(e);
				return null;
			}
		}

		return pro.getProperty(key);
	}
}
