package com.directv.tvapps.ws.rest.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.directv.tvapps.ws.dto.Customer;

@XmlRootElement(name = "tvapps")
@XmlAccessorType(XmlAccessType.NONE)

public class TestListDto extends ResponseRoot {
	@XmlElementWrapper(name="customers")
	@XmlElement(name = "a-customer")
	List <Customer> list = new ArrayList<Customer>();
	@XmlElement
	private int other=0;
	@XmlElement
	private String others="other";
	
	public TestListDto()
	{
		list.add(new Customer());
		list.add(new Customer());
		list.add(new Customer());
	}
}
