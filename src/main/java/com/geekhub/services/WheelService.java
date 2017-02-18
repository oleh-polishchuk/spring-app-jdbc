package com.geekhub.services;

import com.geekhub.persistences.Tyres;
import com.geekhub.persistences.Wheel;
import com.geekhub.repositories.WheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
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
    public void create(Tyres tyres) {
//        String SQL = "insert into Wheel (tyres_id) values (?)";
//        jdbcTemplate.update(SQL, tyres);
//        System.out.println("==> Create Tyres Name = " + name + " Size = " + size);
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
