package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.model.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{
	
}
