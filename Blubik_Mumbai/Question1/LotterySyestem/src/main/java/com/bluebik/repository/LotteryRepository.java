package com.bluebik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebik.model.Lottery;

public interface LotteryRepository extends JpaRepository<Lottery, Integer> {
	
}
