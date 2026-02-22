package com.example.demo.common.repository;

import com.example.demo.common.entity.Itementity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Itementity,Long> {
}
