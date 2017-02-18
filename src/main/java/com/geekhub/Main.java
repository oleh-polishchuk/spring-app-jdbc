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
        tyres.create("Continental", 20);
        wheel.create(tyres.getTyres(1));
//        engine.create(500.0);
//        car.create(wheel.getWheel(1), engine.getEngine(1));

    }
}
