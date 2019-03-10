package xshop.data;

import xshop.entity.User;
import xshop.config.Connectdb;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserRepository implements iUserRepository{
	
	private static UserRepository obj;
	Connectdb connectdb;
	Connection con;
		
	private UserRepository(){
		connectdb=new Connectdb();
	}
	
	public static UserRepository getObject(){
		if(obj==null){
			obj = new UserRepository();
		}
		return obj;
	}
	

	public boolean add(User user) {
		/*try {
			
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Categories(Name,Picture) VALUES(?)");
			stmt.setString(1, User.getName());

			int result = stmt.executeUpdate();
			con.close();
            
			if (result != 0) {
			return true;
			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}*/
		return true;
	}

	public boolean edit(User user) {
		/*try {
			
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("UPDATE Categories SET Name=? WHERE Id=?");
			stmt.setString(1, category.getName());
			stmt.setInt(2, category.getId());

			int result = stmt.executeUpdate();
			con.close();

			if (result != 0) {
				return true;
			}
			return false;

		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}*/
		return true;
	}

	public boolean remove(int Id) {
		/*try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM Categories  WHERE Id=?");
			stmt.setInt(1, categoryId);

			int result = stmt.executeUpdate();
			con.close();

			if (result != 0) {
			return true;
			}
			return false;

		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}*/
		return true;
	}

	public List<User> getAll() {
		List<User> UserList = new ArrayList<User>();
		/*try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT Id, Name FROM Categories ORDER BY Id ASC");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Category category = new Category(rs.getInt("Id"), rs.getString("Name"),rs.getString("Picture"));
				categoryList.add(category);
			}
			con.close();

		} catch (Exception e) {
			//e.printStackTrace();
		}*/
		return UserList;
	}
	

	public User getById(int Id) {
		User user = null;
		/*try {
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT Id,Name FROM Categories WHERE id=?");
			stmt.setInt(1,categoryId);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				category = new Category(rs.getInt("Id"), rs.getString("Name"),rs.getString("Picture"));
			}
			con.close();

		} catch (Exception e) {
			//e.printStackTrace();
		}*/
		return user;
	}
	public List<User> search(String categoryName) {
		List<User> UserList = new ArrayList<User>();
		/*try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT Id, Name FROM Categories ORDER BY Id ASC");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Category category = new Category(rs.getInt("Id"), rs.getString("Name"),rs.getString("Picture"));
				categoryList.add(category);
			}
			con.close();

		} catch (Exception e) {
			//e.printStackTrace();
		}*/
		return UserList;
	}
	
	public User getByName(String username) {
		User user = null;
		try {
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Users WHERE Username=?");
			stmt.setString(1,username);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				user = new User(rs.getString("Username"), rs.getString("Password"),rs.getString("Type"),rs.getString("Status"));
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
