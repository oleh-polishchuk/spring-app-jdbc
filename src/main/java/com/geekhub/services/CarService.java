package com.geekhub.services;

import com.geekhub.mappers.CarMapper;
import com.geekhub.persistences.Car;
import com.geekhub.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
@Transactional
public class CarService implements CarRepository {


    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager transactionManager;
    private TransactionTemplate transactionTemplate;

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public Integer create(String name, Integer wheelId, Integer engineId) {
        String SQL = "insert into Car (name, wheel_id, engine_id) values (?, ?, ?)";

        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, wheelId);
                preparedStatement.setInt(3, engineId);
                return  preparedStatement;
            }
        };

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        System.out.println("==> Create Car NAME = " + name + " Wheel ID = " + wheelId + " Engine ID = " + engineId);

        return keyHolder.getKey().intValue();
    }

    @Override
    public Car getCar(Integer id) {
        String SQL = "select * from Car where id = ?";
        Car car = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new CarMapper());
        return car;
    }

    @Override
    public List<Car> listCars() {
        String SQL = "select * from Car";
        List<Car> cars = jdbcTemplate.query(SQL, new CarMapper());
        return cars;
    }

    @Override
    public void delete(Integer id) {
        System.out.println("==> m:delete");
    }

    @Override
    public Integer update(Integer id, String name) {
        String SQL = "update Car set name = ? where id = ?";
        Integer carId = jdbcTemplate.update(SQL, name, id);
        System.out.println("==> Updated Car with ID = " + id + " NAME = " + name);
        return carId;
    }

    public void testTransactional(Integer successCarId, Integer failureCarId) {
        transactionTemplate = new TransactionTemplate(transactionManager);

        transactionTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                // Success update
                Integer carId = jdbcTemplate.update("update Car set name = ? where id = ?", "SUCCESS", successCarId);
                System.out.println("==> Test transactional: Updated Car with ID = " + successCarId + " NAME = SUCCESS");


                Assert.notNull(failureCarId, "==> Car ID can not be NULL!");

                // Failure update
                carId = jdbcTemplate.update("update Car set name = ? where id = ?", "FAILURE", failureCarId);
                System.out.println("==> Test transactional: Updated Car with ID = " + failureCarId + " NAME = FAILURE");

                return carId;
            }
        });
    }
}
