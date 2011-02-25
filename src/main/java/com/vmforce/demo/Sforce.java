package com.vmforce.demo;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.vmforce.demo.sobject.Case;
import com.vmforce.demo.sobject.Contact;
import com.vmforce.demo.sobject.Ecsetting;
import com.vmforce.demo.sobject.Information;
import com.vmforce.demo.sobject.Order;
import com.vmforce.demo.sobject.OrderItem;
import com.vmforce.demo.sobject.Product2;

public interface Sforce {
	
	// Information__c
	public List<Information> getInformationList(HttpSession session);
	
	// Ecsetting__c
	public Ecsetting getSetting(HttpSession session);
	public List<Ecsetting> getSettingList();
	
	// Product2
	public List<Product2> getProductList(HttpSession session);
	public Product2 getProduct(String id);
	
	// Contact
	public void createUser(Contact contact);
	public String getUserId(String email, String password);
	public Contact getUser(String id);
	public boolean isExist(String email, String password);
	
	// Case
	public void createCase(Case cace);	

	// Order__c
	public void createOrder(Order order);
	
	// OrderItem__c
	public void createOrderItems(List<OrderItem> items);
}
