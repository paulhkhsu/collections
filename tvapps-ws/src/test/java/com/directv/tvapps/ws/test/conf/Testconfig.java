package com.directv.tvapps.ws.test.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.directv.tvapps.common.util.SpringBeanUtil;

public class Testconfig {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
SpringBeanUtil.printBeans();
	}

}
