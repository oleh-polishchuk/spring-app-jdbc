package com.geekhub.services;

import com.geekhub.persistences.Car;
import com.geekhub.persistences.Engine;
import com.geekhub.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class CarService implements CarRepository {


    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer create(Integer wheelId, Integer engineId) {
        String SQL = "insert into Car (wheel_id, engine_id) values (?, ?)";
        Integer id = jdbcTemplate.update(SQL, wheelId, engineId);
        System.out.println("==> Create Car Wheel ID = " + wheelId + " Engine ID = " + engineId);
        return id;
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
