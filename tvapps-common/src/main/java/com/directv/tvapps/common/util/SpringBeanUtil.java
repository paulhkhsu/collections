/*
 * SpringBeanUtil.java
 * 
 * Copyright (c) 2011 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.tvapps.common.util;

/**
 * @author Paul Hsu
 * 
 */

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

public class SpringBeanUtil implements ApplicationContextAware {

	public static ApplicationContext applicationContext;
	private static Log log = LogFactory.getLog(SpringBeanUtil.class);
	
	public static void printBeans()
	{
		String[] beans = applicationContext.getBeanDefinitionNames();
		for(String s : beans)
			log.debug(s);
	}

	public static void removeBean(String name) {
		BeanDefinitionRegistry factory = (BeanDefinitionRegistry) applicationContext
				.getAutowireCapableBeanFactory();
		factory.removeBeanDefinition(name);
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static String[] getAllBeans() {
		String[] beans = applicationContext.getBeanDefinitionNames();
		return beans;
	}

	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		applicationContext = context;
	}

}
