package com.guru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.model.Category;
import com.guru.model.ParentCate;

public interface ParentCateRepository extends JpaRepository<ParentCate, Integer> {
	ParentCate findByParentName(String name);
	ParentCate findById(int id);
}
