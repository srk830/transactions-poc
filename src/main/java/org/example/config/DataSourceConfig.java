package org.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.example.constants.Constants;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Bean(name = "properties")
    public Properties properties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("use_jdbc_metadata_defaults", "false");
        return properties;
    }

    @Bean(name = Constants.DATA_SOURCE_1)
    @ConfigurationProperties(prefix = "spring.datasource1")
    public DataSource dataSource1() {
        return new HikariDataSource();
    }

    @Bean(name = Constants.DATA_SOURCE_2)
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource dataSource2() {
        return new HikariDataSource();
    }
}
