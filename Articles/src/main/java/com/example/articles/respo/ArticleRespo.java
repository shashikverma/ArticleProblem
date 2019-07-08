package com.example.articles.respo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.articles.entity.Article;

@Repository
@Transactional//For Load balancing
public interface ArticleRespo extends JpaRepository<Article, Integer> {
	@Query(nativeQuery=true,value="Select * from article;")
	List<Article> getAllArticle();
	
	@Query(nativeQuery=true,value="Select * from article order by rand() limit 1;")
	Article getRandomArticle();
	
	@Query(nativeQuery=true,value="Select * from article where author=?1;")
	List<Article> getArticleByAuthor(String authorName);
	
	@Query(nativeQuery=true,value="SELECT * FROM editor.article where publish_date between ?1  and ?2 ;")
	List<Article> articleInPeriod(String fromDate,String toDate);
	
	@Query(nativeQuery=true,value="update editor.article set author=?1 where id=?2;")
	void updateAuthor(String authorName,Integer id);
	
	@Query(nativeQuery=true,value="select * from editor.article where keyword LIKE '%?1%';")
	List<Article> serachByKeyword(String keyword);
}
