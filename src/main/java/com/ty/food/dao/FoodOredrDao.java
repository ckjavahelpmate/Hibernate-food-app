package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOredrDao {
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		entityTransaction.begin();
		
		entityManager.persist(foodOrder);
		List<Item> items = foodOrder.getItems() ;
		for(Item item : items ) {
			entityManager.persist(item);
		}
		
		entityTransaction.commit();
		return entityManager.find(FoodOrder.class, foodOrder.getId()) ;
	}
	
	public FoodOrder getFoodOrderById(int id) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		return entityManager.find(FoodOrder.class, id) ;
	}
	public void deleteFoodOrderById(int id) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		FoodOrder foodOrder= entityManager.find(FoodOrder.class, id) ;
		
		entityTransaction.begin();
		
		List<Item> items = foodOrder.getItems() ;
		
		for( Item item : items ) {
			entityManager.remove(item);
		}
		
		entityManager.remove(foodOrder);
		
		entityTransaction.commit();
	}
}
