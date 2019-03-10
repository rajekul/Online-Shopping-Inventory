package xshop.core;

import xshop.entity.Supplier;
import java.lang.Object;
import java.util.List;


public interface iSupplierService extends Service<Supplier>{

	public boolean add(Supplier supplier);

	public boolean edit(Supplier supplier);

	public boolean remove(int Id);

	public List<Supplier> getAll();
	
	public Supplier getById(int Id);
	
	public List<Supplier> search(String str);
	
	public Supplier getByName(String name);
}
