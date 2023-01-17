package com.myresto.domaine;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@EnableAutoConfiguration
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private boolean gerant;
	private String password;
	private String address;
	
	
	public User(Long id, String name, boolean gerant, String password, String address) {
		super();
		this.id = id;
		this.name = name;
		this.gerant = gerant;
		this.password = password;
		this.address = address;
	}

	
	//Getters
	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public boolean isGerant() {
		return gerant;
	}


	public String getPassword() {
		return password;
	}


	public String getAddress() {
		return address;
	}
	
	
	//Setters
	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setGerant(boolean gerant) {
		this.gerant = gerant;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	

	
	
	
	
}
