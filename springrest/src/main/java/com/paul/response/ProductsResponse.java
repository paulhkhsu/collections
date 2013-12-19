package com.paul.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.paul.dto.Product;

@XmlRootElement(name = "myco")
public class ProductsResponse extends ResponseRoot {

	@XmlElementWrapper(name = "products")
	@XmlElement(name = "product")
	List<Product> products = new ArrayList<Product>();

	public ProductsResponse() {
		products.add(new Product());
		products.add(new Product());
		products.add(new Product());
		products.add(new Product());
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
