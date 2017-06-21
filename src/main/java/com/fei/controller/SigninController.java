package com.fei.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
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
import com.fei.pojo.Seller;

@Controller
public class SigninController {

	@Autowired
	@Qualifier("buyerDAO")
	BuyerDAO buyerDAO;
	
	@Autowired
	@Qualifier("sellerDAO")
	SellerDAO sellerDAO;
	
	
	@Autowired
	@Qualifier("productDAO")
	ProductDAO productDAO;
	
	
	@RequestMapping(value = "/signin.htm", method=RequestMethod.POST)
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session= request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String requestrole = request.getParameter("role");
        String remember = request.getParameter("rememberMe");
        
        if(remember!=null && remember.equalsIgnoreCase("rememberMe")){
    		Cookie userCookie = new Cookie("userName",request.getParameter("userName"));
            Cookie passwordCookie = new Cookie("password",request.getParameter("password"));
            response.addCookie(userCookie);
            response.addCookie(passwordCookie);
    		}
        
        if(requestrole.equalsIgnoreCase("buyer")){
        	Buyer buyer = buyerDAO.verify(username, password);
        	if(buyer !=null){
        		session.setAttribute("username", username);
        		session.setAttribute("buyer", buyer);
        		session.setAttribute("role", "buyer");
        		
        		
                RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/views/BuyerView.jsp");
                rd.forward(request, response);  
        	}else{
        		RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/views/signin.jsp?error=true");
                rd.forward(request, response); 
        	}
        }else if (requestrole.equalsIgnoreCase("seller")){
        	Seller seller = sellerDAO.verify(username, password);
        	if(seller !=null){
        		session.setAttribute("username", username);
        		session.setAttribute("seller", seller);
        		session.setAttribute("role", "seller");
                RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/views/SellerView.jsp");
                rd.forward(request, response);  
                }
        	else{
        		RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/views/signin.jsp?error=true");
                rd.forward(request, response); 
        	}
        }
        
	}
	
	@RequestMapping( value ="/signin.htm", method=RequestMethod.GET)
	public void initSignin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session= request.getSession(false);
		String role = (String) session.getAttribute("role");
		if(role!=null){
        // if session already exists than redirect to user view
        if(session.getAttribute("username")!=null){
        	if(role.equalsIgnoreCase("seller")){
        		RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/views/SellerView.jsp");
                rd.forward(request, response); 
        		}else if (role.equalsIgnoreCase("buyer")){
	        		RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/views/BuyerView.jsp");
	                rd.forward(request, response); 
	        		}
        	}
		}
		else{
        	//response.sendRedirect("WEB-INF/views/signin.jsp");
     	   RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/views/signin.jsp");
           rd.forward(request, response); 
        }
	 
	}
	
	@RequestMapping( value="signincheck.htm",method=RequestMethod.GET)
	public void check(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
	 String	requestRole = request.getParameter("requestRole");
	 PrintWriter out = response.getWriter();
     if(requestRole==null){
         
       //  JSONObject obj = new JSONObject();
        //  obj.put("message","Username already exists");
          out.println("You must choose one role");  
     }
		
	}
	
}
