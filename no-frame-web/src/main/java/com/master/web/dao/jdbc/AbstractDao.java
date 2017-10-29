package com.master.web.dao.jdbc;

import com.master.web.dao.jdbc.util.DBAction;
import com.master.web.dao.jdbc.util.DBConnectionHelper;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDao {

    private DBConnectionHelper dbConnectionHelper;

    public AbstractDao() {
        dbConnectionHelper = DBConnectionHelper.getInstance();
    }

    protected <T> T execute(DBAction<T> action) throws SQLException {
        Connection connection = dbConnectionHelper.getConnection();
        T t = action.doInAction(connection);
        dbConnectionHelper.closeConnection(connection);
        return t;
    }

}