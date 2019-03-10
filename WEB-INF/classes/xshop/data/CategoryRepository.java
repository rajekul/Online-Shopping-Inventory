package xshop.data;

import xshop.entity.Category;
import xshop.config.Connectdb;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryRepository implements iCategoryRepository{
	
	private static CategoryRepository obj;
	Connectdb connectdb;
	Connection con;
		
	private CategoryRepository(){
		connectdb=new Connectdb();
	}
	
	public static CategoryRepository getObject(){
		if(obj==null){
			obj = new CategoryRepository();
		}
		return obj;
	}
	

	public boolean add(Category category) {
		try {
			
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Categories(CategoryName,Picture) VALUES(?,?)");
			stmt.setString(1, category.getName());
			stmt.setString(2, category.getPicture());
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

	public boolean edit(Category category) {
		try {
			
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("UPDATE Categories SET CategoryName=?,Picture=? WHERE CategoryId=?");
			stmt.setString(1, category.getName());
			stmt.setString(2, category.getPicture());
			stmt.setInt(3, category.getId());

			int result = stmt.executeUpdate();
			con.close();

			if (result != 0) {
				return true;
			}
			return false;

		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
	}

	public boolean remove(int categoryId) {
		try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM Categories  WHERE CategoryId=?");
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
		}
	}

	public List<Category> getAll() {
		List<Category> categoryList = new ArrayList<Category>();
		try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT  *  FROM Categories");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Category category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"),rs.getString("Picture"));
				categoryList.add(category);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return categoryList;
	}
	/*public List<Category> getAllWithProduct() {
		List<Category> categoryList = new ArrayList<Category>();
		try {

			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT Id, Name FROM Categories ORDER BY Id ASC");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				//Product
				Category category = new Category(rs.getInt("Id"), rs.getString("Name"));
				categoryList.add(category);
			}
			con.close();

		} catch (Exception e) {
			//e.printStackTrace();
		}
		return categoryList;
	}*/

	public Category getById(int categoryId) {
		Category category = null;
		try {
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Categories WHERE CategoryId=?");
			stmt.setInt(1,categoryId);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"),rs.getString("Picture"));
			}
			con.close();

		} catch (Exception e) {
			//e.printStackTrace();
		}
		return category;
	}
	public List<Category> search(String categoryName) {
		List<Category> categoryList = new ArrayList<Category>();
		try {
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Categories WHERE CategoryName LIKE ?");
			stmt.setString(1,"%"+categoryName+"%");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Category category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"),rs.getString("Picture"));
				categoryList.add(category);
			}
			con.close();

		} catch (Exception e) {
			//e.printStackTrace();
		}
		return categoryList;
	}
	
	public Category getByName(String name) {
		Category category = null;
		try {
			con=connectdb.getConn();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Categories WHERE CategoryName=?");
			stmt.setString(1,name);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"),rs.getString("Picture"));
			}
			con.close();

		} catch (Exception e) {
			//e.printStackTrace();
		}
		return category;
	}
}
