package com.master.web.dao.jdbc.util;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBAction<T> {

    T doInAction(Connection connection) throws SQLException;

}