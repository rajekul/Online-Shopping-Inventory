package xshop.data;

public class DataRepository{
	
	public Repository Create(String name){
		if(name.equals("Category")){
			return CategoryRepository.getObject();
		}
		else if(name.equals("User")){
			return UserRepository.getObject();
		}
		else if(name.equals("Supplier")){
			return SupplierRepository.getObject();
		}
		else if(name.equals("Product")){
			return ProductRepository.getObject();
		}
		else{
			return null;
		}
	}
	public iProductRepository product(){
		
		return ProductRepository.getObject();
	}
}
