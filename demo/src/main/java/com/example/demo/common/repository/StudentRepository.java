package com.example.demo.common.repository;

import com.example.demo.common.entity.Studententity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Studententity, Long> {

}
