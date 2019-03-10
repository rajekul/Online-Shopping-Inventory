package xshop.core;

import xshop.entity.*;
import xshop.data.*;
import java.util.List;

public class PurchaseService{
	PurchaseRepository repository;
		
	public PurchaseService(){
		repository=new PurchaseRepository();
	}
	
	public boolean add(Purchase purchase) {
		return repository.add(purchase);
	}

	
	public List<Purchase> getAll() {
		return repository.getAll();
	}
	
	public List<Purchase> search(String date) {
		return repository.search(date);
	}
	
}
