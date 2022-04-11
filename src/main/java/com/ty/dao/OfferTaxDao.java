package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.dto.OfferTax;
import com.ty.dto.Orders;
@Repository
public class OfferTaxDao {

	@Autowired
	private EntityManager entityManager;
	@Autowired
	private EntityTransaction entityTransaction;
	 
	 public void saveOffer(OfferTax tax) {
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(tax);
			entityTransaction.commit();
		}
		
		public OfferTax getOfferById(int id) {
			return entityManager.find(OfferTax.class, id);
		}
		
		public void updateoffer(OfferTax offer) {
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(offer);
			entityTransaction.commit();
		}
		
		public boolean deleteoffer(int id) {
			OfferTax offer =entityManager.find(OfferTax.class, id);
			if(offer!=null) {
				entityTransaction=entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.remove(offer);
				entityTransaction.commit();
				return true;
			}else {
				return false;
			}
		}
		

	 public List<OfferTax> getAllTax() {
		Query query=entityManager.createQuery("select offer from OfferTax offer");
		List list=query.getResultList();
		System.out.println(list.get(1));
		return list;
	 }
}
