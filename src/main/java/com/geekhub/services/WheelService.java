package com.geekhub.services;

import com.geekhub.persistences.Tyres;
import com.geekhub.persistences.Wheel;
import com.geekhub.repositories.WheelRepository;
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
public class WheelService implements WheelRepository {

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
    public Integer create(Integer id) {
        String SQL = "insert into Wheel (tyres_id) values (?)";

        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, id);
                return  preparedStatement;
            }
        };

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        System.out.println("==> Create Wheel ID = " + id);

        return keyHolder.getKey().intValue();
    }

    @Override
    public Wheel getWheel(Integer id) {
        return null;
    }

    @Override
    public List<Wheel> listWheels() {
        return null;
    }

    @Override
    public void delete(Integer id) {
        System.out.println("==> m:delete");
    }

    @Override
    public void update(Integer id, Tyres tyres) {
        System.out.println("==> m:update");
    }
}
