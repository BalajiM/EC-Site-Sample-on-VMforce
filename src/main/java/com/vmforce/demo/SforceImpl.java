package com.vmforce.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.vmforce.demo.sobject.Case;
import com.vmforce.demo.sobject.Contact;
import com.vmforce.demo.sobject.Ecsetting;
import com.vmforce.demo.sobject.Information;
import com.vmforce.demo.sobject.Order;
import com.vmforce.demo.sobject.OrderItem;
import com.vmforce.demo.sobject.Product2;

@Component("sforce")
public class SforceImpl implements Sforce {

	private static final Logger logger = LoggerFactory.getLogger(SforceImpl.class);

	@PersistenceContext
	EntityManager em;

	/*
	 * @SuppressWarnings("unchecked") public List<Product2> getProductList() {
	 * return em.createQuery(
	 * "SELECT p FROM Product2 p Where p.isActive = true") .getResultList(); }
	 */
	@SuppressWarnings("unchecked")
	public List<Product2> getProductList(HttpSession session) {
		String id = SessionManager.getSettingId(session);
		String query = "SELECT p FROM Product2 p Where p.ecsettingid='" + id + "' and p.isActive = true" ;
		return em.createQuery(query).getResultList();
	}

	/******************************************************************
	 * ec_setting__c
	 ******************************************************************/
	@SuppressWarnings("unchecked")
	public Ecsetting getSetting(HttpSession session) {
		try {
			final String id = SessionManager.getSettingId(session);
			return em.find(Ecsetting.class, id);
		} catch (Exception e) {
		}
		List<Ecsetting> result = em.createQuery("SELECT p FROM Ecsetting p where p.isvalid = true").getResultList();
		SessionManager.setSettingId(session, result.get(0).getId());
		return result.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Ecsetting> getSettingList() {
		return em.createQuery("SELECT p FROM Ecsetting p where p.isvalid = true").getResultList();
	}

	/******************************************************************
	 * Information__c
	 ******************************************************************/
	@SuppressWarnings("unchecked")
	public List<Information> getInformationList(HttpSession session) {
		// return em.createQuery("SELECT p FROM Information p").getResultList();
		String id = SessionManager.getSettingId(session);
		String query = "SELECT p FROM Information p Where p.ecsettingid='" + id + "'";
		return em.createQuery(query).getResultList();
	}

	/******************************************************************
	 * Product2
	 ******************************************************************/
	public Product2 getProduct(String id) {
		return em.find(Product2.class, id);
	}

	/******************************************************************
	 * Contact
	 ******************************************************************/
	public void createUser(Contact contact) {
		em.persist(contact);
	}

	public String getUserId(String email, String password) {
		String jpql = "SELECT c FROM Contact c Where c.email = '" + email + "' and c.password = '" + password + "'";

		List<Contact> result = em.createQuery(jpql, Contact.class).getResultList();

		return result.size() == 0 ? null : result.get(0).getId();
	}
	
	public Contact getUser(String id) {
		return em.find(Contact.class, id);
	}

	public boolean isExist(String email, String password) {
		return getUserId(email, password) == null ? false : true;

	}

	/******************************************************************
	 * Case
	 ******************************************************************/
	public void createCase(Case cace) {
		em.persist(cace);
	}

	/******************************************************************
	 * Order__c
	 ******************************************************************/
	public void createOrder(Order order) {
		em.persist(order);
	}
	
	/******************************************************************
	 * OrderItem__c
	 ******************************************************************/
	public void createOrderItems(List<OrderItem> items) {	
		if (items.isEmpty())
			return;

		for (OrderItem item: items) {
			em.persist(item);
		}
	}
}
