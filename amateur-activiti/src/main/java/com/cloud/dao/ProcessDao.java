package com.cloud.dao;

import com.cloud.entity.ProcessEO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProcessDao extends CrudRepository<ProcessEO,Long> {

    @Query(value="select eo from ProcessEO eo where eo.name = :name")
    public ProcessEO findProcessByName(String name);
}
