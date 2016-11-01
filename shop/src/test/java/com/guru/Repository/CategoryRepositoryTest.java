package com.guru.Repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.guru.model.Category;
import com.guru.repository.CategoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class CategoryRepositoryTest {

	@Autowired
	CategoryRepository repositoryCate;
	
	@Before
	public void init(){
		
	}

	@Test
	public void testFindByName(){
		List<Category> categories = repositoryCate.findAll();
		int result = categories.size();
		 assertEquals(3, result);
	}
}
