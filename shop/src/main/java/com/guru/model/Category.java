package com.guru.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	List<New> news;

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

	public List<New> getNews() {
		return news;
	}

	public void setNews(List<New> news) {
		this.news = news;
	}
	
}
