package com.sbms.service;

import org.springframework.stereotype.Service;

import com.sbms.exception.CustomerNotFoundException;

@Service
public class CustomerService {

	public String getCustomerNameById(Integer customerId) {
		if (customerId >= 100) {
			return "John";
		} else {
			throw new CustomerNotFoundException("Invalid customer id");
		}
	}
}