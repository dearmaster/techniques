package com.master.web.dao.jdbc;

import com.master.web.model.Article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDao {

    int add(Article article) throws SQLException;
    int delete(Article article) throws SQLException;
    int update(Article article) throws SQLException;
    List<Article> loadAll() throws SQLException;

}