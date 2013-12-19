import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.paul.response.ProductsResponse;


public class MarshallTest {

	/**
	 * @param args
	 * @throws JAXBException 
	 */
	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		 // Marshalling
		
		ProductsResponse pe = new ProductsResponse();
		  JAXBContext context = JAXBContext.newInstance(pe.getClass());
		  Marshaller marshaller = context.createMarshaller();

		  StringWriter writer = new StringWriter();
		  marshaller.marshal(pe, writer);

		  String outString = writer.toString();
System.out.println(outString);
	}

}
