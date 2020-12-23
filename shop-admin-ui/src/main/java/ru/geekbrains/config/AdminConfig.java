package ru.geekbrains.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "general_database")
@EntityScan(basePackages = "general_database.entities")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "general_database.repositories")
public class AdminConfig {

}
