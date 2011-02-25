package com.vmforce.demo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vmforce.demo.LoginUser;
import com.vmforce.demo.SessionManager;
import com.vmforce.demo.Sforce;
import com.vmforce.demo.sobject.Contact;

/**
 * Handles requests for the application user related pages
 */
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@PersistenceContext
	EntityManager em;

	@Autowired
	@Qualifier("sforce")
	private Sforce sforce;

	@ModelAttribute
	public Contact setUpForm() {
		Contact contact = new Contact();
		return contact;
	}	
	
	/******************************************************************
	 * User Login
	 ******************************************************************/

	// show login page
	@RequestMapping(value = "/user/login.html", method = RequestMethod.GET)
	public ModelAndView showLoginPage(HttpSession session, ModelAndView mv) {
		mv.addObject("setting", sforce.getSetting(session));
		mv.setViewName("/signin/login");
		return mv;
	}

	// check if user have already registered with email and password via JPA
	@RequestMapping(value = "/user/check.html", method = RequestMethod.POST)
	public ModelAndView checkLoginCredential(HttpSession session, Contact user) {
		ModelAndView mv;

		if (sforce.isExist(user.getEmail(), user.getPassword())) {
			String uid = sforce.getUserId(user.getEmail(), user.getPassword());
			SessionManager.setUser(session, new LoginUser(uid));
			mv = new ModelAndView("home"); // forward home page 
			mv.addObject("infos", sforce.getInformationList(session));
			mv.addObject("setting", sforce.getSetting(session));
			return mv;
		}

		mv = new ModelAndView("/signin/login"); // forward login page again because of login failure
		mv.addObject("setting", sforce.getSetting(session));
		mv.addObject(
				"message",
				"The e-mail address and password you entered do not match any accounts on record.");
		return mv;
	}	

	/******************************************************************
	 * User Registration
	 ******************************************************************/
	
	// show user registration page
	@RequestMapping(value = "/user/register.html", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpSession session, ModelAndView mv) {
		mv.setViewName("/signup/registration");
		mv.addObject("setting", sforce.getSetting(session));
		return mv;
	}

	// create customer via JPA 
	@RequestMapping(value = "/user/submit.html", method = RequestMethod.POST)
	public ModelAndView submitRegister(HttpSession session, ModelAndView mv, Contact user) {
		sforce.createUser(user);
		mv.addObject("setting", sforce.getSetting(session));
		mv.setViewName("/signin/login");
		return mv;		
	}

	// press confirm button to order products without login before, then customer need to login at first. 
	// this method checks user's credential. if ok, then forward to order confirmation page
	@RequestMapping(value = "/user/checkAndBackToConfirm.html", method = RequestMethod.POST)
	public ModelAndView checkLoginAndBackToConfirm(HttpSession session,
			Contact user) {

		ModelAndView mv;
		if (sforce.isExist(user.getEmail(), user.getPassword())) {
			mv = new ModelAndView("/cart/confirmcart");
			String uid = sforce.getUserId(user.getEmail(), user.getPassword());
			SessionManager.setUser(session, new LoginUser(uid));
			mv.addObject("cart", SessionManager.getShoppingCart(session));
			mv.addObject("setting", sforce.getSetting(session));
			return mv;
		}

		mv = new ModelAndView("/signin/login_from_confirm");
		mv.addObject("setting", sforce.getSetting(session));
		mv.addObject(
				"message",
				"The e-mail address and password you entered do not match any accounts on record.");
		return mv;
	}

}
