package xshop.core;


import xshop.entity.Product;
import xshop.data.*;
import java.util.List;

public class ProductService implements iProductService{
	Repository<Product> repository;
	private static ProductService obj;
		
	private ProductService(){
		DataRepository data=new DataRepository();
		repository = data.Create("Product");
	}
	
	public static ProductService getObject(){
		if(obj==null){
			obj = new ProductService();
		}
		return obj;
	}
	public boolean add(Product product){
		return repository.add(product);
	}
	public boolean edit(Product product){
		return repository.edit(product);
	}
	public boolean remove(int productId){
		return repository.remove(productId);
	}
	public List<Product> getAll(){
		return repository.getAll();
	}  
	public List<Product> search(String productName){
		return repository.search(productName);
	} 
	public List<Product> getByCategory(int categoryId){
		iProductRepository productRepository=new DataRepository().product();
		return productRepository.getByCategory(categoryId);
	}
	public List<Product> getBySupplier(int supplierId){
		iProductRepository productRepository=new DataRepository().product();
		return productRepository.getBySupplier(supplierId);
	}
	public Product getById(int productId){
		return repository.getById(productId);
	}
	public Product getByName(String name){
		return repository.getByName(name);
	}
	
	
	
}