package com.master.asm.service.impl;

import com.master.asm.service.ArticleService;
import com.master.asm.dao.ArticleDao;
import com.master.asm.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleServiceImpl")
//@Transactional(propagation=Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void add(Article article) {
        articleDao.add(article);
    }

    @Override
    public void delete(Article article) {
        articleDao.delete(article);
    }

    @Override
    public void update(Article article) {
        articleDao.update(article);
    }

    @Override
    public List<Article> loadAll() {
        return articleDao.loadAll();
    }

    @Override
    public Article getById(int id) {
        return articleDao.getById(id);
    }

}