package xshop.data;

import xshop.entity.Supplier;
import xshop.config.Connectdb;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class SupplierRepository  implements  iSupplierRepository{
	
	private static SupplierRepository obj;
	Connectdb connectdb;
	Connection con;
		
	private SupplierRepository(){
		connectdb=new Connectdb();
	}
	
	public static SupplierRepository getObject(){
		if(obj==null){
			obj = new SupplierRepository();
		}
		return obj;
	}
	
	public boolean add(Supplier supplier){
		try{
			
			con=connectdb.getConn();
			PreparedStatement stmt=con.prepareStatement("INSERT INTO Suppliers(Supplier,Contact) VALUES(?,?)");
			stmt.setString(1,supplier.getName());
			stmt.setString(2,supplier.getContact());
			
			int result= stmt.executeUpdate();
			con.close();
			
			if(result != 0){
				return true;
			}
			return false;
			
		}catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
	}
	
	public boolean edit(Supplier supplier){
		try{
			con=connectdb.getConn();
			PreparedStatement stmt=con.prepareStatement("UPDATE Suppliers SET Supplier=? , Contact=? WHERE SupplierId=?");
			stmt.setString(1,supplier.getName());
			stmt.setString(2,supplier.getContact());
			stmt.setInt(3,supplier.getId());
			
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
	public boolean remove(int supplierId){
		try{
			con=connectdb.getConn();
			PreparedStatement stmt=con.prepareStatement("DELETE FROM Suppliers WHERE SupplierId=?");
			stmt.setInt(1,supplierId);
			
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
	
	public List<Supplier> getAll(){
		List<Supplier> supplierList = new ArrayList<Supplier>();
		try{
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Suppliers");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Supplier supplier = new Supplier(rs.getInt("SupplierId"), rs.getString("Supplier"),rs.getString("Contact"));
				supplierList.add(supplier);
			}
			con.close();
		}catch(Exception e){
			
		}
		return supplierList;
		
	}
	
	public List<Supplier> search(String sup){
		List<Supplier> supplierList=new ArrayList<Supplier>();
		try{
			con=connectdb.getConn();
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM Suppliers WHERE (Supplier LIKE ? OR Contact LIKE ?)");
			stmt.setString(1,"%"+sup+"%");
			stmt.setString(2,"%"+sup+"%");
			
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				Supplier supplier = new Supplier(rs.getInt("SupplierId"), rs.getString("Supplier"),rs.getString("Contact"));
				supplierList.add(supplier);
			}
			con.close();
			
		}catch(Exception e){
			
		}
		return supplierList;
	}
	
	public Supplier getById(int supplierId) {
		Supplier supplier = null;
		try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Suppliers WHERE SupplierId=?");
			stmt.setInt(1,supplierId);
			ResultSet rs = stmt.executeQuery();

            
			if (rs.next()) {
				supplier = new Supplier(rs.getInt("SupplierId"), rs.getString("Supplier"),rs.getString("Contact"));
			}
			con.close();

		} catch (Exception e) {

		}
		return supplier;
	}
	
	public Supplier getByName(String name) {
		Supplier supplier = null;
		/*try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT Id,Name,Contact FROM Suppliers WHERE id=?");
			stmt.setInt(1,supplierId);
			ResultSet rs = stmt.executeQuery();

            
			if (rs.next()) {
				supplier = new Supplier(rs.getInt("Id"), rs.getString("Name"), rs.getString("Contact"));
			}
			con.close();

		} catch (Exception e) {

		}*/
		return supplier;
	}
	
}