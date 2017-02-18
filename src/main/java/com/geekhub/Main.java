package com.geekhub;

import com.geekhub.config.AppConfig;
import com.geekhub.repositories.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BootstrapRepository bootstrap = context.getBean(BootstrapRepository.class);
        TyresRepository tyres = context.getBean(TyresRepository.class);
        WheelRepository wheel = context.getBean(WheelRepository.class);
        EngineRepository engine = context.getBean(EngineRepository.class);
        CarRepository car = context.getBean(CarRepository.class);

        System.out.println("------ Bootstrap ------");
        bootstrap.bootstrap();

        System.out.println("------ Records Creation ------");
        Integer tyresId = tyres.create("Continental", 20);
        Integer wheelId = wheel.create(tyresId);
        Integer engineId = engine.create(500.0);
        Integer carId = car.create(wheelId, engineId);

    }
}
