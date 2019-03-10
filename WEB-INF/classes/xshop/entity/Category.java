package xshop.entity;

import java.util.List;
import java.util.ArrayList;

public class Category{
	final int id;
	String name;
	String picture;
	List<Product> products = new ArrayList<Product>();
    
	public Category(String name) {
		this.id = 0;
		this.name = name;
		this.picture="";
	}
	public Category(String name,String picture) {
		this.id = 0;
		this.name = name;
		this.picture=picture;
	}
	public Category(int id, String name,String picture) {
		this.id = id;
		this.name = name;
		this.picture=picture;
	}
    
	

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
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
	
	public String getPicture() {
		return picture;
	}
	
	public List<Product> getProducts() {
		return products;
	}
}