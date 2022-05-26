package com.ty.food.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

	public List<FoodOrder> getFoodOrderByPhone(long phone) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;

		Query query = entityManager.createQuery("Select f from FoodOrder f where f.phone=?1") ;
		query.setParameter(1, phone ) ;

		return query.getResultList() ;

	}
	public Item getItemByPhone(int id) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;

		return entityManager.find(Item.class, id) ;

	}
	public FoodOrder deleteFoodOrder(FoodOrder foodOrder) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		entityTransaction.begin();

		List<Item> items = foodOrder.getItems() ;

		for( Item item : items ) {
			entityManager.remove(item);
		}

		entityManager.remove(foodOrder);

		entityTransaction.commit();

		return entityManager.find(FoodOrder.class, foodOrder.getId()) ;
	}
	public FoodOrder deleteItem( FoodOrder foodOrder, int id) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		FoodOrder foodOrder2 = entityManager.find(FoodOrder.class, foodOrder.getId()) ;
		
		List<Item> items = foodOrder2.getItems() ;
		List<Item> items2 = new ArrayList<Item>() ;
		
		entityTransaction.begin();
		
		for( Item item : items) {
			if( item.getId() == id ) {
				entityManager.remove(item);
			}
			else {
				items2.add(item) ;
			}
		}
		foodOrder2.setItems(items2);
		entityManager.merge(foodOrder2) ;

		entityTransaction.commit();

		return entityManager.find(FoodOrder.class, foodOrder2.getId() ) ;
	}

	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		entityTransaction.begin();

		List<Item> items = foodOrder.getItems() ;

		for( Item item : items ) {
			entityManager.merge(item);
		}

		FoodOrder foodOrder2 =	entityManager.merge(foodOrder);

		entityTransaction.commit();

		return foodOrder2 ;
	}
}
