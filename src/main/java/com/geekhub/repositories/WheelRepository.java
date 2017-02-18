package com.geekhub.repositories;

import com.geekhub.persistences.Tyres;
import com.geekhub.persistences.Wheel;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public interface WheelRepository {

    void setDataSource(DataSource dataSource);

    void create(Tyres tyres);

    Wheel getWheel(Integer id);

    List<Wheel> listWheels();

    void delete(Integer id);

    void update(Integer id, Tyres tyres);
}
