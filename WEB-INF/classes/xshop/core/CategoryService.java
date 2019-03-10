package xshop.core;

import xshop.entity.Category;
import xshop.data.*;
import java.util.List;

public class CategoryService implements iCategoryService{
	Repository<Category> repository;
	private static CategoryService obj;
		
	private CategoryService(){
		DataRepository data=new DataRepository();
		repository = data.Create("Category");
	}
	
	public static CategoryService getObject(){
		if(obj==null){
			obj = new CategoryService();
		}
		return obj;
	}
	
	public boolean add(Category category){
		return repository.add(category);
	}
    
	public boolean edit(Category category){
		return repository.edit(category);
	}
    
	public boolean remove(int categoryId){
		return repository.remove(categoryId);
	}
    
	public List<Category> getAll(){
		return repository.getAll();
	}
	public List<Category> search(String categoryName){
		return repository.search(categoryName);
	}   
    
	public Category getById(int categoryId){
		return repository.getById(categoryId);
	}
	
	public Category getByName(String name){
		return repository.getByName(name);
	}
}