package xshop.entity;

public class Purchase{
	final int id;
	String date;
	int quantity;
	double buyingPrice;
	Product product;
	
	public Purchase(String date,int quantity,double buyingPrice,Product product) {
		this.id = 0;
		this.date = date;
		this.quantity = quantity;
		this.buyingPrice=buyingPrice;
		this.product=product;
	}
    
	public Purchase(int id,String date,int quantity,double buyingPrice,Product product) {
		this.id = id;
		this.date = date;
		this.quantity = quantity;
		this.buyingPrice=buyingPrice;
		this.product=product;
	}
	
	public int getId(){
		return id;
	}
	
	public String getDate(){
		return date;
	}
	
	public int getQuantity(){
		
		return quantity;
	}
	
	public double getBuyingPrice(){
		return buyingPrice;
	}
	
	public Product getProduct(){
		return product;
	}
    
}