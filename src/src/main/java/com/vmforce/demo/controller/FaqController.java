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

import com.vmforce.demo.Sforce;
import com.vmforce.demo.sobject.Case;


/**
 * Handles requests for the application Contact us page.
 */
@Controller
public class FaqController {

	private static final Logger logger = LoggerFactory.getLogger(FaqController.class);
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	@Qualifier("sforce")
	private Sforce sforce;

	// show contact us page
	@RequestMapping(value="/faq.html", method=RequestMethod.GET)
	public ModelAndView show(HttpSession session, ModelAndView mv) { 
		mv.setViewName("faq");
		mv.addObject("setting", sforce.getSetting(session));
		return mv;
	}
	
	// save inquiry as case via JPA
	@RequestMapping(value="/savefaq.html", method=RequestMethod.POST)
	public String save(Case cace) { 
		sforce.createCase(cace);
		return "thank";
	}	
	
	@ModelAttribute
	public Case setUpForm() {
		Case cace = new Case();
		cace.setStatus("New");
		cace.setOrigin("Web");
		return cace;
	}	
}


