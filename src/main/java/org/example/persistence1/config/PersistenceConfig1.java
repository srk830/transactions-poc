package org.example.persistence1.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.example.constants.Constants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(value = Constants.REPOSITORIES_PACKAGE_1,
        entityManagerFactoryRef = Constants.ENTITY_MANAGER_FACTORY_1,
        transactionManagerRef = Constants.TRANSACTION_MANAGER_1)
public class PersistenceConfig1 {

    @Bean(name = Constants.DATA_SOURCE_1)
    @ConfigurationProperties(prefix = "spring.datasource1")
    public DataSource dataSource1() {
        return new HikariDataSource();
    }

    @Bean(name = Constants.ENTITY_MANAGER_FACTORY_1)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(@Qualifier(Constants.DATA_SOURCE_1) DataSource dataSource) {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("use_jdbc_metadata_defaults", "false");
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setJpaProperties(properties);
        factory.setPackagesToScan(Constants.ENTITIES_PACKAGE_1);
        factory.setDataSource(dataSource);
        return factory;
    }

    @Bean(name = Constants.TRANSACTION_MANAGER_1)
    public PlatformTransactionManager transactionManager1(@Qualifier(Constants.ENTITY_MANAGER_FACTORY_1) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}