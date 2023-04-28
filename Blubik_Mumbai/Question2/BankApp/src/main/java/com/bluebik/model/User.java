package com.bluebik.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class User {

    @Id
    @SequenceGenerator(name="user_generator", sequenceName = "user_generator", allocationSize=50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    private Integer userId;

    private String name;

    @ManyToMany
    private Set<Account> accounts;
    
    public User() {
    	
	}
    
	public User(Integer userId, String name, Set<Account> accounts) {
		super();
		this.userId = userId;
		this.name = name;
		this.accounts = accounts;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
}
