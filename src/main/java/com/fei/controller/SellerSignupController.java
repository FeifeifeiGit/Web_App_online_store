package com.fei.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fei.exception.AdException;
import com.fei.pojo.Address;
import com.fei.pojo.Seller;
import com.fei.dao.SellerDAO;


@Controller
@RequestMapping(value = "/sellersignup.htm")
public class SellerSignupController {
	@Autowired
	@Qualifier("sellersignupValidator")
	SellerSignupValidator sellersignupValidator;
	
	@Autowired
	@Qualifier("sellerDAO")
	SellerDAO sellerDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(sellersignupValidator);
	}
	///////------------------------------------------seller controller
	
	@RequestMapping( method=RequestMethod.POST)
	public String doService(@ModelAttribute("seller")Seller seller,BindingResult result) throws Exception {
		sellersignupValidator.validate(seller, result);
		if(result.hasErrors())
		{
			return "sellersignup";
		}
		
		String city = seller.getCity();
		String street = seller.getStreet();
		String postcode = seller.getPostcode();
 		Address address = new Address();
 		address.setCity(city);
 		address.setStreet(street);
 		address.setPostcode(postcode);
 		seller.setAddress(address);
 		
		try{
	     	sellerDAO.create(seller);
		}
		catch(AdException e) {
			 System.out.println(e.getMessage());
        }
		return "sellersignupcomplete";
	}


	@RequestMapping(value = "/sellersignup.htm",method=RequestMethod.GET)
	public String initializeForm(@ModelAttribute("seller")Seller seller, BindingResult result) { 
	    return "sellersignup"; 
	    }

}
