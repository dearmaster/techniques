package com.master.asm.dao;

import com.master.asm.model.Article;

import java.util.List;

public interface ArticleDao {

    void add(Article article);
    void delete(Article article);
    void update(Article article);
    Article getById(int id);
    List<Article> loadAll();

}