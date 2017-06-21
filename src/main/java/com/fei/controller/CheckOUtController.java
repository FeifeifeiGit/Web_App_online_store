package com.fei.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fei.dao.BuyerDAO;
import com.fei.dao.SellerDAO;
import com.fei.pojo.Buyer;
import com.fei.pojo.Order;
import com.fei.pojo.OrderItem;
import com.fei.pojo.Product;
import com.fei.pojo.Seller;

@Controller
@RequestMapping(value="/checkout.htm")
public class CheckOUtController {

	
	@Autowired
	@Qualifier("buyerDAO")
	BuyerDAO buyerDAO;
	
	@Autowired
	@Qualifier("sellerDAO")
	SellerDAO sellerDAO;
	
	@RequestMapping(method=RequestMethod.POST)
	public String doService( HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//get buyer
		HttpSession session = request.getSession(false);
		Buyer buyer = (Buyer) session.getAttribute("buyer");
		if(buyer==null){
			return "signin";
		}
	  //create order ,set orderitems =buyer's cartlist ,
		Order order = new Order();
		//get buyer's name from session, set to order's buyerername
		String buyername = buyer.getUsername();
		//get seller's name from sessionScope. set to order's sellername
		int productid = buyer.getCart().getCartlist().iterator().next().getProduct().getProductid();
		Seller seller = sellerDAO.getSellerByProductID(productid);
		String sellername = seller.getUsername();
		//set  order date
		Date date = new Date();
		order.setBuyername(buyername);
		order.setSellername(sellername);
		order.setOrderitems(buyer.getCart().getCartlist());
		order.setDate(date);
		session.setAttribute("currentorder", order);
		//add this order into buyer's orderhistory
		buyer.getBuyerorderHistory().add(order);
		seller.getSellerorderHistory().add(order);
		//update product quantity= new quantity
				for(OrderItem oi: buyer.getCart().getCartlist()){
					for(Product p: seller.getProductcatalog()){
						if(oi.getProduct().getProductid()==p.getProductid()){
							p.setQuantity(p.getQuantity()-oi.getQuantity());
						}
					}
				}
		sellerDAO.save(seller);
		//clear buyer's cart
		//buyer.clearCart();
		//<OrderItem>
		buyer.setCart(null);
		buyerDAO.save(buyer);
		
		//return to view orderhistory.
		return "ReviewOrder";
	}
	
		
	@RequestMapping(method=RequestMethod.GET)
	public String initializeForm(HttpServletRequest request, HttpServletResponse response) { 
		   return "Checkout"; 
		 }
}
