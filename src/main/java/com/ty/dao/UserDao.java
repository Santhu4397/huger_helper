package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.dto.User;

@Repository
public class UserDao {
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private EntityTransaction entityTransaction;
	public void saveUser(User user) {
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}
	
	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}
	
	public void updateUser(User user) {
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}
	
	public boolean deleteUser(int id) {
		User user =entityManager.find(User.class, id);
		if(user!=null) {
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	
	public List<User> getAllSUser() {
		Query query = entityManager.createQuery("Select u from User u");
		return query.getResultList();
	}
	
	public User validateUser(String email,String password) {
		Query query = entityManager.createQuery("Select u from User u WHERE u.email =?1 AND u.password =?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> users = query.getResultList();
		if(users!=null && users.size()>0) {
			return users.get(0);
		}
		else {
			return null;
		}
	}


}
