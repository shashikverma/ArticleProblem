package com.example.articles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.articles.object.request.ArticlePeriodReq;
import com.example.articles.object.request.ArticleReq;
import com.example.articles.object.request.ArticleUpdateReq;
import com.example.articles.object.response.ArticleResp;
import com.example.articles.service.ArticleService;

@RestController
@RequestMapping("/api/")
public class ArticleController {
	@Autowired
	ArticleService articleService;

	@RequestMapping(path = "createArticle", method = RequestMethod.POST)
	public ArticleResp createArticle(@RequestBody ArticleReq req) {
		ArticleResp response = new ArticleResp();
		response = articleService.createArticle(req);
		return response;
	}

	@RequestMapping(path = "displayOneRandomArticle", method = RequestMethod.GET)
	public ArticleResp displayArticle() {
		ArticleResp response = new ArticleResp();
		response = articleService.displayArticle();
		return response;
	}

	@RequestMapping(path = "displayAuthorsArticle", method = RequestMethod.POST)
	public ArticleResp displayAuthorsArticle(@RequestBody String authorName) {
		ArticleResp resp=new ArticleResp();
		resp = articleService.displayAuthorsArticle(authorName);
		return resp;
	}

	@RequestMapping(path = "articleBetweenPeriod", method = RequestMethod.POST)
	public ArticleResp articleBetweenPeriod(@RequestBody ArticlePeriodReq articlePeriodReq) {
		ArticleResp resp=new ArticleResp();
		resp = articleService.articleBetweenPeriod(articlePeriodReq);
		return resp;
	}
	
	@RequestMapping(path = "updateAuthor", method = RequestMethod.POST)
	public ArticleResp updateAuthor(@RequestBody ArticleUpdateReq articlePeriodReq) {
		ArticleResp resp=new ArticleResp();
		resp = articleService.updateAuthor(articlePeriodReq);
		return resp;
	}

	@RequestMapping(path = "deleteById", method = RequestMethod.PUT)
	public ArticleResp updateAuthor(@RequestBody Integer id) {
		ArticleResp resp=new ArticleResp();
		resp = articleService.deleteById(id);
		return resp;
	}
	
	@RequestMapping(path = "searchArticleByKeyword", method = RequestMethod.PUT)
	public ArticleResp searchArticleByKeyword(@RequestBody String keyword) {
		ArticleResp resp=new ArticleResp();
		resp = articleService.searchByKeyword(keyword);//(id);
		return resp;
	}

}
