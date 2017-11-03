package com.master.asm.service;

import com.master.asm.model.Article;

import java.util.List;

public interface ArticleService {

    void add(Article article);
    void delete(Article article);
    void update(Article article);
    List<Article> loadAll();
    Article getById(int id);

}
