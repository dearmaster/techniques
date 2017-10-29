package com.master.web.dao.jdbc.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionHelper {

    private static DBConnectionHelper instance;
    private PropertiesLoader propertiesLoader;
    public static final String PROPERTY_NAME_URL = "DB.URL";
    public static final String PROPERTY_NAME_DRIVER = "DB.DRIVER";
    public static final String PROPERTY_NAME_USERNAME = "DB.USERNAME";
    public static final String PROPERTY_NAME_PASSWORD = "DB.PASSWORD";
    private static final Logger logger = LogManager.getLogger(DBConnectionHelper.class);

    private DBConnectionHelper() {
        propertiesLoader = PropertiesLoader.getInstance();
    }

    public static DBConnectionHelper getInstance() {
        if(null == instance) {
            synchronized (DBConnectionHelper.class) {
                if(null == instance)
                    instance = new DBConnectionHelper();
            }
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        String url = propertiesLoader.getProperty(PROPERTY_NAME_URL);
        String driver = propertiesLoader.getProperty(PROPERTY_NAME_DRIVER);
        String username = propertiesLoader.getProperty(PROPERTY_NAME_USERNAME);
        String password = propertiesLoader.getProperty(PROPERTY_NAME_PASSWORD);
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            logger.debug("New DB connection: " + connection.hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        if(null != connection)
            try {
                logger.debug("Closing connection: " + connection.hashCode());
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}