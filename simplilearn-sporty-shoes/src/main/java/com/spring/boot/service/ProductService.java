package com.spring.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.model.Products;
import com.spring.boot.repository.ProductRepository;

@Component
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Products addProduct(Products pr)
	{
		Products result = productRepository.save(pr);
		return result;
	}
	
	public List<Products> getAllProducts()
	{
		List<Products> list = (List<Products>) productRepository.findAll();
		return list;
	}
	
	public Optional<Products> getProductById(int id)
	{
		Optional<Products> product = null;
		
		try
		{
			product = productRepository.findById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return product;
		
	}
	
	
	public void deleteProduct(int pid)
	{
		productRepository.deleteById(pid);
	}
	
	public void updateProduct(Products product, int prId)
	{
		product.setProductId(prId);
		productRepository.save(product);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
