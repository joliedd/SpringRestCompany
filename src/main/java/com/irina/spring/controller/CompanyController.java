package com.irina.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.irina.spring.model.Company;

/**
 * Handles requests for the Company service.
 */
@Controller
public class CompanyController {
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	//Map to store companies, ideally we should use database
	private static Map<Long, Company> compData = new HashMap<Long, Company>();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)	
	public ModelAndView goIndex () {
		return new ModelAndView ( "home" );
	}
	
	@RequestMapping(value = CompRestURIConstants.DUMMY_COMP, 
			 method = RequestMethod.GET)
	public @ResponseBody Company getDummyCompany() {
		logger.info("Start getDummyCompany");
		Company comp = new Company();
		comp.setId(9999);
		comp.setName("Dummy");
		comp.setAddress("str flowers");
		compData.put((long) 9999, comp);
		return comp;
	}
	
	@RequestMapping(value = CompRestURIConstants.GET_COMP,
			method = RequestMethod.GET)
	public @ResponseBody Company getCompany(@PathVariable("id") long compId) {
		logger.info("Start getCompany. ID="+compId);
		System.out.println("comps=" + compData);
		
		return compData.get(compId);
	}
	
	@RequestMapping(value = CompRestURIConstants.GET_ALL_COMP,
			 method = RequestMethod.GET)
	public @ResponseBody List<Company> getAllCompanies() {
		logger.info("Start getAllCompanies.");
		List<Company> comps = new ArrayList<Company>();
		Set<Long> compIdKeys = compData.keySet();
		for(Long i : compIdKeys){
			comps.add(compData.get(i));
		}
		return comps;
	}
	
	@RequestMapping(value = CompRestURIConstants.CREATE_COMP, method = RequestMethod.POST)
	public @ResponseBody Company createCompany(@RequestBody Company comp) {
		logger.info("Start createCompany.");
		System.out.println("company added" + comp);
		compData.put(comp.getId(), comp);
		return comp;
	}
	
	@RequestMapping(value = CompRestURIConstants.UPDATE_COMP,method = RequestMethod.PUT)
	public @ResponseBody Company updateCompany(@RequestBody Company comp) {
		logger.info("Start createCompany.");
		System.out.println("company updated" + comp);
		compData.put(comp.getId(), comp);
		return comp;
	}
	
	@RequestMapping(value = CompRestURIConstants.DELETE_COMP,
			method = RequestMethod.PUT)
	public @ResponseBody Company deleteCompany(@PathVariable("id") int compId) {
		logger.info("Start deleteCompany.");
		Company comp = compData.get(compId);
		compData.remove(compId);
		return comp;
	}
	
}
