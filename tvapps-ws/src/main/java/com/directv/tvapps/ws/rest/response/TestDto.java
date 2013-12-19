package com.directv.tvapps.ws.rest.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.directv.tvapps.ws.dto.Customer;

@XmlRootElement(name = "tvapps")
@XmlAccessorType(XmlAccessType.NONE)

public class TestDto extends ResponseRoot {
	@XmlElement(name="customer")
  private Customer customer=new Customer();


}