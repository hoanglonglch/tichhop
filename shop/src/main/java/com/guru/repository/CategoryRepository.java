package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.model.Category;
import java.lang.String;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Category findByName(String name);
	
}
