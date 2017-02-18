package com.geekhub.repositories;

import com.geekhub.persistences.Tyres;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public interface TyresRepository {

    void setDataSource(DataSource dataSource);

    void create(String name, Integer size);

    Tyres getTyres(Integer id);

    List<Tyres> listTyres();

    void delete(Integer id);

    void updateName(Integer id, String name);

    void updateSize(Integer id, Integer size);
}
