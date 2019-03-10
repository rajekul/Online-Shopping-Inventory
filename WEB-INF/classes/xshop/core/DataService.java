package xshop.core;


public class DataService{
	
	public Service Create(String name){
		if(name.equals("Category")){
			return CategoryService.getObject();
		}
		else if(name.equals("User")){
			return UserService.getObject();
		}
		else if(name.equals("Supplier")){
			return SupplierService.getObject();
		}
		else if(name.equals("Product")){
			return ProductService.getObject();
		}
		else{
			return null;
		}
	}
	public iProductService product(){
		
		return ProductService.getObject();
	}
}
