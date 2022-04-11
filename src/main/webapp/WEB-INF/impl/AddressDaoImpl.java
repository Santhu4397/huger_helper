package com.ty.doorstepdotin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ty.doorstepdotin.dao.AddressDao;
import com.ty.doorstepdotin.dto.Address;
@Repository
public class AddressDaoImpl implements AddressDao {

	@Override
	public Address createAddress(int customer_id, Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAllAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAllAddressByCustomerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address updateAddress(int id, Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAddress(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
