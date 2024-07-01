package org.example.process.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.example.process.constants.Constants;
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
@EnableJpaRepositories(value = Constants.REPOSITORIES_PACKAGE,
        entityManagerFactoryRef = Constants.ENTITY_MANAGER_FACTORY,
        transactionManagerRef = Constants.TRANSACTION_MANAGER)
public class PersistenceConfig {

    @Bean(name = Constants.DATA_SOURCE)
    @ConfigurationProperties(prefix = "process.datasource")
    public DataSource dataSource1() {
        return new HikariDataSource();
    }

    @Bean(name = Constants.ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(@Qualifier(Constants.DATA_SOURCE) DataSource dataSource) {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("use_jdbc_metadata_defaults", "false");

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPackagesToScan(Constants.ENTITIES_PACKAGE);
        factory.setPersistenceUnitName("persistenceUnit1");
        factory.setJpaProperties(properties);
        return factory;
    }

    @Bean(name = Constants.TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager1(@Qualifier(Constants.ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}