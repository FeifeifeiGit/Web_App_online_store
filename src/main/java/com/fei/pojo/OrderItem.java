package com.fei.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OderItemTable")
public class OrderItem {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderitemid;
	
	@ManyToOne
	@JoinColumn(name="Product_ID")
	private Product product;
	
	@Column
	private int quantity;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public OrderItem(){
		
	}
	public OrderItem(Product product, int quantity){
		this.product = product;
		this.quantity = quantity;

	}
	
}
