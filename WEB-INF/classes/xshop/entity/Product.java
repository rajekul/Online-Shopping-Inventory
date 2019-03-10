package xshop.entity;

public class Product{
	final int id;
	String name;
	short stock;
	double buyingPrice;
	double sellingPrice;
	String picture;
	boolean status;	
	Category category;
	Supplier supplier;
	
	
	
	public Product(String name,int stock,double buyingPrice,double sellingPrice,String picture,Category category,Supplier supplier) {
		this.id = 0;
		this.name = name;
		this.stock = (short)stock;
		this.buyingPrice=buyingPrice;
		this.sellingPrice=sellingPrice;
		this.picture=picture;
		if(stock>0){
			this.status=true;
		}
		else{
			this.status=false;
		}
		this.category=category;
		this.supplier=supplier;
	}
    
	public Product(int id,String name,int stock,double buyingPrice,double sellingPrice,String picture,Category category,Supplier supplier) {
		this.id = id;
		this.name = name;
		this.stock = (short)stock;
		this.buyingPrice=buyingPrice;
		this.sellingPrice=sellingPrice;
		this.picture=picture;
		if(stock>0){
			this.status=true;
		}
		else{
			this.status=false;
		}
		this.category=category;
		this.supplier=supplier;
	}
    
	

	public void setName(String name) {
		this.name = name;
	}
	public void setStock(int stock) {
		this.stock = (short)stock;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice=buyingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice=sellingPrice;
	}
	public void setPicture(String picture) {
		this.picture=picture;
	}
	
	public void setStatus(boolean status) {
		this.status=status;
	}
	
	public void addCategory(Category category) {
		this.category=category;
	}
	
	public void addSupplier(Supplier supplier) {
		this.supplier=supplier;
	}

	

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public short getStock() {
		return stock;
	}
	
	public double getBuyingPrice() {
		return buyingPrice;
	}
	
	public double getSellingPrice() {
		return sellingPrice;
	}
	
	public String getPicture() {
		return picture;
	}

	public boolean getStatus(){
		return status;
	}
	
	public Category getCategory(){
		return category;
	}
	
	public Supplier getSupplier(){
		return supplier;
	}
}