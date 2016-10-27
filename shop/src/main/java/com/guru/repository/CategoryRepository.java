package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
