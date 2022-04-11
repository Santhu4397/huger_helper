package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.dto.Item;
import com.ty.dto.Orders;
@Repository
public class OrderDao {

	@Autowired
	private EntityManager entityManager;
	@Autowired
	private EntityTransaction entityTransaction;
	 
	 public void saveOrder(Orders order) {
		 entityTransaction.begin();
		 entityManager.persist(order);
		 entityTransaction.commit();
	 }
	 
	 public List<Orders> getAllOrder() {
		Query query=entityManager.createQuery("select orders from Orders orders");
		List list=query.getResultList();
		return list;
	 }
	 public Orders getOrderById(int id) {
	Orders order =entityManager.find(Orders.class,id);
		 return order;
	 }
	 
	 public void updateOrder(Orders order) {
		 entityTransaction.begin();
		entityManager.merge(order);
		 entityTransaction.commit();
	 }

	 public boolean deleteOrder(int id) { 
			 Orders order=entityManager.find(Orders.class,id);
			 System.out.println(order);
		 if(order!=null) {
			 entityTransaction.begin();
			entityManager.remove(order);
			 entityTransaction.commit();
			 return true;
		 }
		 else
			 return false;
	 }
}
