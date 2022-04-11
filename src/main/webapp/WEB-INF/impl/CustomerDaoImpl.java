package com.ty.doorstepdotin.dao.impl;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.ty.doorstepdotin.dao.CustomerDao;
import com.ty.doorstepdotin.dto.Customer;

@Repository


public class CustomerDaoImpl implements CustomerDao{


	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(int id, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByLocation(String location, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
