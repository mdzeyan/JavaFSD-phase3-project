package com.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.model.Products;

public interface ProductRepository extends CrudRepository<Products, Integer>{
	
	

}
