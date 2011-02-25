package com.vmforce.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vmforce.demo.SessionManager;
import com.vmforce.demo.Sforce;
import com.vmforce.demo.cart.ItemSet;
import com.vmforce.demo.cart.ShoppingCart;
import com.vmforce.demo.sobject.Contact;
import com.vmforce.demo.sobject.Ecsetting;
import com.vmforce.demo.sobject.Order;
import com.vmforce.demo.sobject.OrderItem;
import com.vmforce.demo.sobject.Product2;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ShoppingCartController {

	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

	@PersistenceContext
	EntityManager em;

	@Autowired
	@Qualifier("sforce")
	private Sforce sforce;

	@ModelAttribute
	public Contact setUpForm() {
		return new Contact();
	}

	// show shopping cart
	@RequestMapping(value = "/shoppingcart/show", method = RequestMethod.GET)
	public ModelAndView showCart(Integer qty, String pid, HttpSession session) {
		ModelAndView mv;
		if (!SessionManager.hasItemInShoppingCart(session)) {
			mv = new ModelAndView("/cart/emptycart");
			mv.addObject("setting", sforce.getSetting(session));
			return mv;
		}
		mv = new ModelAndView("/cart/showcart");
		mv.addObject("setting", sforce.getSetting(session));
		mv.addObject("cart", SessionManager.getShoppingCart(session));
		return mv;
	}

	// add product/s to shopping cart
	@RequestMapping(value = "/shoppingcart/add", method = RequestMethod.POST)
	public ModelAndView addProduct(Integer qty, String pid, HttpSession session) {
		ShoppingCart cart = SessionManager.addItem2ShoppingCart(sforce.getProduct(pid), qty, session);
		ModelAndView mv = new ModelAndView("/cart/showcart");
		mv.addObject("setting", sforce.getSetting(session));
		mv.addObject("cart", cart);
		return mv;
	}

	// press order confirmation button
	@RequestMapping(value = "/shoppingcart/confirm", method = RequestMethod.GET)
	public ModelAndView confirmOrder(Integer qty, String pid, HttpSession session) {
		ModelAndView mv;

		if (!SessionManager.hasUser(session)) {
			mv = new ModelAndView("/signin/login_from_confirm");
			mv.addObject("setting", sforce.getSetting(session));
			mv.addObject("message", "Please sign in at first");
			return mv;
		}

		ShoppingCart cart = SessionManager.getShoppingCart(session);
		if (cart.isEmpty()) {
			return new ModelAndView("/cart/emptycart");
		}

		mv = new ModelAndView("/cart/confirmcart");
		mv.addObject("setting", sforce.getSetting(session));
		mv.addObject("cart", cart);
		return mv;
	}

	// click delete link to delete a product
	@RequestMapping(value = "/shoppingcart/delete", method = RequestMethod.GET)
	public ModelAndView deleteProduct(String pid, HttpSession session) {
		ModelAndView mv;
		ShoppingCart cart = SessionManager.getShoppingCart(session);
		cart.delete(pid);

		if (cart.isEmpty()) {
			mv = new ModelAndView("/cart/emptycart");
			mv.addObject("setting", sforce.getSetting(session));
			return mv;
		}

		mv = new ModelAndView("/cart/showcart");
		mv.addObject("setting", sforce.getSetting(session));
		mv.addObject("cart", cart);
		return mv;
	}

	// show thank you page
	@RequestMapping(value = "/shoppingcart/thank", method = RequestMethod.GET)
	public ModelAndView sendOrder(Integer qty, String pid, HttpSession session) {
		ShoppingCart cart = SessionManager.getShoppingCart(session);
		Contact contact = sforce.getUser(SessionManager.getUser(session).getId());
		
		Ecsetting setting = sforce.getSetting(session);

		Order order = new Order();
		order.setContact(contact);
		order.setLang(setting.getLang());
		order.setTotal(cart.getTotal());
		sforce.createOrder(order);

		List<OrderItem> items = new ArrayList<OrderItem>();
		for (ItemSet row : cart.getItemList()) {

			OrderItem item = new OrderItem();
			item.setOrder(order);
			item.setQty(row.getQuantity());
			item.setPrice(row.getItem().getPrice());
			item.setTotal(row.getTotal());
			Product2 prod = sforce.getProduct(row.getItem().getItemId());
			item.setProduct2(prod);
			items.add(item);
		}

		sforce.createOrderItems(items);
		SessionManager.clearShoppingCart(session);

		ModelAndView mv = new ModelAndView("/cart/thank");
		mv.addObject("user", SessionManager.getUser(session));
		mv.addObject("setting", sforce.getSetting(session));
		return mv;
	}
}
