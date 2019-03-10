package xshop.core;


import xshop.entity.User;
import xshop.data.*;
import java.util.List;

public class UserService implements iUserService{
	Repository<User> repository;
	private static UserService obj;
		
	private UserService(){
		DataRepository data=new DataRepository();
		repository = data.Create("User");
	}
	
	public static UserService getObject(){
		if(obj==null){
			obj = new UserService();
		}
		return obj;
	}
	public boolean add(User user){
		return repository.add(user);
	}
	public boolean edit(User user){
		return repository.edit(user);
	}
	public boolean remove(int Id){
		return repository.remove(Id);
	}
	public List<User> getAll(){
		return repository.getAll();
	}
	public List<User>  search(String str){
		return repository.search(str);
	}  
	
	public User getById(int Id){
		return repository.getById(Id);
	}
	public User getByName(String username){
		return repository.getByName(username);
	}
	
}