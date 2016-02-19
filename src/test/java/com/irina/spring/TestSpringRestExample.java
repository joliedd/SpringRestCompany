package com.irina.spring;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.irina.spring.controller.CompRestURIConstants;
import com.irina.spring.model.Company;

public class TestSpringRestExample {

	public static final String SERVER_URI = "http://localhost:9090/SpringRestCompany";
	
	public static void main(String args[]){
		
		testGetDummyCompany();
		System.out.println("*****");
		testCreateCompany();
		System.out.println("*****");
		testGetCompany();
		System.out.println("*****");
		testGetAllCompany();
	}

	private static void testGetAllCompany() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Company> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> comps = restTemplate.getForObject(SERVER_URI+CompRestURIConstants.GET_ALL_COMP, List.class);
		System.out.println(comps.size());
		for(LinkedHashMap map : comps){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",Address="+map.get("createdDate"));;
		
		}
	}

	private static void testCreateCompany() {
		RestTemplate restTemplate = new RestTemplate();
		Company comp = new Company();
		comp.setId(1);comp.setName("Irina Constantin");
		Company response = restTemplate.postForObject(SERVER_URI+CompRestURIConstants.CREATE_COMP, comp, Company.class);
		printCompData(response);
	}

	private static void testGetCompany() {
		RestTemplate restTemplate = new RestTemplate();
		Company comp = restTemplate.getForObject(SERVER_URI+"/rest/comp/1", Company.class);
		printCompData(comp);
	}

	private static void testGetDummyCompany() {
		RestTemplate restTemplate = new RestTemplate();
		Company comp = restTemplate.getForObject(SERVER_URI+CompRestURIConstants.DUMMY_COMP, Company.class);
		printCompData(comp);
	}
	
	public static void printCompData(Company comp){
		System.out.println("ID="+comp.getId()+",Name="+comp.getName()+",Address="+comp.getAddress());
	}
}
