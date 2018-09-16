package com.example.task.repository;


import com.example.task.models.Factory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface FactoryRepository extends CrudRepository <Factory, Long> {

    @Query(value = "select * from factory ",nativeQuery = true)
    List<Factory> find();
}
