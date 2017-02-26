package com.geekhub.mappers;

import com.geekhub.persistences.Tyres;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TyresMapper implements RowMapper<Tyres> {
    @Override
    public Tyres mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tyres tyres = new Tyres();
        tyres.setId(rs.getInt("id"));
        tyres.setName(rs.getString("name"));
        tyres.setSize(rs.getInt("size"));
        return tyres;
    }
}
