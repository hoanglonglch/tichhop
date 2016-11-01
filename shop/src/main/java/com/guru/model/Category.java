package com.guru.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@ManyToOne
	@JoinColumn(name = "parentcate_id")
	ParentCate parentCate;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	Set<New> news;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ParentCate getParentCate() {
		return parentCate;
	}

	public void setParentCate(ParentCate parentCate) {
		this.parentCate = parentCate;
	}

	public Set<New> getNews() {
		return news;
	}

	public void setNews(Set<New> news) {
		this.news = news;
	}

	
}
