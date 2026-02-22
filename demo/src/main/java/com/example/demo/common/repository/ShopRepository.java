package com.example.demo.common.repository;

import com.example.demo.common.entity.Shopentity;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shopentity,Long> {

}
