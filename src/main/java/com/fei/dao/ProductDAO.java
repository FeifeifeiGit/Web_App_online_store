package com.fei.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.fei.exception.AdException;
import com.fei.pojo.Product;




public class ProductDAO extends DAO {
    public Product create(String name ,String category, int quantity, String brand, double price,
			String description, String  photopath)
            throws AdException {
        try {
            begin();
            System.out.println("inside ProductDAO");
            Product product = new Product( name ,category, quantity, brand, price,
            		description, photopath);
            getSession().save(product);
            commit();
        return product;
        } catch (HibernateException e) {
            rollback();
           
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
    public void delete(Product product)
            throws AdException {
        try {
            begin();
            getSession().delete(product);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete product " + product.getName(), e);
        }
    }
    
    public List<Product> browseByPriceAsc(){
    	
		Criteria crit = getSession().createCriteria(Product.class);
   	 	crit.addOrder(Order.asc("price"));
   	 	List<Product> productlist = crit.list();
   	 	return productlist;
    }
    
    public List<Product> browseByPriceDesc(){
    	
		Criteria crit = getSession().createCriteria(Product.class);
   	 	crit.addOrder(Order.desc("price"));
   	 	List<Product> productlist = crit.list();
   	 	return productlist;
    }
    
   public List<Product> browseByBrand(String brand){
	   
		Criteria crit = getSession().createCriteria(Product.class);
   		crit.add(Restrictions.eq("brand", brand));
   		List<Product> productlist = crit.list();
   		return productlist;
    }
   
   public  List<Product> browseByName(String name){
	  
		Criteria crit = getSession().createCriteria(Product.class);
  		crit.add(Restrictions.like("name", "%"+name+"%"));
  		List<Product> productlist = crit.list();
  		return productlist;
   }
   
   public List<Product> getAllProduct() throws AdException {
	   Product product = null;
		try {
			begin();
			Query query = getSession().getNamedQuery("findAll");
			System.out.println(query.list().size());
			List<Product> productlist= query.list();
			commit();
			return productlist;
			
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get the category", e);
		} finally {
			close();
		}
   }
   
   public Product getProductById(int id){
   Criteria crit = getSession().createCriteria(Product.class);
		crit.add(Restrictions.eq("productid", id));
		Product product = (Product) crit.uniqueResult();
		return product;
    }
   
}   

