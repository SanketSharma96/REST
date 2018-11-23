package com.user.controller;





import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.user.dto.CombinedModel;
import com.user.dto.CustomerDto;
import com.user.dto.LoginModel;
import com.user.dto.ProductDto;
import com.user.dto.pDto;
import com.user.service.LoginService;
import com.user.service.ProductService;
import com.user.service.RegisterService;


@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private ProductService productService;
	
	
	
	@RequestMapping(value="login.html",method=RequestMethod.POST)
	@ResponseBody
	public CustomerDto validateUser(@RequestBody LoginModel loginModel,HttpSession session) {
		
		
		CustomerDto customer = loginService.isValidCustomer(loginModel.getEmail(),loginModel.getPassword());

		
		return customer;
		
		}
	
	@RequestMapping(value="register.html",method=RequestMethod.POST)
	@ResponseBody
	public CustomerDto registerUser(@RequestBody CustomerDto customer) {
		System.out.println("inside register");
		CustomerDto user = registerService.registerCustomer(customer);
		return user;
	}
	
    @RequestMapping(value="saveProduct.html",method=RequestMethod.POST)
    @ResponseBody
    public ProductDto saveProduct(@RequestBody ProductDto productDto) {
    	
    	System.out.println(productDto.getProductName()+" "+productDto.getCategory()+" "+productDto.getImg());
    	productService.saveProduct(productDto);
    	return productDto;
    }
	
//	@RequestMapping(value="saveProduct.html",method=RequestMethod.POST)
//	@ResponseBody
//	public ProductDto saveProduct(@RequestParam String productName,
//			@RequestParam Double unitPrice, @RequestParam String category,
//			@RequestParam MultipartFile img) {
//  	    System.out.println("Inside");
//		ProductDto dto;
//		System.out.println(img.getContentType()+" "+img.toString()); 
//		return null;
//	}

}
