package com.ty.doorstepdotin.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.doorstepdotin.dao.AdminDao;
import com.ty.doorstepdotin.dto.Admin;
import com.ty.doorstepdotin.repository.AdminRepository;

@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
private AdminRepository adminRepository;
	@Override
	public Admin saveAdmin(Admin admin) {
		return null;
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin getAdminByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> getAllAdminByCity(String city, Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin validateAdmin(String email, String password) {
		Admin admin=adminRepository.validateAdmin(email, password);
		return admin;
	}

}
