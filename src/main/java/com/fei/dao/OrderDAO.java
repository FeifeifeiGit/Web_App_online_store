package com.fei.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.fei.exception.AdException;
import com.fei.pojo.Order;


public class OrderDAO extends DAO {

	
	 public List<Order> getBuyerOrderHistory(String username) throws AdException{
	    	try {
	        	
				Criteria crit = getSession().createCriteria(Order.class);
	        	crit.add(Restrictions.eq("buyername", username));
	        
	        	List<Order> orderhistoory = crit.list();
	        	return orderhistoory;
	        	} catch (HibernateException e) {;
	            
	            throw new AdException("no OrderHistory found", e);
	        }finally {
	        	close();
	        }
	    }
	 public List<Order> getSellererOrderHistory(String username) throws AdException{
	    	try {
	        	
				Criteria crit = getSession().createCriteria(Order.class);
	        	crit.add(Restrictions.eq("sellername", username));
	        
	        	List<Order> orderhistoory = crit.list();
	        	return orderhistoory;
	        	} catch (HibernateException e) {;
	            
	            throw new AdException("no OrderHistory found", e);
	        }finally {
	        	close();
	        }
	    }    
}
