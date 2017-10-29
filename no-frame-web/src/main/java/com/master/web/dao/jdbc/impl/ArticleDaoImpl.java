package com.master.web.dao.jdbc.impl;

import com.master.web.dao.jdbc.AbstractDao;
import com.master.web.dao.jdbc.ArticleDao;
import com.master.web.dao.jdbc.util.DBAction;
import com.master.web.model.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl extends AbstractDao implements ArticleDao {

    private static final String INSERT_ARTICLE_SQL = "insert into article_tbl(subject, content) values (?, ?)";
    private static final String DELETE_ARTICLE_SQL = "delete from article_tbl where name = ?";
    private static final String UPDATE_ARTICLE_SQL = "update article_tbl set content = ? where name = ?";
    private static final String LOAD_ALL_ARTICLE_SQL = "select * from article_tbl";

    @Override
    public int add(Article article) throws SQLException {
        return execute(new DBAction<Integer>() {
            @Override
            public Integer doInAction(Connection connection) throws SQLException {
                PreparedStatement psmt = connection.prepareStatement(INSERT_ARTICLE_SQL);
                psmt.setString(1, article.getSubject());
                psmt.setString(2, article.getContent());
                return psmt.executeUpdate();
            }
        });
    }

    @Override
    public int delete(Article article) throws SQLException {
        return execute(
                (connection) -> {
                    PreparedStatement psmt = connection.prepareStatement(DELETE_ARTICLE_SQL);
                    psmt.setString(1, article.getSubject());
                    return psmt.executeUpdate();
                }
        );
    }

    @Override
    public int update(Article article) throws SQLException {
        return execute(
                (connection) -> {
                    PreparedStatement psmt = connection.prepareStatement(UPDATE_ARTICLE_SQL);
                    psmt.setString(2, article.getContent());
                    psmt.setString(1, article.getSubject());
                    return psmt.executeUpdate();
                }
        );
    }

    @Override
    public List<Article> loadAll() throws SQLException {
        return execute(
                (connection) -> {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(LOAD_ALL_ARTICLE_SQL);
                    return encapsulate(rs);
                }
        );
    }

    private List<Article> encapsulate(ResultSet rs) throws SQLException {
        List<Article> list = new ArrayList<>();
        while(rs.next()) {
            Article article = new Article();
            article.setId(rs.getInt("id"));
            article.setSubject(rs.getString("subject"));
            article.setContent(rs.getString("content"));
            list.add(article);
        }
        return list;
    }

}
