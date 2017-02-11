package com.geekhub;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.geekhub.*"})
@PropertySource("classpath:application.properties")
public class AppConfig {

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
}
