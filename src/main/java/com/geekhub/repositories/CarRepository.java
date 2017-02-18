package com.geekhub.repositories;

import com.geekhub.persistences.Car;
import com.geekhub.persistences.Engine;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public interface CarRepository {

    void setDataSource(DataSource dataSource);

    Integer create(Integer wheelId, Integer engineId);

    Car getCar(Integer id);

    List<Car> listCars();

    void delete(Integer id);

    void update(Integer id, Engine engine);
}
