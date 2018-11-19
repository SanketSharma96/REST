package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.entity.Product;
import com.user.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	@RequestMapping("browse.html")
	@ResponseBody
	public List<Product> userHomePage() {
		return productService.findAll();
	}

}
