package com.fei.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fei.pojo.Buyer;



	@Component
	public class SignupValidator implements Validator {

	    public boolean supports(Class aClass)
	    {
	        return aClass.equals(Buyer.class) ;
	    }

	    public void validate(Object obj, Errors errors)
	    {
	    	Buyer buyer = (Buyer) obj;
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.invalid.user", "First Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.invalid.user", "Last Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "password Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "email Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.city", "city Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "error.invalid.street", "street Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postcode", "error.invalid.postcode", "postcode Required");
	    }
	}

