package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.dto.Product;

@Repository
public class ProductDao {
		
		@Autowired
		private EntityManager entityManager;
		@Autowired
		private EntityTransaction entityTransaction;
		
		

		public void saveProduct(Product product) {
		
			entityTransaction.begin();
			entityManager.persist(product);
			entityTransaction.commit();
		}

		public boolean deleteProduct(int id) {
		
			entityTransaction = entityManager.getTransaction();
			Product product = entityManager.find(Product.class, id);
			if (product != null) {
				entityTransaction.begin();
				entityManager.remove(product);
				entityTransaction.commit();
				return true;
			} else
				return false;
		}

		public List<Product> getAllProducts() {
	
			Query query = entityManager.createQuery("select p from Product p");
			List<Product> list = query.getResultList();
			return list;
		}
		
		 public Product getProductById(int id) {
	
				Product product = entityManager.find(Product.class,id);
				 return product;
			 }
		 
		 public void updateProduct(Product product) {
			 entityTransaction.begin();
			entityManager.merge(product);
			 entityTransaction.commit();
		 }
		 
		 public List<Product> getAllProductsByName(String name) {
		
				Query query = entityManager.createQuery("select p from Product p where name=?1");
				query.setParameter(1, name);
				List<Product> products = query.getResultList();
				if(products!=null)
					return products;
					else
						return null;
			}
		 
		 public List<Product> getAllProductsByType(String type) {
			
				Query query = entityManager.createQuery("select p from Product p where type=?1");
				query.setParameter(1, type);
				List<Product> products = query.getResultList();
				if(products!=null)
					return products;
					else
						return null;
			}
		 
		 public List<Product> getAllProductsByTypeName(String type,String name) {
		
				Query query = entityManager.createQuery("select p from Product p where type=?1 AND name=?2");
				query.setParameter(1, type);
				query.setParameter(2, name);
				List<Product> products = query.getResultList();
				if(products!=null)
				return products;
				else
					return null;
			}

}
