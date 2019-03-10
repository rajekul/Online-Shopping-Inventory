package xshop.entity;
public class Cart{
	int quantity;
	Product product;
	public Cart(int quantity,Product product){
		this.quantity=quantity;
		this.product=product;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public Product getProduct(){
		return product;
	}
}