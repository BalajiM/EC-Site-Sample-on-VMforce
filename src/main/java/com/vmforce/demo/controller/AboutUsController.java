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


/**
 * Handles requests for the application Company page.
 */
@Controller
public class AboutUsController {

	private static final Logger logger = LoggerFactory.getLogger(AboutUsController.class);
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	@Qualifier("sforce")
	private Sforce sforce;

	// show company page
	@RequestMapping(value="/aboutus.html", method=RequestMethod.GET)
	public ModelAndView show(HttpSession session, ModelAndView mv) { 
		mv.addObject("infos", sforce.getInformationList(session));
		mv.addObject("setting", sforce.getSetting(session));
		mv.setViewName("aboutus");
		return mv;
	}
}


