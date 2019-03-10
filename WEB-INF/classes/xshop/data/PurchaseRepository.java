package xshop.data;

import xshop.entity.*;
import xshop.core.*;
import xshop.config.Connectdb;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PurchaseRepository{
	
	
	Connectdb connectdb;
	Connection con;
	Service<Product> service;	
	public PurchaseRepository(){
		service=new DataService().Create("Product");
		connectdb=new Connectdb();
	}
	
	public boolean add(Purchase purchase) {
		try {
			
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Purchases(Date,Quantity,BuyingPrice,ProductId) VALUES(?,?,?,?)");
			stmt.setString(1, purchase.getDate());
			stmt.setInt(2, purchase.getQuantity());
			stmt.setDouble(3, purchase.getBuyingPrice());
			stmt.setInt(4, purchase.getProduct().getId());
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

	
	public List<Purchase> getAll() {
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT  *  FROM Purchases");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Purchase purchase = new Purchase(rs.getInt("PurchaseId"), rs.getString("Date"),rs.getInt("Quantity"),rs.getDouble("BuyingPrice"),service.getById(rs.getInt("ProductId")));
				purchaseList .add(purchase);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return purchaseList ;
	}
	
	public List<Purchase> search(String date) {
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT  *  FROM Purchases where Date Like ?");
			stmt.setString(1,"%"+date+"%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Purchase purchase = new Purchase(rs.getInt("PurchaseId"), rs.getString("Date"),rs.getInt("Quantity"),rs.getDouble("BuyingPrice"),service.getById(rs.getInt("ProductId")));
				purchaseList .add(purchase);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return purchaseList ;
	}
	
}
