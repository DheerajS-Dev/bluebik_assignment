package com.bluebik.service;

import java.math.BigDecimal;

public interface TransactionService {
	
	public String credit(Integer userId, Integer accountId, BigDecimal amount) ;

    public String debit(Integer userId, Integer accountId, BigDecimal amount) ;
    
}
