package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.Menu;

public class MenuDao {

	public Menu saveMenu(Menu menu) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		entityTransaction.begin();
		
		entityManager.persist(menu);
		
		entityTransaction.commit();
		
		return entityManager.find(Menu.class, menu.getId()) ;
		
	}
	public List<Menu> getMenuByType(String type) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		Query query = entityManager.createQuery("Select m from Menu m where m.type=?1") ;
		query.setParameter(1, type) ;
		
		return query.getResultList() ;
		
	}
	public List<Menu> getAllMenu() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		Query query = entityManager.createQuery("Select m from Menu m") ;
		
		return query.getResultList() ;
		
	}
}
