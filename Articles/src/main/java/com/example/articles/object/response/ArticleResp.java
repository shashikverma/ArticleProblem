package com.example.articles.object.response;

import java.util.List;

import com.example.articles.entity.Article;

public class ArticleResp {
	String responseId;
	String responseMessage;
	List<Article> articleList;

	/************************** Getters and Setters	 ***************************************/

	public String getErrorNum() {
		return responseId;
	}

	public void setErrorNum(String errorNum) {
		this.responseId = errorNum;
	}

	public String getErrorMessage() {
		return responseMessage;
	}

	public void setErrorMessage(String message) {
		this.responseMessage = message;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	
}
