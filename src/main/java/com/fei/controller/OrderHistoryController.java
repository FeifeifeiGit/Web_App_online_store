package com.fei.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.fei.dao.OrderDAO;
import com.fei.exception.AdException;
import com.fei.pojo.Buyer;
import com.fei.pojo.Order;
import com.fei.pojo.Seller;

@Controller
@RequestMapping(value="/viewOrderHistory.htm")
public class OrderHistoryController {

	@Autowired
	@Qualifier("orderDAO")
	OrderDAO orderDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String initializeForm(HttpServletRequest request, HttpServletResponse response) throws AdException { 
		
		HttpSession session = request.getSession(false);
		
		if(session==null){
			return "signin";
		}else if (session.getAttribute("buyer")!=null){
			Buyer buyer = (Buyer) session.getAttribute("buyer");
			String namematch = buyer.getUsername();
			List<Order> orderHistory = orderDAO.getBuyerOrderHistory(namematch);
			session.setAttribute("orderHistory",orderHistory );
			return "BuyerOrderHistory";
		}else if (session.getAttribute("seller")!=null){
			Seller seller = (Seller) session.getAttribute("seller");
			String namematch = seller.getUsername();
			List<Order> orderHistory = orderDAO.getSellererOrderHistory(namematch);
			session.setAttribute("orderHistory",orderHistory );
			return "SellerOrderHistory";
		}
		
		   return "signin"; 
		 }
}
