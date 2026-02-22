package com.example.demo.common.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.common.entity.Productentity;

public interface ProductRepository extends CrudRepository<Productentity, Long> {

}
