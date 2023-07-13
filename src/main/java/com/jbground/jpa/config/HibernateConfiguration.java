package com.jbground.jpa.config;


import com.jbground.jpa.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfiguration {

    private final Logger logger = LoggerFactory.getLogger(HibernateConfiguration.class);

    @Autowired
    private DataSource dataSource;


    @Bean
    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.h2.Driver");
        properties.put(Environment.URL, "jdbc:h2:~/test");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");

        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "none");

        for(String pName : properties.stringPropertyNames()){
            logger.info("hibernate setting value - {} : {}", pName, properties.get(pName));
        }

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
