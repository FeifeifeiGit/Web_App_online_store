package com.fei.pojo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="SellerTable")
@PrimaryKeyJoinColumn(name="userid")
public class Seller extends User {
//	@Id: subclass should not have its own id
	@Column(name="sellerid")
	private int sellerId;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="Seller_ID")
	private Set<Order> sellerorderHistory= new HashSet<Order>();
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Address address;
	
	@Transient
	private String city;
	@Transient
	private String street;
	@Transient
	private String postcode;
	
	//profile: view email, address, change 
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="Seller_ID")
    private Set<Product> productcatalog = new HashSet<Product>();
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="Seller_ID")
	private Set<FeedBack> feedback = new HashSet<FeedBack>();

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
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



	public Set<Product> getProductcatalog() {
		return productcatalog;
	}

	public void setProductcatalog(Set<Product> productcatalog) {
		this.productcatalog = productcatalog;
	}

	public Set<FeedBack> getFeedback() {
		return feedback;
	}

	public void setFeedback(Set<FeedBack> feedback) {
		this.feedback = feedback;
	}

   public void addProduct(Product p){
	  this.getProductcatalog().add(p);

   }
   
   public void removeProduct(int productid){
	   Iterator<Product> iterator = productcatalog.iterator();
	   while(iterator.hasNext()){
		   if(iterator.next().getProductid()==productid){
			   iterator.remove();
			   break;
		   }
	   }
  }

public Set<Order> getSellerorderHistory() {
	return sellerorderHistory;
}

public void setSellerorderHistory(Set<Order> sellerorderHistory) {
	this.sellerorderHistory = sellerorderHistory;
}
	
}
