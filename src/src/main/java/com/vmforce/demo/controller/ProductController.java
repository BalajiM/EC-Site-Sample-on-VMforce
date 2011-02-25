package com.vmforce.demo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vmforce.demo.Sforce;
import com.vmforce.demo.sobject.Product2;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@PersistenceContext
	EntityManager em;

	@Autowired
	@Qualifier("sforce")
	private Sforce sforce;

	// show product detail page
	@RequestMapping(value = "/productdetail.html", method = RequestMethod.GET)
	public ModelAndView detail(String pid, HttpSession session) {
		Product2 product = sforce.getProduct(pid);
		ModelAndView mv = new ModelAndView("/product/productdetail");
		mv.addObject("product", product);
		mv.addObject("setting", sforce.getSetting(session));
		return mv;
	}

	// show product list page
	@RequestMapping(value = "/productlist.html", method = RequestMethod.GET)
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		mv.addObject("products", sforce.getProductList(session));
		mv.addObject("setting", sforce.getSetting(session));
		mv.setViewName("/product/productlist");
		return mv;
	}
}
