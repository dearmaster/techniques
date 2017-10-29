//package com.master.web.dao.jdbc.impl;
//
//import com.master.web.dao.jdbc.util.DBConnectionHelper;
//import com.master.web.dao.jdbc.util.PropertiesLoader;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.dbunit.DBTestCase;
//import org.dbunit.PropertiesBasedJdbcDatabaseTester;
//import org.dbunit.dataset.IDataSet;
//import org.dbunit.dataset.ITable;
//import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.FileInputStream;
//
///**
// * I didn't find the strength of using DBUnit yet
// */
//@Deprecated
//public class DbUnitArticleDaoImplTest extends DBTestCase{
//
//    private static final Logger logger = LogManager.getLogger(DbUnitArticleDaoImplTest.class);
//    private static PropertiesLoader propertiesLoader = PropertiesLoader.getInstance();
//
//    @Override
//    protected IDataSet getDataSet() throws Exception {
//        logger.info("load xml data....");
//        return new FlatXmlDataSetBuilder().build(new FileInputStream("ecs_card.xml"));
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, propertiesLoader.getProperty(DBConnectionHelper.PROPERTY_NAME_DRIVER));
//        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, propertiesLoader.getProperty(DBConnectionHelper.PROPERTY_NAME_URL));
//        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, propertiesLoader.getProperty(DBConnectionHelper.PROPERTY_NAME_USERNAME));
//        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, propertiesLoader.getProperty(DBConnectionHelper.PROPERTY_NAME_PASSWORD));
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void add() throws Exception {
//    }
//
//    private ITable getXmlTable(String xmlFileName,String tableName) throws Exception {
//        //取XML备份表
//        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
//        builder.setColumnSensing(true);
//        IDataSet xmlDataSet = builder.build(new FileInputStream(xmlFileName));
//        return xmlDataSet.getTable(tableName);
//    }
//
//    @Test
//    public void delete() throws Exception {
//    }
//
//    @Test
//    public void update() throws Exception {
//    }
//
//    @Test
//    public void testLoadAll() throws Exception {
//        String sql = "select * from article_tbl ";
//        ITable  dbTable = getConnection().createQueryTable("article_tbl",sql);
//        assertEquals(0,dbTable.getRowCount());
//
////        String cardName = (String) dbTable.getValue(0,"subject");
////        assertEquals("贺卡",cardName);
//    }
//
//}