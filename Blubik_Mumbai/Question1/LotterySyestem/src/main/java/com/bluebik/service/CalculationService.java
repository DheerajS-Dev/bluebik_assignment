package com.bluebik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
	
	@Autowired
    private WinnerService winnerService;
	
	public String storeLotteryNumbers() {
		
		int[] arr = {100,1000,10000,10000};
		
		String response = winnerService.storeLotteryNumbers(arr);
		return response;
		
	}
}
