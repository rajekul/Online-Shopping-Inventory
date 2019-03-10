package xshop.core;

import xshop.entity.User;
import java.lang.Object;
import java.util.List;


public interface iUserService extends Service<User>{

	public boolean add(User user);

	public boolean edit(User user);

	public boolean remove(int Id);

	public List<User> getAll();
	
	public User getById(int Id);
	
	public List<User> search(String str);
	
	public User getByName(String username);
}
