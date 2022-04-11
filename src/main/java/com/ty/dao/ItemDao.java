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
public class ItemDao {
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private EntityTransaction entityTransaction;
	 
	 public void saveItem(Item item) {
		 entityTransaction.begin();
		 entityManager.persist(item);
		 entityTransaction.commit();
	 }
	 

	 public void saveAllItem(List<Item> item) {
		 entityTransaction.begin();
		 for(Item items:item) {
		 entityManager.persist(items);
		 }
		 entityTransaction.commit();
	 }
	 
	 public List<Item> getAllItem() {
		Query query=entityManager.createQuery("select item from Item item");
		List list=query.getResultList();
		return list;
	 }

	 public List<Item> getOrderItem(int id) {
		Query query=entityManager.createQuery("select item from Item item where order_orderId=?1");
		query.setParameter(1,id);
		List<Item> list=query.getResultList();
		return list;
	 }
	 public Item getItemById(int id) {
		Item item= entityManager.find(Item.class,id);
		 return item;
	 }
	 
	 public void updateItem(Item item) {
		 entityTransaction.begin();
		entityManager.merge(item);
		 entityTransaction.commit();
	 }

	 public boolean deleteItem(int id) { 
			 Item item=entityManager.find(Item.class,id);
			 System.out.println(item);
		 if(item!=null) {
			 entityTransaction.begin();
			entityManager.remove(item);
			 entityTransaction.commit();
			 return true;
		 }
		 else
			 return false;
	 }
}
