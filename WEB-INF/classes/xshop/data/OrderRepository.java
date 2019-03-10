package xshop.data;

import xshop.entity.*;
import xshop.config.Connectdb;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderRepository{
	Connectdb connectdb;
	Connection con;
		
	public OrderRepository(){
		connectdb=new Connectdb();
	}
	
	public boolean add(Order order) {
		
		try {
			
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO orders(date,name,contact,address,bill) VALUES(?,?,?,?,?)");
			stmt.setString(1, order.getDate());
			stmt.setString(2, order.getName());
			stmt.setString(3, order.getContact());
			stmt.setString(4, order.getAddress());
			stmt.setInt(5, order.getTotalbill());
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
	public boolean addProduct(OrderedProduct orderedProduct) {
		try {
			
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO orderedProducts(productId,quantity,orderId) VALUES(?,?,?)");
			
			stmt.setInt(1, orderedProduct.getProductid());
			stmt.setInt(2, orderedProduct.getQuantity());
			stmt.setInt(3, orderedProduct.getOrderid());
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
	
	public List<Order> getAll() {
		List<Order> OrderList = new ArrayList<Order>();
		try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT  *  FROM Orders");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Order order= new Order(rs.getInt("Id"), rs.getString("Name"),rs.getString("Contact"),rs.getString("Address"),rs.getInt("bill"));
				OrderList.add(order);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return OrderList;
	}
	public List<OrderedProduct> getAllProduct(int orderId) {
		return repository.getAll();
	}
	public Order track(String phone) {
		Order order=null;
		try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT  *  FROM Orders where contact=?");
			stmt.setString(3, order.getContact());
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				order= new Order(rs.getInt("Id"), rs.getString("Name"),rs.getString("Contact"),rs.getString("Address"),rs.getInt("bill"));
				
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
}
