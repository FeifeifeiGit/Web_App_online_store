package com.fei.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fei.pojo.Seller;

@Controller
@RequestMapping(value="/SellerCatalog.htm")
public class SellerCatalogController {

	@RequestMapping(method=RequestMethod.POST)
	public String doService(@ModelAttribute("seller")Seller seller, BindingResult result) { 
	    return "sellersignup"; 
	    }
	
	@RequestMapping(method=RequestMethod.GET)
	public String initializeForm(HttpServletRequest request, HttpServletResponse response) { 
	    return "SellerCatalog"; 
	    }
}
