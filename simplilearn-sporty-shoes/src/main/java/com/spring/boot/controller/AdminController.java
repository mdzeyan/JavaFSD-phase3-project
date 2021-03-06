package com.spring.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.model.User;
import com.spring.boot.model.Products;
import com.spring.boot.model.PurchaseReport;
import com.spring.boot.service.ProductService;
import com.spring.boot.service.PurchaseReportService;
import com.spring.boot.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PurchaseReportService purchaseReportService;
	
	@Autowired
	private UserService userService;
	
	
	/*
	 * this handler method is used to save the product
	 */
	@PostMapping("/saveProduct")
	public ResponseEntity<Optional<Products>> saveProduct(@RequestBody Products pr)
	{
		Products result = null;
		try
		{
			result = productService.addProduct(pr);
			
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
	 * this handler method is used to get product by Id
	 */
	
	@GetMapping("/getProductsById/{id}")
	public ResponseEntity<Optional<Products>> getProductsById(@PathVariable("id") int id)
	{
		Optional<Products> product = productService.getProductById(id);
		
		if(product == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(product));
	}
	
	/*
	 * this handler method is used to delete a product
	 */
	
	@DeleteMapping("/deleteProduct/{prId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("prId") int prId)
	{
		try
		{
			this.productService.deleteProduct(prId);
			return ResponseEntity.ok().build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	/*
	 * this handler method is used to update a product
	 */
	
	@PutMapping("/updateProduct/{prId}")
	public ResponseEntity<Products> updateProduct(@RequestBody Products product, @PathVariable("prId") int prId)
	{
		try
		{
			this.productService.updateProduct(product, prId);
			return ResponseEntity.ok().body(product);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	/*
	 * this handler method is used to get purchase report
	 */
	@GetMapping("/getPurchaseReport")
	public  ResponseEntity<List<PurchaseReport>> getPurchaseReport()
	{
		List<PurchaseReport> list = purchaseReportService.getAllPurchaseReport();
		if(list.size()<= 0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	/*
	 * this handler method is used to get all users
	 */
	@GetMapping("/getUsers")
	public  ResponseEntity<List<User>> getUsers()
	{
		List<User> list = this.userService.getAllUsers();
		if(list.size()<= 0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	
	
	
	

}
