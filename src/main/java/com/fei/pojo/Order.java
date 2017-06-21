package com.fei.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="OrderTable")
public class Order {
	@Id
	@Column(name="orderid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	
	@Column
	private Date date;
	
	@Column
	private String buyername;
	
	@Column
	private String sellername;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=false)
	@JoinColumn(name="Order_ID")
	private Set<OrderItem> orderitems = new HashSet<OrderItem>();
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getBuyername() {
		return buyername;
	}

	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public void setOrderitems(Set<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}

	public Set<OrderItem> getOrderitems() {
		return orderitems;
	}

	public int getOrderid() {
		return orderid;
	}



	

	
}
