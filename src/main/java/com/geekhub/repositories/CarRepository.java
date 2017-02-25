package com.geekhub.repositories;

import com.geekhub.persistences.Car;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public interface CarRepository {

    void setDataSource(DataSource dataSource);

    Integer create(String name, Integer wheelId, Integer engineId);

    Car getCar(Integer id);

    List<Car> listCars();

    void delete(Integer id);

    Integer update(Integer id, String name);

    void testTransactional(Integer successCarId, Integer failureCarId);
}
