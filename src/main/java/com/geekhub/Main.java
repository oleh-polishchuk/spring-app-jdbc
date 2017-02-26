package com.geekhub;

import com.geekhub.config.AppConfig;
import com.geekhub.persistences.Car;
import com.geekhub.repositories.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

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
        Integer carId = car.create("BMW", wheelId, engineId);

        System.out.println("------ Listing Multiple Records --------");
        List<Car> cars = car.listCars();
        for (Car record : cars) {
            System.out.println("ID : " + record.getId());
            System.out.println("NAME : " + record.getName());
            System.out.println("ENGINE : " + record.getEngineId());
            System.out.println("WHEELS : " + record.getWheelsId());
        }

        System.out.println("---- Updating Record -----");
        carId = car.update(carId, "Ford Focus");

        System.out.println("----Listing Record with ID = 1 -----");
        Car myCar = car.getCar(carId);
        System.out.print("ID : " + myCar.getId());
        System.out.print(", Name : " + myCar.getName());
        System.out.print(", WheelsId : " + myCar.getWheelsId());
        System.out.println(", EngineId : " + myCar.getEngineId());

        System.out.println("---- Test Transaction with ID = null -----");
        car.testTransactional(carId, null);

    }
}
