package xshop.core;


import xshop.entity.Supplier;
import xshop.data.*;
import java.util.List;

public class SupplierService implements iSupplierService{
	Repository<Supplier> repository;
	private static SupplierService obj;
		
	private SupplierService(){
		DataRepository data=new DataRepository();
		repository = data.Create("Supplier");
	}
	
	public static SupplierService getObject(){
		if(obj==null){
			obj = new SupplierService();
		}
		return obj;
	}
	public boolean add(Supplier supplier){
		return repository.add(supplier);
	}
	public boolean edit(Supplier supplier){
		return repository.edit(supplier);
	}
	public boolean remove(int supplierId){
		return repository.remove(supplierId);
	}
	public List<Supplier> getAll(){
		return repository.getAll();
	}
	public List<Supplier>  search(String sup){
		return repository.search(sup);
	}  
	
	public Supplier getById(int supplierId){
		return repository.getById(supplierId);
	}
	
	public Supplier getByName(String name){
		return repository.getByName(name);
	}
	
}