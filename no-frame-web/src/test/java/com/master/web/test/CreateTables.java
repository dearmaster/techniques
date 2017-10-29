package com.master.web.test;

import com.master.web.dao.jdbc.AbstractDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTables extends AbstractDao {

    private static final String CREATE_TABLE_ARTICLE = "create table article_tbl(id int primary key, subject varchar(100) unique not null, content text)";
    private static final String DROP_TABLE_ARTICLE = "drop table article_tbl";
    private static final CreateTables instance = new CreateTables();
    private static final Logger logger = LogManager.getLogger(CreateTables.class);

    public void execute(String sql) throws SQLException {
        execute(
                (connection) -> {
                    PreparedStatement psmt = connection.prepareStatement(sql);
                    psmt.execute();
                    logger.debug("Executed: " + sql);
                    return null;
                }
        );
    }

    public static void main(String[] args) {
        try {
            instance.execute(DROP_TABLE_ARTICLE);
            instance.execute(CREATE_TABLE_ARTICLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}