package com.fei.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fei.dao.BuyerDAO;
import com.fei.dao.ProductDAO;
import com.fei.dao.SellerDAO;
import com.fei.pojo.Buyer;
import com.fei.pojo.Cart;
import com.fei.pojo.OrderItem;
import com.fei.pojo.Product;

@Controller
@RequestMapping(value="/addToCart.htm")
public class AddToCartController {

	
	@Autowired
	@Qualifier("buyerDAO")
	BuyerDAO buyerDAO;
	
	@Autowired
	@Qualifier("sellerDAO")
	SellerDAO sellerDAO;
	
	@Autowired
	@Qualifier("productDAO")
	ProductDAO productDAO;
	
	@RequestMapping(method=RequestMethod.POST)
	public String doService( HttpServletRequest request, HttpServletResponse response) throws Exception {
		//get buyer from session
		HttpSession session = request.getSession(false);
		Buyer buyer = (Buyer) session.getAttribute("buyer");
		if(buyer==null){
			return "signin";
		}
		//get product from request product id
	   int 	productid= Integer.parseInt(request.getParameter("productid")) ;
	   Product product = productDAO.getProductById(productid);
		//get number from request
	   int quantity =Integer.parseInt(request.getParameter("quantity"));
	   
		//create orderitem
	   OrderItem oi = new OrderItem(product,quantity);
		//add to buyer's cart
	   Cart cart = new Cart();
	   buyer.setCart(cart);
	   cart.getCartlist().add(oi);
	   buyerDAO.save(buyer);;
	   

		//go to check out
		return "Checkout";
	}
	
		
	@RequestMapping(method=RequestMethod.GET)
	public String initializeForm(HttpServletRequest request, HttpServletResponse response) { 
		   return "BrowseProducts"; 
		 }
}
