package com.directv.tvapps.ws.test.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.codehaus.jettison.AbstractXMLStreamWriter;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamReader;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;
import org.codehaus.jettison.mapped.Configuration;

import com.directv.tvapps.ws.rest.response.TestListDto;


public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.test2();
	}

	public void test2() {
		StringWriter writer = new StringWriter();
		try {
			TestListDto td = new TestListDto();

			JAXBContext jc;

			jc = JAXBContext.newInstance(TestListDto.class);
			Configuration config = new Configuration();
			MappedNamespaceConvention con = new MappedNamespaceConvention(
					config);
			XMLStreamWriter xmlStreamWriter = new MappedXMLStreamWriter(con,
					writer);

			Marshaller marshaller = jc.createMarshaller();
			marshaller.marshal(td, xmlStreamWriter);
			System.out.println(writer.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		try {

			JAXBContext jc = JAXBContext.newInstance(TestListDto.class);

			JSONObject obj = new JSONObject(writer.toString());
			Configuration config = new Configuration();
			MappedNamespaceConvention con = new MappedNamespaceConvention(
					config);
			XMLStreamReader xmlStreamReader;
			xmlStreamReader = new MappedXMLStreamReader(obj, con);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			TestListDto dto2 = (TestListDto) unmarshaller
					.unmarshal(xmlStreamReader);

			System.out.println(dto2.toString());
		} catch (JAXBException e) {
			e.printStackTrace();

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void testfromfile()
	{
		try {

			JAXBContext jc = JAXBContext.newInstance(TestListDto.class);

			JSONObject obj = new JSONObject(readFileAsString("testjson.txt"));
			Configuration config = new Configuration();
			MappedNamespaceConvention con = new MappedNamespaceConvention(
					config);
			XMLStreamReader xmlStreamReader;
			xmlStreamReader = new MappedXMLStreamReader(obj, con);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			TestListDto dto2 = (TestListDto) unmarshaller
					.unmarshal(xmlStreamReader);

			System.out.println(dto2.toString());
		} catch (JAXBException e) {
			e.printStackTrace();

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private static String readFileAsString(String filePath)
    throws java.io.IOException{
        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[10000];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1000];
        }
        reader.close();
        return fileData.toString();
    }


}
