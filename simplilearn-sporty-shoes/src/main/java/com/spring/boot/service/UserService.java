package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.model.Products;
import com.spring.boot.model.User;
import com.spring.boot.repository.ProductRepository;
import com.spring.boot.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public User addUser(User usr)
	{
		User result = userRepository.save(usr);
		return result;
	}
	
	public List<Products> getAllProducts()
	{
		List<Products> list = (List<Products>) productRepository.findAll();
		return list;
	}
	
	public List<User> getAllUsers()
	{
		List<User> list = (List<User>) userRepository.findAll();
		return list;
	}

}
