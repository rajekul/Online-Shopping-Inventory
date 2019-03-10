package xshop.data;

import java.lang.Object;
import java.util.List;


public interface Repository<Type>{

	public boolean add(Type type);

	public boolean edit(Type type);

	public boolean remove(int Id);

	public List<Type> getAll();
	
	public Type getById(int Id);
	
	public List<Type> search(String str);
	
	public Type getByName(String name);
}
