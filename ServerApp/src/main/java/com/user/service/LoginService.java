package com.user.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.user.dao.CustomerDao;
import com.user.dto.CustomerDto;
import com.user.entity.Customer;

@Service
public class LoginService {

	@Autowired
	private CustomerDao customerDao;
	// 1 Admin, 0 customer, -1 no account
	public CustomerDto isValidCustomer(String email, String password) {
		
		Customer customer = customerDao.getCustomer(email, password);
		CustomerDto dto = new CustomerDto();
		if(customer==null) {
			dto = null;
		}
		else {
			BeanUtils.copyProperties(customer, dto);
		}
//		if(customer==null) {
//			return -1;
//		}else {
//			
//			if(customer.getType()==1) {
//				return 1;
//			}
//			else {
//				return 0;
//			}
//		}
		return dto;
		
		
		
	}
	


}
