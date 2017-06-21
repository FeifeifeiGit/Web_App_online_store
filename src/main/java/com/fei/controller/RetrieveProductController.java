package com.fei.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fei.dao.ProductDAO;
import com.fei.exception.AdException;
import com.fei.pojo.Product;


@Controller
public class RetrieveProductController {

	
	@Autowired
	@Qualifier("productDAO")
	ProductDAO productDAO;
	
	
	@RequestMapping(value = "/viewByName.htm", method=RequestMethod.POST)
	public String  doSearch(HttpServletRequest request, HttpServletResponse response) throws AdException{
		String produtname = request.getParameter("nameSearch");
		List<Product> products= productDAO.browseByName(produtname);
		HttpSession session = request.getSession();
		session.setAttribute("products", products);
		return "BrowseProducts";
	}
	
	
	@RequestMapping(value = "/viewByBrand.htm", method=RequestMethod.GET)
	public String  viewBrand(HttpServletRequest request, HttpServletResponse response) throws AdException{
		String tembrand = request.getParameter("brand");
		List<Product> products= new ArrayList<Product>();
		
		if(tembrand.equals("Drybar")){
			 products= productDAO.browseByBrand("Drybar");
		}else if (tembrand.equals("BumbleAndBumble")){
			products= productDAO.browseByBrand("Bumble and Bumble");
		}
		else if (tembrand.equals("Phyto")){
			 products= productDAO.browseByBrand("Phyto");
		}else if(tembrand.equals("LivingProof")){
			 products= productDAO.browseByBrand("Living Proof");
		}
		HttpSession session = request.getSession();
		session.setAttribute("products", products);
		return "BrowseProducts";
	}
	
	@RequestMapping(value = "/viewAll.htm", method=RequestMethod.POST)
	public String  viewall(HttpServletRequest request, HttpServletResponse response) throws AdException{
		List<Product> products= productDAO.getAllProduct();
		HttpSession session = request.getSession();
		session.setAttribute("products", products);
		return "BrowseProducts";
	}
	
	@RequestMapping(value = "/orderByPrice.htm", method=RequestMethod.POST)
 public String  orderByPrice(HttpServletRequest request, HttpServletResponse response) throws AdException{
		String order = request.getParameter("priceOrder");
		HttpSession session = request.getSession();
		List<Product> products = new ArrayList<Product>();
		if(session.getAttribute("products")==null){
			products= productDAO.getAllProduct();
			session.setAttribute("products", products);
		}else{
			products=(List<Product>) session.getAttribute("products");
		}
		if(order.equals("ASC")){
			Collections.sort(products);
		}else if (order.equals("DESC")){
			Collections.sort(products);
			Collections.reverse(products);
			session.setAttribute("products", products);
		}
		
		
		
		return "BrowseProducts";
	}
}
