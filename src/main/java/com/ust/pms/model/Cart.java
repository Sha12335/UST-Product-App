package com.ust.pms.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	private int productId;
	private String productName;
	private int quantityOnHand;
	private int price;
	
	
	public Cart() {
		
	}


	public Cart(int cartId, int productId, String productName, int quantityOnHand, int price) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.productName = productName;
		this.quantityOnHand = quantityOnHand;
		this.price = price;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productId=" + productId + ", productName=" + productName
				+ ", quantityOnHand=" + quantityOnHand + ", price=" + price + "]";
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getQuantityOnHand() {
		return quantityOnHand;
	}


	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	

}
