package com.vmforce.demo;

import javax.servlet.http.HttpSession;

import com.vmforce.demo.cart.Item;
import com.vmforce.demo.cart.ItemSet;
import com.vmforce.demo.cart.ShoppingCart;
import com.vmforce.demo.sobject.Contact;
import com.vmforce.demo.sobject.Product2;
import com.vmforce.demo.utils.WebConstants;

public class SessionManager {
	/******************************************************************
	 * Setting 
	 ******************************************************************/	
	static public String getSettingId(HttpSession session) {
		return (String) session.getAttribute(WebConstants.SETTINGID);
	}
	static public void setSettingId(HttpSession session, String id) {
		session.setAttribute(WebConstants.SETTINGID, id);
	}	

	/******************************************************************
	 * ShoppingCart
	 ******************************************************************/
	static public boolean hasItemInShoppingCart(HttpSession session) {
		ShoppingCart cart = getShoppingCart(session);
		return (cart == null || cart.isEmpty()) ? false : true;
	}

	static public ShoppingCart getShoppingCart(HttpSession session) {
		return (ShoppingCart) session.getAttribute(WebConstants.CARTKEY);
	}

	static public void clearShoppingCart(HttpSession session) {
		ShoppingCart cart = (ShoppingCart) session
				.getAttribute(WebConstants.CARTKEY);
		if (cart == null) {
			return;
		}
		session.setAttribute(WebConstants.CARTKEY, null);
	}

	public static ShoppingCart addItem2ShoppingCart(Product2 prod, Integer qty,
			HttpSession session) {
		ShoppingCart cart = getShoppingCart(session);
		if (cart == null) {
			cart = new ShoppingCart();
			session.setAttribute(WebConstants.CARTKEY, cart);
		}

		Item item = new Item();
		item.setItemId(prod.getId());
		item.setItemName(prod.getName());
		item.setPrice(prod.getPrice());
		item.setPictureUrl(prod.getImgsmall());

		ItemSet is = new ItemSet(item, qty);
		cart.push(is);
		return cart;
	}
	
	

	/******************************************************************
	 * User
	 ******************************************************************/
	
	static public boolean hasUser(HttpSession session) {
		LoginUser user = getUser(session);
		return user == null ? false : true;
	}

	static public void deleteUser(HttpSession session) {
		LoginUser user = (LoginUser) session.getAttribute(WebConstants.USERKEY);
		if (user == null) {
			return;
		}
		session.setAttribute(WebConstants.USERKEY, null);
	}

	static public LoginUser getUser(HttpSession session) {
		return (LoginUser) session.getAttribute(WebConstants.USERKEY);
	}

	static public void setUser(HttpSession session, LoginUser user) {
		session.removeAttribute(WebConstants.USERKEY);
		session.setAttribute(WebConstants.USERKEY, user);
	}
	
	
	/*
	static public boolean hasUser(HttpSession session) {
		Contact user = getUser(session);
		return user == null ? false : true;
	}

	static public void deleteUser(HttpSession session) {
		Contact user = (Contact) session.getAttribute(WebConstants.USERKEY);
		if (user == null) {
			return;
		}
		session.setAttribute(WebConstants.USERKEY, null);
	}

	static public Contact getUser(HttpSession session) {
		return (Contact) session.getAttribute(WebConstants.USERKEY);
	}

	static public void setUser(HttpSession session, Contact contact) {
		session.removeAttribute(WebConstants.USERKEY);
		session.setAttribute(WebConstants.USERKEY, contact);
	}
	
	*/

}
