package com.spring.boot.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.model.Products;
import com.spring.boot.model.PurchaseReport;
import com.spring.boot.model.User;
import com.spring.boot.service.ProductService;
import com.spring.boot.service.PurchaseReportService;
import com.spring.boot.service.UserService;

@RestController
@RequestMapping("/user")
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PurchaseReportService purchaseReportService;
	
	/*
	 * this handler method is used to register the user
	 */
	
	@PostMapping("/register")
	public ResponseEntity<Optional<User>> register(@RequestBody User usr)
	{
		User result = null;
		try
		{
			result = this.userService.addUser(usr);
			
			return ResponseEntity.ok(Optional.of(result));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	/*
	 * this handler method is used to get product
	 */	
	
	@GetMapping("/getProducts")
	public  ResponseEntity<List<Products>> getProducts()
	{
		List<Products> list = productService.getAllProducts();
		if(list.size()<= 0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	/*
	 * this handler method is used to purchase the product
	 */
	@PostMapping("/purchaseProduct")
	public ResponseEntity<Optional<PurchaseReport>> purchaseProduct(@RequestBody PurchaseReport prs)
	{
		PurchaseReport result = null;
		try
		{
			result = this.purchaseReportService.addPurchaseReport(prs);
			return ResponseEntity.ok(Optional.of(result));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
			
		return ResponseEntity.ok(Optional.of(result));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
