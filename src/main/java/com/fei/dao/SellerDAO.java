package com.fei.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.fei.exception.AdException;
import com.fei.pojo.Buyer;
import com.fei.pojo.Seller;
import com.fei.pojo.User;

public class SellerDAO extends DAO {

	public Seller create(Seller seller)
            throws AdException {
        try {
            begin();
            System.out.println("inside SellerDAO");
           
           getSession().save(seller);
            
            commit();
            return seller;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(Seller seller)
            throws AdException {
        try {
            begin();
            getSession().delete(seller);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + seller.getFirstname() + seller.getLastname(), e);
        }
    }
    public Seller verify(String  username, String pwd)
            throws AdException {
        try {
        	Criteria crit = getSession().createCriteria(Seller.class);
        	crit.add(Restrictions.eq("username", username));
        	crit.add(Restrictions.eq("password", pwd));
        	Seller seller = (Seller) crit.uniqueResult();
        	return seller;
        } catch (HibernateException e) {
            
            throw new AdException("no seller found", e);
        } finally {
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
            
            throw new AdException("no seller found", e);
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
           
           throw new AdException("no seller found", e);
       }
  }
   
   public void save(Seller seller) throws AdException {
       try {
           begin();
           getSession().update(seller);
           commit();
       } catch (HibernateException e) {
           rollback();
           throw new AdException("Could not save the category", e);
       }finally {
       	close();
       }
   }
   
   public Seller getSellerByProductID(int id) throws AdException {
	     try {
	    	 @SuppressWarnings("deprecation")
			Criteria crit = getSession().createCriteria(Seller.class);
	    	 Criteria proCrit =  crit.createCriteria("productcatalog");
	    	 proCrit.add(Restrictions.eq("productid", id));
	         Seller seller = (Seller) crit.uniqueResult();
	         return seller;
	       } catch (HibernateException e) {
	          
	           throw new AdException("Could not save the category", e);
	       }finally {
	       	close();
	       }
   }
}
