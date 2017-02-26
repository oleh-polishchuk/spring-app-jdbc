package com.geekhub.repositories;

import com.geekhub.persistences.Engine;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public interface EngineRepository {

    void setDataSource(DataSource dataSource);

    Integer create(Double engineCapacity);

    Engine getEngine(Integer id);

    List<Engine> listEngines();

    void delete(Integer id);

    void update(Integer id, Double engineCapacity);
}
