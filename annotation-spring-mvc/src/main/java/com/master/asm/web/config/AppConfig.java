package com.master.asm.web.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = "com.master.asm", excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = { Controller.class }) })
@PropertySource({"classpath:db-config.properties"})
public class AppConfig {

    private static final Logger logger = Logger.getLogger(AppConfig.class);

    @Value("${db.driver}")
    String driverClass;
    @Value("${db.url}")
    String url;
    @Value("${db.username}")
    String userName;
    @Value("${db.password}")
    String passWord;
    @Value("${hibernate.dialect}")
    String hibernate_dialect;
    @Value("${hibernate.show_sql}")
    String hibernate_show_sql;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord);
        if(logger.isDebugEnabled()) {
            logger.debug("DataSource: " + dataSource);
        }
        return dataSource;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        String[] packagesToScan = new String[] { "web.function.**.model.oracle" };
        sessionFactory.setPackagesToScan(packagesToScan);

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", hibernate_dialect);
        hibernateProperties.setProperty("hibernate.show_sql",
                hibernate_show_sql);
        hibernateProperties.setProperty(
                "hibernate.current_session_context_class",
                "org.springframework.orm.hibernate4.SpringSessionContext");
        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;

    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(localSessionFactoryBean()
                .getObject());
        return hibernateTransactionManager;
    }

/*    @Bean
    public static PropertySourcesPlaceholderConfigurer placehodlerConfigurer() {
        logger.info("PropertySourcesPlaceholderConfigurer");
        return new PropertySourcesPlaceholderConfigurer();
    }*/

}