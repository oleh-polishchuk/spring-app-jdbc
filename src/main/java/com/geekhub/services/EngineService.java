package com.geekhub.services;

import com.geekhub.persistences.Engine;
import com.geekhub.repositories.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class EngineService implements EngineRepository {

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
    public Integer create(Double engineCapacity) {
        String SQL = "insert into Engine (engine_capacity) values (?)";
        Integer id = jdbcTemplate.update(SQL, engineCapacity);
        System.out.println("==> Create Engine Engine Capacity = " + engineCapacity);
        return id;
    }

    @Override
    public Engine getEngine(Integer id) {
        return null;
    }

    @Override
    public List<Engine> listEngines() {
        return null;
    }

    @Override
    public void delete(Integer id) {
        System.out.println("==> m:delete");
    }

    @Override
    public void update(Integer id, Double engineCapacity) {
        System.out.println("==> m:update");
    }
}
