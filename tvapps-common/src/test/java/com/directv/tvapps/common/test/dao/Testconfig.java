package com.directv.tvapps.common.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testconfig {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
			String[] beans = ac.getBeanDefinitionNames();
			for(String s : beans)
				System.out.println(s);
				
	}

}
