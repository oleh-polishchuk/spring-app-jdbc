package com.geekhub.mappers;

import com.geekhub.persistences.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setName(rs.getString("name"));
        car.setEngineId(rs.getInt("engine_id"));
        car.setWheelsId(rs.getInt("wheel_id"));
        return car;
    }

}
