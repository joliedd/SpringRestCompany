package com.irina.spring.model;
import java.util.List;


import java.io.Serializable;


public class Company implements Serializable{

	private static long serialVersionUID = 1L;
	
	//private static int counter = 1;
	
    private long id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String email;
    private String phone;
    private List<String> owners;
 
    
    
    
    
	public Company() {
		super();
		
	}


	public Company( long id, String name, String address, String city, String country, String email,
			String phone, List<String> owners) {
		super();
		this.id= id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.owners = owners;
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}


	
	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}


	
	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}


	
	public void setCity(String city) {
		this.city = city;
	}



	public String getCountry() {
		return country;
	}


	
	public void setCountry(String country) {
		this.country = country;
	}



	public String getEmail() {
		return email;
	}


	
	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}



	public List<String> getOwners() {
		return owners;
	}


	public void setOwners(List<String> owners) {
		this.owners = owners;
	}

	@Override
	   public boolean equals(Object object){
	      if(object == null){
	         return false;
	      }else if(!(object instanceof Company)){
	         return false;
	      }else {
	    	 Company company = (Company)object;
	         if(id == company.getId()
	            && name.equals(company.getName())
	            && address.equals(company.getAddress())
	         ){
	            return true;
	         }			
	      }
	      return false;
	   }


	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", country="
				+ country + ", email=" + email + ", phone=" + phone + ", owners=" + owners + "]";
	}	

	
  
}
