package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.model.New;

public interface NewRepository extends JpaRepository<New,Integer>{
	
}
