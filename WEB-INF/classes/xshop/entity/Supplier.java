package xshop.entity;

import java.util.List;
import java.util.ArrayList;

public  class Supplier{
    int id;
    String name;
    String contact;
    List<Product> products= new ArrayList<Product>();
	
	public Supplier(String name,String contact) {
		this.id = 0;
		this.name = name;
		this.contact = contact;
	}
    
	public Supplier(int id, String name,String contact) {
		this.id = id;
		this.name = name;
		this.contact = contact;
	}
    
	public Supplier(int id, String name,String contact, List<Product> products) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.products = products;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void addProduct(List<Product> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String getContact() {
		return contact;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	
}