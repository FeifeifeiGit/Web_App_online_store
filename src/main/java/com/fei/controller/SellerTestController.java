package com.fei.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.fei.dao.SellerDAO;


@Controller
@RequestMapping(value="/testseller.htm")
public class SellerTestController {

	@Autowired
	@Qualifier("sellerDAO")
	SellerDAO sellerDAO;
	
	@RequestMapping(method=RequestMethod.POST)
	public void doService( HttpServletRequest request, HttpServletResponse response) throws Exception {
		String action = request.getParameter("action");
		if(action.equals("nameCheck")) {
                PrintWriter out = response.getWriter();
          if(sellerDAO.userExists(request.getParameter("username"))){
              
            //  JSONObject obj = new JSONObject();
             //  obj.put("message","Username already exists");
               out.println("Username already exists");  
              
           }else{
        	   out.println("Username is available");
           }
		}else if(action.equals("emailCheck")) {
            PrintWriter out = response.getWriter();
      if(sellerDAO.emailExists(request.getParameter("email"))){
          
        //  JSONObject obj = new JSONObject();
         //  obj.put("message","Username already exists");
           out.println("Email alrady exists");  
          
       }else{
    	   out.println("Email is available");
       }
     
	}
	}
	
}
