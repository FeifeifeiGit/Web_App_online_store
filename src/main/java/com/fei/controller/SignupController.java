package com.fei.controller;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.fei.pojo.Buyer;
import com.fei.dao.BuyerDAO;
import com.fei.controller.SignupValidator;


@Controller
@RequestMapping(value = "/buyersignup.htm")
public class SignupController {
	@Autowired
	@Qualifier("signupValidator")
	SignupValidator signupValidator;
	
	@Autowired
	@Qualifier("buyerDAO")
	BuyerDAO buyerDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(signupValidator);
	}
	
	@RequestMapping( method=RequestMethod.POST)
	public String doService(@ModelAttribute("buyer")Buyer buyer,BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		signupValidator.validate(buyer, result);
		if(result.hasErrors())
		{
			return "buyersignup";
		}
		
		String city = buyer.getCity();
		String street = buyer.getStreet();
		String postcode = buyer.getPostcode();
 		Address address = new Address();
 		address.setCity(city);
 		address.setStreet(street);
 		address.setPostcode(postcode);
 		buyer.setAddress(address);
 		
		try{
	     	buyerDAO.create(buyer);
		}
		catch(AdException e) {
			 System.out.println(e.getMessage());
        }
		return "buyersignupcomplete";
	 }
	


	@RequestMapping(method=RequestMethod.GET)
	public String initializeForm(@ModelAttribute("buyer")Buyer buyer, BindingResult result) { 
	
	    return "buyersignup"; 
	}
	
}
