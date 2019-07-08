package com.example.articles.object.request;

import java.util.Date;


public class ArticleUpdateReq {
	
	String author;
	Integer id;
	
	/*****************Getter and Setters*********************************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
