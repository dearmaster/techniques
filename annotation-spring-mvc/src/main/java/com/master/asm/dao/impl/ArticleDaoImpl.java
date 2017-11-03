package com.master.asm.dao.impl;

import com.master.asm.dao.ArticleDao;
import com.master.asm.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Override
    public void add(Article article) {
        System.out.println("add article");
    }

    @Override
    public void delete(Article article) {
        System.out.println("delete article");
    }

    @Override
    public void update(Article article) {
        System.out.println("update article");
    }

    @Override
    public Article getById(int id) {
        Article article = new Article(1, "test", "test content");
        return article;
    }

    @Override
    public List<Article> loadAll() {
        Article article1 = new Article(1, "To the West", "A novel of Chinese fairy");
        Article article2 = new Article(1, "Princess", "A simple novel");
        /**
         * ArrayList<Article> list = new ArrayList<Article>(Arrays.asList(article1, article2));
         */
        List<Article> list = new ArrayList<Article>() {{
            add(article1);
            add(article2);
        }};
        return list;
    }
}