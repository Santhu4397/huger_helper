package com.ty.doorstepdotin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ty.doorstepdotin.dao.CustomerOrderServiceDao;
import com.ty.doorstepdotin.dto.CustomerOrderService;

@Repository
public class CustomerOrderServiceDaoImpl implements CustomerOrderServiceDao{

	@Override
	public CustomerOrderService createCustomerServiceByOrders(CustomerOrderService customerService, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerOrderService> getAllCustomerServices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerOrderService> getCustomerServiceByOrders(int order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOrderService updateCustomerService(int id, CustomerOrderService customerService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomerService(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
