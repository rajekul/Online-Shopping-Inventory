package xshop.core;

import xshop.entity.Product;
import java.lang.Object;
import java.util.List;


public interface iProductService extends Service<Product>{

	public boolean add(Product product);

	public boolean edit(Product product);

	public boolean remove(int Id);

	public List<Product> getAll();
	
	public Product getById(int Id);
	
	public List<Product> search(String str);
	
	public Product getByName(String name);
	
	public List<Product> getByCategory(int categoryId);
	
	public List<Product> getBySupplier(int supplierId);
}
