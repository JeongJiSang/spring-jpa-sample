package com.jbground.web.config.database;//package com.jbground.jpa.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//public class JPAConfiguration {
//    private final Logger logger = LoggerFactory.getLogger(JPAConfiguration.class);
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public Properties propertySet() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", env.getProperty("jbground.batch.hibernate.dialect"));
//        properties.setProperty("hibernate.show_sql", env.getProperty("jbground.database.debug"));
//        properties.setProperty("hibernate.format_sql", env.getProperty("jbground.batch.hibernate.format_sql"));
//        return properties;
//    }
//
//    @Bean
//    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
//        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//        hibernateJpaVendorAdapter.setShowSql(true);
//        return hibernateJpaVendorAdapter;
//    }
//
//    @Bean(name = "oracle_factory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
//        entityManagerFactoryBean.setDataSource(dataSource);
//        entityManagerFactoryBean.setPackagesToScan("com.jbground.code.model");
//        entityManagerFactoryBean.setPersistenceUnitName("oracle");
//        entityManagerFactoryBean.setJpaProperties(propertySet());
//
//        logger.info("Create oracle entityManaberFactoryBean.");
//        return entityManagerFactoryBean;
//    }
//
//    @Primary
//    @Bean(name = "oracle_manager")
//    public PlatformTransactionManager oracleTransactionManager() {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory().getObject());
//        jpaTransactionManager.setDataSource(dataSource);
//
//        logger.info("Create oracle PlatformTransactionManager.");
//        return jpaTransactionManager;
//    }
//}
