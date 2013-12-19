package com.paul.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.paul.dto.Product;



@XmlRootElement(name = "myco")
public class ProductResponse extends ResponseRoot {

    @XmlElement(name="product")
	Product product = new Product();

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
