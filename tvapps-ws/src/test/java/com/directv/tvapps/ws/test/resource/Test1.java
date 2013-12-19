package com.directv.tvapps.ws.test.resource;

import static org.junit.Assert.*;

import com.directv.tvapps.common.dao.CategoryDao;
import com.directv.tvapps.common.dao.util.DaoUtil;
import com.directv.tvapps.common.pojo.Category;
import com.directv.tvapps.ws.rest.response.TestListDto;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.math.BigDecimal;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class Test1 {

	// this instance will be (automatically) dependency injected
	public void testWidget() {
		Client c = Client.create();
		WebResource r = c
				.resource("http://localhost:8080/tvapps-ws/rest/widget");
		ClientResponse response = r.get(ClientResponse.class);
		System.out.println(response.getStatus());
		System.out.println(response.getHeaders().get("Content-Type"));
		TestListDto entity = response.getEntity(TestListDto.class);
		System.out.println(entity);

	}

	public void testWidgetJson() {
		Client c = Client.create();
		WebResource r = c
				.resource("http://localhost:8080/tvapps-ws/rest/widget");

		ClientResponse response = r.queryParam("format", "json").get(
				ClientResponse.class);

		System.out.println(response.getStatus());
		System.out.println(response.getHeaders().get("Content-Type"));

		TestListDto entity = response.getEntity(TestListDto.class);
		System.out.println(entity);

	}

	@Before
	public void onSetUp() throws Exception {
	}

	@After
	public void onTearDown() throws Exception {
	}
}
