package com.ust.pms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.pms.model.Cart;
import com.ust.pms.model.Product;
import com.ust.pms.service.ProductService;

@RestController
@RequestMapping("cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

	
	
	@Autowired
	ProductService productService;

	List<Product> products = new ArrayList<Product>();
	
	List<Cart> carts = new ArrayList<Cart>();

	// Getting All the products
	@GetMapping()
	public ResponseEntity<List<Product>> getProducts() {
		carts = productService.getCarts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	// Saving the product
	@PostMapping()
	public ResponseEntity<String> saveProduct(@RequestBody Cart cart) {
		System.out.println("Have entered into the cart details"+cart);
		productService.saveCart(cart);
		return new ResponseEntity<String>("Record Saved Successfully", HttpStatus.OK);
	}

	// Getting a single product
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") Integer productId) {
		System.out.println("Product id called");
		if (productService.isProductExists(productId)) {
			Product product = productService.getProduct(productId);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
	}

	// delete
	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") Integer productId) {
System.out.println( "Delete controller");
		if (productService.isProductExists(productId)) {
			productService.deleteProduct(productId);
			return new ResponseEntity<String>("Deleted Ok", HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Deleted not ", HttpStatus.NO_CONTENT);

		}
	}

	// update
	@PutMapping()
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {

		if (productService.isProductExists(product.getProductId())) {
			productService.updateProduct(product);
			return new ResponseEntity<String>("Updated Ok", HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Updated failed ", HttpStatus.NO_CONTENT);

		}
	}
	
	
	
	//Return all the product with the productName
	// Getting a single product
		@GetMapping("/searchProduct/{productName}")
		public ResponseEntity<List<Product>> getProductByName(@PathVariable("productName") String productName) {
			System.out.println("Product name called");
				List<Product> filteredProducts = productService.getProductByName(productName);
				return new ResponseEntity<List<Product>>(filteredProducts, HttpStatus.OK);
		}
}
