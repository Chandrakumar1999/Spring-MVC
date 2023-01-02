package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dao.CustomerLoginDAO;
import com.infy.dao.CustomerLoginDAOImpl;
import com.infy.model.CustomerLogin;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {

	@Autowired
	private CustomerLoginDAO customerLoginDao;

	public String authenticateCustomer(CustomerLogin customerLogin)
			 {
		String toRet = null;
		
		CustomerLogin customerLoginFromDao = customerLoginDao
				.getCustomerLoginByLoginName(customerLogin.getLoginName());
		if (customerLogin.getPassword().equals(
				customerLoginFromDao.getPassword())) {
			toRet = "Success";
		} else {
			toRet = "Failed";
		}
		return toRet;
	}
}
