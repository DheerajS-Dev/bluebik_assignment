package com.bluebik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebik.service.CalculationService;
import com.bluebik.service.WinnerService;

@RestController
@RequestMapping("/winner")
public class WinnerController {

   @Autowired
   private WinnerService winnerService;
   
   @Autowired
   CalculationService calculationService;

   @GetMapping("/checkNumber/{num}")
   public boolean checkNumber(@PathVariable("num") int num) {
	   
       return winnerService.checkNumber(num);
   }
}
