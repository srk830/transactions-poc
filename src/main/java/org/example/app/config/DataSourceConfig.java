//package org.example.app.config;
//
//import com.atomikos.jdbc.AtomikosDataSourceBean;
//import com.mysql.cj.jdbc.MysqlXADataSource;
//import org.example.app.constants.Constants;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean(name = Constants.DATA_SOURCE_1)
//    public DataSource dataSourceOne() {
//        MysqlXADataSource xaDataSource = new MysqlXADataSource();
//        xaDataSource.setUrl("jdbc:mysql://localhost:3306/db1");
//        xaDataSource.setUser("root");
//        xaDataSource.setPassword("root");
//
//        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
//        dataSource.setUniqueResourceName("DataSource1");
//        dataSource.setXaDataSource(xaDataSource);
//        dataSource.setMinPoolSize(5);
//        dataSource.setMaxPoolSize(20);
//        dataSource.setMaxIdleTime(60);
//        return dataSource;
//    }
//
//    @Bean(name = Constants.DATA_SOURCE_2)
//    public DataSource dataSource2() {
//        MysqlXADataSource xaDataSource = new MysqlXADataSource();
//        xaDataSource.setUrl("jdbc:mysql://localhost:3306/db2");
//        xaDataSource.setUser("root");
//        xaDataSource.setPassword("root");
//
//        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
//        dataSource.setUniqueResourceName("DataSource2");
//        dataSource.setXaDataSource(xaDataSource);
//        dataSource.setMinPoolSize(5);
//        dataSource.setMaxPoolSize(10);
//        dataSource.setMaxIdleTime(60);
//        return dataSource;
//    }
//
//}
