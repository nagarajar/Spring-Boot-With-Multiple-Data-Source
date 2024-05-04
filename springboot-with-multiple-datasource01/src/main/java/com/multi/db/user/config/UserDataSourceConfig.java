package com.multi.db.user.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "userEntityManagerFactory", 
		transactionManagerRef = "userTransactionManager",
		basePackages = "com.multi.db.user.repo")
public class UserDataSourceConfig {
	
	@Bean(name = "userDataSource")
	@ConfigurationProperties(prefix = "spring.userdb.datasource")
	DataSource userDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "userEntityManagerFactory")
	LocalContainerEntityManagerFactoryBean userEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("userDataSource") DataSource userDataSource) {
		return builder.dataSource(userDataSource).packages("com.multi.db.user.entity").build();
	}

	@Bean(name = "userTransactionManager")
	PlatformTransactionManager userTransactionManager(
			@Qualifier("userEntityManagerFactory") EntityManagerFactory userEntityManagerFactory) {
		return new JpaTransactionManager(userEntityManagerFactory);
	}
}
