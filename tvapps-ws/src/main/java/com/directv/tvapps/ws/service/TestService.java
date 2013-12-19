package com.directv.tvapps.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(value="test")
public class TestService {
	String s = "test";

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}
