package xshop.core;

import xshop.entity.Category;
import java.lang.Object;
import java.util.List;


public interface iCategoryService extends Service<Category>{

	public boolean add(Category category);

	public boolean edit(Category category);

	public boolean remove(int Id);

	public List<Category> getAll();
	
	public Category getById(int Id);
	
	public List<Category> search(String str);
	
	public Category getByName(String name);
}
