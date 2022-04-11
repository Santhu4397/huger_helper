package com.ty.doorstepdotin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ty.doorstepdotin.dao.SubServiceDao;
import com.ty.doorstepdotin.dto.SubService;

@Repository
public class SubServiceDaoImpl implements SubServiceDao{

	@Override
	public SubService saveSubService(SubService service) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubService getSubServicebyId(int subServiceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubService> getAllSubService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubService updateSubService(int subServiceId, SubService service) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteSubService(int subServiceId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SubService> getSubServicesByMainServiceId(int mainServiceId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
