package com.example.demo.common.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.common.entity.Basketentity;

public interface BasketRepository extends CrudRepository<Basketentity, Long> {

}
