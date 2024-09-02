package com.example.Srping_day10.repository;

import com.example.Srping_day10.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Integer> {
}
