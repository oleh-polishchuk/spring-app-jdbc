package com.geekhub.services;

import com.geekhub.persistences.Engine;
import com.geekhub.repositories.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setDouble(1, engineCapacity);
                return  preparedStatement;
            }
        };

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        System.out.println("==> Create Engine Engine Capacity = " + engineCapacity);

        return keyHolder.getKey().intValue();
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
