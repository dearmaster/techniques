package com.master.web.dao.jdbc.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static final Logger logger = LogManager.getLogger(PropertiesLoader.class);
    private static final PropertiesLoader instance = new PropertiesLoader();
    //can use ResourceBundle as well
    private static Properties properties;
    private static final String PLACE_HOLDER_PREFIX = "${";
    private static final String PLACE_HOLDER_POSTFIX = "}";
    private static final String DB_PROPERTIES_CONFIGURATION_FILE = "db.properties";

    private PropertiesLoader() {
        properties = loadProperties();
        validateProperties();
    }

    public static PropertiesLoader getInstance() {
        return instance;
    }

    private final Properties loadProperties() {
        Properties properties = new Properties();
        InputStream is = null;
        try {
            /**
             * Can also load the properties like below
             FileInputStream fis = new FileInputStream("E:\\develop\\tools\\Git_Repos\\no-frame-web\\src\\main\\resources\\db.properties");
             properties.load(fis);
             is = AbstractDao.class.getClassLoader().getResourceAsStream("db.properties");
             properties.load(is);
             **/
            logger.debug("Loading properties from " + DB_PROPERTIES_CONFIGURATION_FILE);
            is = ClassLoader.getSystemResourceAsStream(DB_PROPERTIES_CONFIGURATION_FILE);
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != is)
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return properties;
    }

    private final void validateProperties() {
        if(null != properties) {
            for(String name : properties.stringPropertyNames()) {
                String value = properties.getProperty(name);
                if(value.contains(PLACE_HOLDER_PREFIX)) {
                    value = processPlaceHolders(value);
                }
                properties.setProperty(name, value);
            }
        }
    }

    private String processPlaceHolders(String value) {
        if(!value.contains(PLACE_HOLDER_PREFIX))
            return properties.getProperty(value);
        /** single thread, using StringBuilder will be faster than StringBuffer **/
        StringBuilder sb = new StringBuilder();
        sb.append(value.substring(0, value.indexOf(PLACE_HOLDER_PREFIX)));
        sb.append(processPlaceHolders(value.substring(value.indexOf(PLACE_HOLDER_PREFIX) + PLACE_HOLDER_PREFIX.length(), value.indexOf(PLACE_HOLDER_POSTFIX))));
        sb.append(value.substring(value.indexOf(PLACE_HOLDER_POSTFIX) + PLACE_HOLDER_POSTFIX.length()));
        return sb.toString();
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }

}