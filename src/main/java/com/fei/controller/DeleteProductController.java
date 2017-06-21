package com.fei.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fei.dao.SellerDAO;
import com.fei.exception.AdException;
import com.fei.pojo.Seller;

@Controller
@RequestMapping(value="/deleteProduct.htm")
public class DeleteProductController {
 
	@Autowired
	@Qualifier("sellerDAO")
	SellerDAO sellerDAO;
	
	@RequestMapping(method=RequestMethod.POST)
	public void initializeForm(HttpServletRequest request, HttpServletResponse response) { 
		
		int productid = Integer.parseInt(request.getParameter("productid"));
		HttpSession session = request.getSession(false);
			Seller seller =(Seller)	session.getAttribute("seller");
			seller.removeProduct(productid);
			try {
				sellerDAO.save(seller);
			} catch (AdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    try {
			response.sendRedirect("SellerCatalog.htm");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
}
