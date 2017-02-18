package com.geekhub.config;

import com.geekhub.persistences.Car;
import com.geekhub.persistences.Engine;
import com.geekhub.persistences.Tyres;
import com.geekhub.persistences.Wheel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.geekhub.*"})
@PropertySource("classpath:application.properties")
public class AppConfig {


    @Value("${spring.datasource.driver-class-name}")
    String driverClassName;

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${engine.capacity}")
    private Double engineCapacity;

    @Value("${tyres.name}")
    private String tyresName;

    @Value("${tyres.size}")
    private Integer tyresSize;

    @Bean
    public Car car(Wheel wheel, Engine engine) {
        return new Car(wheel, engine);
    }

    @Bean
    public Engine engine() {
        return new Engine(engineCapacity);
    }

    @Bean
    public Tyres tyres() {
        return new Tyres(tyresName, tyresSize);
    }

    @Bean
    public Wheel wheel(Tyres tyres) {
        return new Wheel(tyres);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
