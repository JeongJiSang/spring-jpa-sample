package com.jbground.jpa.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Configuration
public class H2DatabaseConfiguration implements ApplicationRunner {

    private final static Logger logger = LoggerFactory.getLogger(H2DatabaseConfiguration.class);

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public H2DatabaseConfiguration(DataSource dataSource, JdbcTemplate jdbcTemplate) { //생성자 주입
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection con = dataSource.getConnection()){
            Statement statement = con.createStatement();
            String sql = "CREATE TABLE MEMBER (\n" +
                    "                        ID VARCHAR(255) NOT NULL, --아이디(기본 키)\n" +
                    "                        NAME VARCHAR(255),        --이름\n" +
                    "                        AGE INTEGER NOT NULL,     --나이\n" +
                    "                        PRIMARY KEY (ID)\n" +
                    ")";

            logger.info("CREATE MEMBER sql : {}", sql);
            statement.executeUpdate(sql);

        }
    }


}
