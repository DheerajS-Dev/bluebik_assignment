package com.bluebik.model;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Account {

    @Id
    @SequenceGenerator(name="account_generator", sequenceName = "account_generator", allocationSize=50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_generator")
    private Integer accountId;

    private BigDecimal balance;

    @ManyToMany(mappedBy = "accounts")
    private Set<User> users;
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions;
    
    public Account() {
    	
	}
    
    public Account(Integer accountId, BigDecimal balance, Set<User> users, Set<Transaction> transactions) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.users = users;
		this.transactions = transactions;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
}
