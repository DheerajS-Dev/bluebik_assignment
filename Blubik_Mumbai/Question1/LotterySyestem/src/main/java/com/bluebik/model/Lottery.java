package com.bluebik.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Lottery {
   @Id
   private Integer number;
   private LocalDate localDate;

   public Lottery(Integer number) {
       this.number = number;
       this.localDate = LocalDate.now();
   }

   public Lottery() {}

   public Integer getNumber() {
       return number;
   }

   public void setNumber(Integer number) {
       this.number = number;
   }
   
   public LocalDate getLocalDateTime() {
	   return localDate;
   }
}
