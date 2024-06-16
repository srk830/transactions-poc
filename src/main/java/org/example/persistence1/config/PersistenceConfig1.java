package org.example.persistence1.config;

import jakarta.persistence.EntityManagerFactory;
import org.example.constants.Constants;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean(name = Constants.ENTITY_MANAGER_FACTORY_1)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(@Qualifier(Constants.DATA_SOURCE_1) DataSource dataSource,
                                                                        @Qualifier("properties") Properties properties) {
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