package com.guru.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "news")
public class New  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;

	@Type(type = "text")
	private String content1;
	private String image1;
	private String imageTitle1;

	@Type(type = "text")
	private String content2;
	private String image2;
	private String imageTitle2;

	private Date date;
	
	 @Transient
	private String splitContent;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "categories_id")
	private Category category;

	/*
	 * @OneToMany(mappedBy = "newObj", cascade = CascadeType.ALL) List<Image>
	 * images;
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImageTitle1() {
		return imageTitle1;
	}

	public void setImageTitle1(String imageTitle1) {
		this.imageTitle1 = imageTitle1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImageTitle2() {
		return imageTitle2;
	}

	public void setImageTitle2(String imageTitle2) {
		this.imageTitle2 = imageTitle2;
	}



	
	public String getSplitContent() {
		return this.content1.substring(0,2);
	}

	

}
