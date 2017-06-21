package com.fei.pojo;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;



@NamedNativeQueries({
	@NamedNativeQuery(
			name = "findAll",
			query = "from Product",
			resultClass = Product.class
)		        
})
@Entity
@Table(name="ProductTable")
public class Product implements Comparable<Product>  {
	@Id
	@Column(name="productid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productid;
	@Column
	private String category;
	@Column
	private int quantity;
	@Column
	private String brand;
	
	@Column
	private String name;
	
	@Column
	private double price;
	
	@Column
	private String description;
	
	@Column
	private String photopath;
	
	@Transient
	private MultipartFile photo; // Use by Data Binder
	public Product(){
		
	}
	
	
	public Product(String name ,String category, int quantity, String brand, double price,
			String description, String  photopath) {
		
		this.category = category;
		this.quantity = quantity;
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.description = description;
		this.photopath = photopath;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getPhotopath() {
		return photopath;
	}


	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}


	public MultipartFile getPhoto() {
		return photo;
	}


	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}


	@Override
	public int compareTo(Product o) {
		
		return (int) (price - o.getPrice());
	}


	
	
}
