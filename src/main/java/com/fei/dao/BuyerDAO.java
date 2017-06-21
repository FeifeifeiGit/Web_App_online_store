package com.fei.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.fei.exception.AdException;
import com.fei.pojo.Address;
import com.fei.pojo.Buyer;
import com.fei.pojo.Order;
import com.fei.pojo.Seller;
import com.fei.pojo.User;



public class BuyerDAO extends DAO {
    public Buyer create(Buyer buyer)
            throws AdException {
        try {
            begin();
            System.out.println("inside BuyerDAO");
            getSession().save(buyer);
            commit();
            return buyer;
        } catch (HibernateException e) {
            rollback();
           
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
    public void delete(Buyer buyer)
            throws AdException {
        try {
            begin();
            getSession().delete(buyer);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + buyer.getFirstname() + buyer.getLastname(), e);
        }finally {
        	close();
        }
    }
    
    public Buyer verify(String  username, String pwd) throws AdException {
        try {
        	@SuppressWarnings("deprecation")
			Criteria crit = getSession().createCriteria(Buyer.class);
        	crit.add(Restrictions.eq("username", username));
        	crit.add(Restrictions.eq("password", pwd));
        	Buyer buyer = (Buyer) crit.uniqueResult();
        	return buyer;
        } catch (HibernateException e) {;
            
            throw new AdException("no buyer found", e);
        }finally {
        	close();
        }
        
    }
    
    public boolean userExists(String username) throws AdException{
    	 try {
         	@SuppressWarnings("deprecation")
 			Criteria crit = getSession().createCriteria(User.class);
         	crit.add(Restrictions.eq("username", username));
         	List<User> results = crit.list();
         	if(results.size()!=0){
         	return true;
         	}else 
         	return false;
         } catch (HibernateException e) {;
             
             throw new AdException("no buyer found", e);
         }finally {
         	close();
         }
    }
    
    public boolean emailExists(String email) throws AdException{
   	 try {
        	@SuppressWarnings("deprecation")
			Criteria crit = getSession().createCriteria(User.class);
        	crit.add(Restrictions.eq("email", email));
        	List<User> results = crit.list();
        	if(results.size()!=0){
        	return true;
        	}else 
        	return false;
        } catch (HibernateException e) {;
            
            throw new AdException("no buyer found", e);
        }finally {
        	close();
        }
   }
    public void save(Buyer buyer) throws AdException {
        try {
            begin();
            getSession().update(buyer);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not save the buyer", e);
        }finally {
        	close();
        }
    }
    
   
}
