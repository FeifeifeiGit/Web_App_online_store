package com.fei.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fei.dao.ProductDAO;
import com.fei.dao.SellerDAO;
import com.fei.pojo.Product;
import com.fei.pojo.Seller;

/**
 * Handles requests for the application file upload requests
 */
@Controller
@RequestMapping(value ="/uploadFile.htm")
public class FileUploadController {

	@Autowired
	@Qualifier("sellerDAO")
	SellerDAO sellerDAO;
	
	@Autowired
	@Qualifier("productDAO")
	ProductDAO productDAO;
	
	@Autowired
	ServletContext servletContext ;

	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
void uploadFileHandler(@RequestParam(value="category", required=false) String category, @RequestParam(value="name",required=false ) String name,
			@RequestParam(value="quantity", required=false) String temquantity,  @RequestParam(value="brand" , required=false) String brand, 
			@RequestParam(value="price" , required=false) String temprice, @RequestParam(value="description", required=false) String description,
			 @RequestParam(value="file" , required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response)throws Exception {

		//ModelAndView
	if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
			//	String rootPath = System.getProperty("catalina.home");
			//	String	rootPath =	servletContext.getRealPath("/"); 
				String	rootPath ="/Users/chaoliu/Documents/workspace-sts-3.7.3.RELEASE/FinalProject/src/main/webapp/resources";
				File dir = new File(rootPath + File.separator + "image");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator +  name + ".jpg");
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

			
				String photopath = "/resources" +File.separator + "image" + File.separator +  name + ".jpg";
				int quantity = Integer.parseInt(temquantity);
				double price = Double.parseDouble(temprice);
				//save to product 
			//	Product newProduct=productDAO.create(name, category, quantity, brand, price, description, photopath);
				//add to seller's catalog
			    HttpSession session = request.getSession(false);
			    Product product= new Product(name, category, quantity, brand, price, description, photopath);
				Seller seller = (Seller) session.getAttribute("seller");	
				seller.addProduct(product);
				sellerDAO.save(seller);
				
				logger.info("You successfully uploaded file=" + name);
				//retrieve all product belongs to this seller
				//String sellername= seller.getUsername();
				RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/views/SellerCatalog.jsp");
                rd.forward(request, response); 
				//return "added";
				//response.sendRedirect("WEB-INF/views/SellerCatalog.jsp");
				
			} catch (Exception e) {
				//return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			//return "signin";
		}
	}
	@RequestMapping(method=RequestMethod.GET)
	public String initializeForm(HttpServletRequest request, HttpServletResponse response) { 
	    return "SellerView"; 
	    }
	
}
