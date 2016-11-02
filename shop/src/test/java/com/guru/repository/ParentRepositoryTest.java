package com.guru.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.guru.model.ParentCate;

@RunWith(MockitoJUnitRunner.class)
public class ParentRepositoryTest {
	
//	ko su dung duoc
	@Autowired
	ParentCateRepository repositoryParent;
	
	@Test
	public void findAllTest(){
		List<ParentCate> parentCates=repositoryParent.findAll();
		int size = parentCates.size();
		assertTrue(size==4);
	}
}
