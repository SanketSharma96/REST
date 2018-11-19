package com.user.controller;





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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.user.dto.CombinedModel;
import com.user.dto.CustomerDto;
import com.user.dto.LoginModel;
import com.user.service.LoginService;
import com.user.service.RegisterService;


@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private RegisterService registerService;
	
	
	
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
	

	

}
