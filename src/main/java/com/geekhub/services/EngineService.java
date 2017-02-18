package com.geekhub.services;

import com.geekhub.persistences.Engine;
import com.geekhub.repositories.EngineRepository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class EngineService implements EngineRepository {

    @Override
    public void setDataSource(DataSource dataSource) {
        System.out.println("==> m:setDataSource");
    }

    @Override
    public void create(Double engineCapacity) {
        System.out.println("==> m:create");
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
