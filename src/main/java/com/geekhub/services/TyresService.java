package com.geekhub.services;

import com.geekhub.mappers.TyresMapper;
import com.geekhub.persistences.Tyres;
import com.geekhub.repositories.TyresRepository;
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
public class TyresService implements TyresRepository {

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
    public Integer create(String name, Integer size) {
        String SQL = "insert into Tyres (name, size) values (?, ?)";

        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, size);
                return  preparedStatement;
            }
        };

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        System.out.println("==> Create Tyres Name = " + name + " Size = " + size);

        return keyHolder.getKey().intValue();
    }

    @Override
    public Tyres getTyres(Integer id) {
        String SQL = "select * from Tyres where id = ?";
        Tyres tyres = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new TyresMapper());
        return tyres;
    }

    @Override
    public List<Tyres> listTyres() {
        return null;
    }

    @Override
    public void delete(Integer id) {
        System.out.println("==> m:delete");
    }

    @Override
    public void updateName(Integer id, String name) {
        System.out.println("==> m:updateName");
    }

    @Override
    public void updateSize(Integer id, Integer size) {
        System.out.println("==> m:updateSize");
    }
}
