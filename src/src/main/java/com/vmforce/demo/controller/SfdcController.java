package com.vmforce.demo.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import com.vmforce.demo.SessionManager;
import com.vmforce.demo.Sforce;
import com.vmforce.demo.sobject.Contact;
import com.vmforce.demo.sobject.Ecsetting;

/**
 * Handles requests for the application Company page.
 */
@Controller
public class SfdcController {

	private static final Logger logger = LoggerFactory.getLogger(SfdcController.class);

	@PersistenceContext
	EntityManager em;

	@Autowired
	@Qualifier("sforce")
	private Sforce sforce;

	@ModelAttribute
	public Param setUpForm() {
		return new Param();
	}

	// show company page
	@RequestMapping(value = "/sfdc.html", method = RequestMethod.GET)
	public ModelAndView show(ModelAndView mv) {
		mv.addObject("settings", sforce.getSettingList());
		mv.setViewName("sfdc");
		return mv;
	}

	// show company page
	@RequestMapping(value = "/sfdc.html", method = RequestMethod.POST)
	public ModelAndView goHome(HttpSession session, ModelAndView mv, Param param) {
		String id = param.getSettingid();
		SessionManager.setSettingId(session, id);

		mv.addObject("infos", sforce.getInformationList(session));
		mv.addObject("setting", sforce.getSetting(session));
		mv.setViewName("home");
		return mv;
	}
	

	public class Param {

		private String settingid;

		public void setSettingid(String settingid) {
			this.settingid = settingid;
		}

		public String getSettingid() {
			return settingid;
		}
	}
}
