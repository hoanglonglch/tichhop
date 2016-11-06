package com.guru.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.model.New;

public interface NewRepository extends JpaRepository<New,Integer>{
	Page<New> findAll(Pageable pageable);
	Page<New> findByCategory_Id(int id,Pageable pageable);
}
