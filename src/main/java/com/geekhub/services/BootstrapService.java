package com.geekhub.services;

import com.geekhub.repositories.BootstrapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class BootstrapService implements BootstrapRepository {

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
    public void bootstrap() {
        String SQL;

        SQL = "CREATE TABLE IF NOT EXISTS Tyres (" +
                "   ID   INT NOT NULL AUTO_INCREMENT," +
                "   NAME CHAR(50) NULL," +
                "   SIZE INT NULL," +
                "   PRIMARY KEY (ID)" +
                ")";
        jdbcTemplate.update(SQL);
        System.out.println("==> Bootstrap Table Tyres");

        SQL = "CREATE TABLE IF NOT EXISTS Wheel (" +
                "   ID   INT NOT NULL AUTO_INCREMENT," +
                "   TYRES_ID   INT," +
                "   PRIMARY KEY (ID)," +
                "   FOREIGN KEY (TYRES_ID) REFERENCES Tyres(ID)" +
                ")";
        jdbcTemplate.update(SQL);
        System.out.println("==> Bootstrap Table Wheel");

        SQL = "CREATE TABLE IF NOT EXISTS Engine (" +
                "   ID   INT NOT NULL AUTO_INCREMENT," +
                "   ENGINE_CAPACITY   DOUBLE NOT NULL," +
                "   PRIMARY KEY (ID)" +
                ")";
        jdbcTemplate.update(SQL);
        System.out.println("==> Bootstrap Table Engine");

        SQL = "CREATE TABLE IF NOT EXISTS Car (" +
                "   ID   INT NOT NULL AUTO_INCREMENT," +
                "   NAME   CHAR(50) NULL," +
                "   ENGINE_ID   INT," +
                "   WHEEL_ID   INT," +
                "   PRIMARY KEY (ID)," +
                "   FOREIGN KEY (ENGINE_ID) REFERENCES Engine(ID)," +
                "   FOREIGN KEY (WHEEL_ID) REFERENCES Wheel(ID)" +
                ")";
        jdbcTemplate.update(SQL);
        System.out.println("==> Bootstrap Table Car");
    }
}
