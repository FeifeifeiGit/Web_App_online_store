package com.fei.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="BuyerTable")
@PrimaryKeyJoinColumn(name="userid")
public class Buyer extends User {
//	@Id: subclass sould not have its own id
	@Column(name="buyerid")
	
	private int buyerId;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="Buyer_ID")
	private Set<Order> buyerorderHistory= new HashSet<Order>();
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="Buyer_Cart", joinColumns=@JoinColumn(name="Buyer_ID"),
			inverseJoinColumns=
            @JoinColumn(name="Cart_ID"))
	private Cart cart ;
	//private Set<OrderItem> cart = new  HashSet<OrderItem>();
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Address address;
	
	@Transient
	private String city;
	@Transient
	private String street;
	@Transient
	private String postcode;
	
	//profile: view email, address, change 

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}


	public Set<Order> getBuyerorderHistory() {
		return buyerorderHistory;
	}

	public void setBuyerorderHistory(Set<Order> buyerorderHistory) {
		this.buyerorderHistory = buyerorderHistory;
	}

	

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	

	 public void clearCart(){ 
		   this.getCart().getCartlist().clear();
		
		   }
}
