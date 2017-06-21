package com.fei.pojo;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CartTable")
public class Cart {
	@Id
	@Column(name="cartid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartid;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=false)
	@JoinColumn(name="Cart_ID")
	private Set<OrderItem> cartlist = new HashSet<OrderItem>();

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public Set<OrderItem> getCartlist() {
		return cartlist;
	}

	public void setCartlist(Set<OrderItem> cartlist) {
		this.cartlist = cartlist;
	}

	  
	
	
}
