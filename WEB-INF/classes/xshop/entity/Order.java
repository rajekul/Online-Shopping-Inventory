package xshop.entity;

import java.util.List;
import java.util.ArrayList;

public  class Order{
    int id;
    string date;
    String name;
    String contact;
    String address;
     int totalbill;
	String status;
	public Order(Stringd date,String name,String contact,String address,int totalbill) {
		this.id = 0;
		this.date=date
		this.name = name;
		this.contact = contact;
		this.address=address;
		this.totalbill=totalbill;
		this.status="Inprogress";
	}
    
	public Order(int id,Stringd date,String name,String contact,String address,int totalbill) {
		this.id = id;
		this.date=date
		this.name = name;
		this.contact = contact;
		this.address=address;
		this.totalbill=totalbill;
	}
    
	
	public int getId() {
		return id;
	}
	public String getDate(){
		
	}
	public String getName() {
		return name;
	}
	public String getContact() {
		return contact;
	}
	public String getAddress() {
		return address;
	}
	public int getTotalbill(){
		return totalbill;
	
	}
}