package com.geekhub.services;

import com.geekhub.persistences.Car;
import com.geekhub.persistences.Engine;
import com.geekhub.persistences.Wheel;
import com.geekhub.repositories.CarRepository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class CarService implements CarRepository {
    @Override
    public void setDataSource(DataSource dataSource) {
        System.out.println("==> m:setDataSource");
    }

    @Override
    public void create(Wheel wheels, Engine engine) {
        System.out.println("==> m:create");
    }

    @Override
    public Car getCar(Integer id) {
        return null;
    }

    @Override
    public List<Car> listCars() {
        return null;
    }

    @Override
    public void delete(Integer id) {
        System.out.println("==> m:delete");
    }

    @Override
    public void update(Integer id, Engine engine) {
        System.out.println("==> m:update");
    }
}
