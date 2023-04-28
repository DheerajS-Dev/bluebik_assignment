package com.bluebik.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebik.model.Lottery;
import com.bluebik.repository.LotteryRepository;

@Service
public class WinnerService {

   @Autowired
   private LotteryRepository lotteryRepository;

   public String storeLotteryNumbers(int[] lotteryNumbers) {
	   String res;
	   
	   for(Integer i : lotteryNumbers) {
		   Lottery lottery = new Lottery(i);
	       lotteryRepository.save(lottery);
	   }
       
       res = " Winners has Stored...";
       return res;
   }

   public boolean checkNumber(int num) {
       Optional<Lottery> optionalLottery = lotteryRepository.findById(num);
       return optionalLottery.isPresent();
   }
   
}
