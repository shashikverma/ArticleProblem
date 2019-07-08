package com.example.articles.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.articles.ArticlesApplication;
import com.example.articles.entity.Article;
import com.example.articles.object.request.ArticlePeriodReq;
import com.example.articles.object.request.ArticleReq;
import com.example.articles.object.request.ArticleUpdateReq;
import com.example.articles.object.response.ArticleResp;
import com.example.articles.respo.ArticleRespo;
import com.example.articles.util.Util;

@Service
public class ArticleService {
	@Autowired
	ArticleRespo articleRespo;

	ArrayList<Article> articleList = new ArrayList<Article>();
	{
		Article article = new Article();
		article.setAuthor("Kumar");
		article.setHeader("Mumbai Flood");
		article.setKeyword("flood,rain,climate change");
		article.setPublishDate(new Date());
		article.setShortDescription("Heavy Rain in Mumbai");
		article.setText("Mumbai Stoped Due to Heavy Rain");
		articleList.add(article);
	}

	public ArticleResp createArticle(ArticleReq req) {
		// TODO Auto-generated method stu
		ArticleResp res = new ArticleResp();
		List<Article> articleList = new ArrayList<Article>();
		try {
			Article article = new Article();
			article.setAuthor(req.getAuthor());
			article.setHeader(req.getHeader());
			article.setKeyword(req.getKeyword());
			article.setPublishDate(req.getPublishDate());
			article.setShortDescription(req.getShortDescription());
			article.setText(req.getText());
			article = articleRespo.save(article);
			res.setErrorNum("00");
			res.setErrorMessage(Util.ERRORNUM.ZERO);
			articleList.add(article);
			res.setArticleList(articleList);
		} catch (Exception e) {
			e.printStackTrace();
			res.setErrorNum("01");
			res.setErrorMessage(Util.ERRORNUM.ONE + " " + e);
			res.setArticleList(articleList);
		}
		return res;
	}

	public ArticleResp displayArticle() {
		// TODO Auto-generated method stub
		ArticleResp resp = new ArticleResp();
		List<Article> articleList = new ArrayList<Article>();
		try {
			articleList.add(articleRespo.getRandomArticle());
			resp.setErrorMessage("00");
			resp.setErrorMessage(Util.ERRORNUM.ZERO);
			resp.setArticleList(articleList);
			return resp;// (rand.nextInt(articleList.size()));
		} catch (Exception e) {
			e.printStackTrace();
			resp.setErrorMessage("00");
			resp.setErrorMessage(Util.ERRORNUM.ZERO);
			resp.setArticleList(articleList);
			return resp;
		}
	}

	public ArticleResp displayAuthorsArticle(String authorName) {
		// TODO Auto-generated method stub
		ArticleResp resp = new ArticleResp();
		List<Article> articleList = new ArrayList<Article>();
		try {
			articleList.addAll(articleRespo.getArticleByAuthor(authorName));
			resp.setArticleList(articleList);
			resp.setErrorNum("00");
			resp.setErrorMessage(Util.ERRORNUM.ZERO);
		} catch (Exception e) {
			resp.setErrorNum("02");
			resp.setErrorMessage(Util.ERRORNUM.TWO);
			resp.setArticleList(articleList);
		}
		return resp;
	}

	public ArticleResp articleBetweenPeriod(ArticlePeriodReq req) {
		// TODO Auto-generated method stub
		ArticleResp resp = new ArticleResp();
		List<Article> articleList = new ArrayList<Article>();
		try {
//			SimpleDateFormat sdfReq=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			SimpleDateFormat sqlFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			articleList.addAll(articleRespo.articleInPeriod(sqlFormat.format(req.getFromDate()), sqlFormat.format(req.getToDate())));
			resp.setArticleList(articleList);
			resp.setErrorNum("00");
			resp.setErrorMessage(Util.ERRORNUM.ZERO);
		} catch (Exception e) {
			resp.setErrorNum("02");
			resp.setErrorMessage(Util.ERRORNUM.TWO);
			resp.setArticleList(articleList);
		}
		return resp;
	}
	
	public ArticleResp deleteById(Integer id) {
		// TODO Auto-generated method stub
		ArticleResp resp = new ArticleResp();
		List<Article> articleList = new ArrayList<Article>();
		try {
			articleRespo.deleteById(id);
			resp.setArticleList(articleList);
			resp.setErrorNum("00");
			resp.setErrorMessage(Util.ERRORNUM.ZERO+" in deleting article with id : "+id);
		} catch (Exception e) {
			resp.setErrorNum("02");
			resp.setErrorMessage(Util.ERRORNUM.THREE);
			resp.setArticleList(articleList);
		}
		return resp;
	}
	
	public ArticleResp updateAuthor(ArticleUpdateReq req) {
		// TODO Auto-generated method stub
		ArticleResp resp = new ArticleResp();
		List<Article> articleList = new ArrayList<Article>();
		try {
			articleRespo.updateAuthor(req.getAuthor(), req.getId());
			resp.setArticleList(articleList);
			resp.setErrorNum("00");
			resp.setErrorMessage(Util.ERRORNUM.ZERO+" in updating article with id : "+req.getId());
		} catch (Exception e) {
			resp.setErrorNum("04");
			resp.setErrorMessage(Util.ERRORNUM.FOUR);
			resp.setArticleList(articleList);
		}
		return resp;
	}
	
	public ArticleResp searchByKeyword(String keyword) {
		// TODO Auto-generated method stub
		ArticleResp resp = new ArticleResp();
		List<Article> articleList = new ArrayList<Article>();
		try {
			articleList=articleRespo.serachByKeyword(keyword);//(req.getAuthor(), req.getId());
			resp.setArticleList(articleList);
			resp.setErrorNum("00");
			resp.setErrorMessage(Util.ERRORNUM.ZERO);
		} catch (Exception e) {
			resp.setErrorNum("05");
			resp.setErrorMessage(Util.ERRORNUM.FIVE);
			resp.setArticleList(articleList);
		}
		return resp;
	}
	

}
