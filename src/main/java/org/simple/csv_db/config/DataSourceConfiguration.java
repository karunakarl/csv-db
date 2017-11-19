package org.simple.csv_db.config;

import javax.sql.DataSource;

import org.simple.csv_db.extensions.CustomBindyCsvDataFormat;
import org.simple.csv_db.model.Employee;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public CustomBindyCsvDataFormat bindyCSVDataFormat() {
	return new CustomBindyCsvDataFormat(Employee.class, true);
    }

    @Bean
    public DataSource dataSource() {
	return DataSourceBuilder.create().driverClassName("org.h2.Driver").username("sa").password("")
		.url("jdbc:h2:~/testcase;DB_CLOSE_ON_EXIT=FALSE").build();
    }
    
    
    /*@Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(){
	LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	em.setJpaProperties(additionalProperties());
	em.setDataSource(dataSource());
	JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
	em.setJpaVendorAdapter(jpaVendorAdapter);
	em.setPackagesToScan("org.tesco.database");
	return em;
    }
    
    
    private Properties additionalProperties(){
	Properties properties = new Properties();
	properties.put("hibernate.hbm2ddl.auto", "update");
	properties.put("spring.jpa.properties.hibernate.dialect","org.hibernate.dialect.H2Dialect");
	return properties;
    }
    
    
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }*/

}
