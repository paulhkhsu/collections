package com.directv.tvapps.ws.test.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.directv.tvapps.ws.rest.response.TestDto;
import com.directv.tvapps.ws.rest.response.TestListDto;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JAXBContext context;
		try {
			context = JAXBContext.newInstance(TestDto.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
	        		  Boolean.TRUE);
	        m.marshal(new TestDto(), System.out);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			context = JAXBContext.newInstance(TestListDto.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
	        		  Boolean.TRUE);
	        m.marshal(new TestListDto(), System.out);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
