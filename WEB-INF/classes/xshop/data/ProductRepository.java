package xshop.data;


import xshop.entity.*;
import xshop.core.*;
import xshop.config.Connectdb;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductRepository implements iProductRepository{
	
	private static ProductRepository obj;
	Connectdb connectdb;
	Connection con;
	Service<Category> categoryService;
	Service<Supplier> supplierService;
		
	private ProductRepository(){
		connectdb=new Connectdb();
		categoryService=new DataService().Create("Category");
		supplierService=new DataService().Create("Supplier");
	}
	
	public static ProductRepository getObject(){
		if(obj==null){
			obj = new ProductRepository();
		}
		return obj;
	}
	
	
	public boolean add(Product product){
		try{
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Products(ProductName,Stock,BuyingPrice,SellingPrice,Picture,CategoryId,SupplierId) VALUES(?,?,?,?,?,?,?)");
			stmt.setString(1,product.getName());
			stmt.setInt(2,product.getStock());
			stmt.setDouble(3,product.getBuyingPrice());
			stmt.setDouble(4,product.getSellingPrice());
			stmt.setString(5,product.getPicture());
			stmt.setInt(6,product.getCategory().getId());
			stmt.setInt(7,product.getSupplier().getId());
		
			int result = stmt.executeUpdate();
			con.close();
            
			if (result != 0) {
			return true;
			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean edit(Product product){
		try{
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("UPDATE Products SET ProductName=?,Stock=?,BuyingPrice=?,SellingPrice=?,Picture=?,CategoryId=?,SupplierId=? WHERE ProductId=?");
			stmt.setString(1,product.getName());
			stmt.setInt(2,product.getStock());
			stmt.setDouble(3,product.getBuyingPrice());
			stmt.setDouble(4,product.getSellingPrice());
			stmt.setString(5,product.getPicture());
			stmt.setInt(6,product.getCategory().getId());
			stmt.setInt(7,product.getSupplier().getId());
			stmt.setInt(8,product.getId());
		
			int result = stmt.executeUpdate();
			con.close();
            
			if (result != 0) {
			return true;
			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean remove(int productId){
		try{
			con=connectdb.getConn();
			PreparedStatement stmt=con.prepareStatement("DELETE FROM Products WHERE ProductId=?");
			stmt.setInt(1,productId);
			
			int result=stmt.executeUpdate();
			con.close();
			
			if(result != 0){
				return true;
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public List<Product> getAll(){
		List<Product> productList = new ArrayList<Product>();
		try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Products");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Product product = new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getInt("Stock"),rs.getDouble("BuyingPrice"),rs.getDouble("SellingPrice"),rs.getString("Picture"),categoryService.getById(rs.getInt("CategoryId")),supplierService.getById(rs.getInt("SupplierId")));
				productList.add(product);
			}
			con.close();

		} catch (Exception e) {

		}
		return productList;
		
	}
	
	public List<Product>  search(String productName) {
		List<Product> productList = new ArrayList<Product>();
		try {
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Products WHERE ProductName LIKE ?");
			stmt.setString(1,"%"+productName+"%");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Product product = new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getInt("Stock"),rs.getDouble("BuyingPrice"),rs.getDouble("SellingPrice"),rs.getString("Picture"),categoryService.getById(rs.getInt("CategoryId")),supplierService.getById(rs.getInt("SupplierId")));
				productList.add(product);
			}
			con.close();

		} catch (Exception e) {

		}
		return productList;
	}
	
	public List<Product> getByCategory(int categoryId) {
		List<Product> productList = new ArrayList<Product>();
		try {
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Products WHERE categoryId=?");
			stmt.setInt(1,categoryId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Product product = new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getInt("Stock"),rs.getDouble("BuyingPrice"),rs.getDouble("SellingPrice"),rs.getString("Picture"),categoryService.getById(rs.getInt("CategoryId")),supplierService.getById(rs.getInt("SupplierId")));
				productList.add(product);
			}
			con.close();

		} catch (Exception e) {

		}
		return productList;
	}
	
	public List<Product> getBySupplier(int supplierId) {
		List<Product> productList = new ArrayList<Product>();
		try {
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Products WHERE supplierId=?");
			stmt.setInt(1,supplierId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Product product = new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getInt("Stock"),rs.getDouble("BuyingPrice"),rs.getDouble("SellingPrice"),rs.getString("Picture"),categoryService.getById(rs.getInt("CategoryId")),supplierService.getById(rs.getInt("SupplierId")));
				productList.add(product);
			}
			con.close();

		} catch (Exception e) {

		}
		return productList;
	}
	
	public Product getById(int productId){
		Product product=null;
		try{
			con=connectdb.getConn();
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM Products WHERE ProductId=?");
			stmt.setInt(1,productId);
			
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				product = new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getInt("Stock"),rs.getDouble("BuyingPrice"),rs.getDouble("SellingPrice"),rs.getString("Picture"),categoryService.getById(rs.getInt("CategoryId")),supplierService.getById(rs.getInt("SupplierId")));
			}
			con.close();
		}catch(Exception e){
			
		}
		return product;
		
	}
	public Product getByName(String name) {
		Product product = null;
		try {
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Products WHERE ProductName=?");
			stmt.setString(1,name);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				product = new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getInt("Stock"),rs.getDouble("BuyingPrice"),rs.getDouble("SellingPrice"),rs.getString("Picture"),categoryService.getById(rs.getInt("CategoryId")),supplierService.getById(rs.getInt("SupplierId")));
			}
			con.close();

		} catch (Exception e) {
			//e.printStackTrace();
		}
		return product;
	}
}