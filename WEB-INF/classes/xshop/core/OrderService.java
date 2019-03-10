package xshop.core;

import xshop.entity.*;
import xshop.data.*;
import java.util.List;

public class OrderService{
	OrderRepository repository;
		
	public OrderService(){
		repository=new OrderRepository();
	}
	
	public boolean add(Order order) {
		return repository.add(order);
	}
	public boolean addProduct(OrderedProduct orderedProduct) {
		return repository.addProduct(orderedProduct);
	}
	
	public List<Order> getAll() {
		return repository.getAll();
	}
	public List<OrderedProduct> getAllProduct(int orderId) {
		return repository.getAll();
	}
	public Order track(String phone) {
		return repository.track(phone);
	}
	
}
