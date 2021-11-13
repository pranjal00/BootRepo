package com.actuator.config.persistenceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class PersistenceConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "dataSource")
    public DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.driverClassName"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));

        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);

        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setPackagesToScan("com.actuator.entities");

        return entityManagerFactory;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager platformTransactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
