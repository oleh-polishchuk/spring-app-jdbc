package com.geekhub.repositories;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public interface BootstrapRepository {

    void setDataSource(DataSource dataSource);

    void bootstrap();
}
