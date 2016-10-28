package com.guru.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="parentcate")
public class ParentCate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String parentName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parentCate", cascade = CascadeType.ALL)
	List<Category> categories;
	
	public ParentCate() {
		// TODO Auto-generated constructor stub
	}

	public ParentCate(String parentName) {
		super();
		this.parentName = parentName;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
}
