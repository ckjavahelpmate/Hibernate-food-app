package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.User;


public class UserDao {

	public User saveUser(User User) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		entityTransaction.begin();
		entityManager.persist(User);
		entityTransaction.commit();

		return entityManager.find(User.class, User.getId()) ;
	}
	public List<User> getUserByPhone(long phone) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;

		Query query = entityManager.createQuery("select u from User u where u.phone=?1") ;
		query.setParameter(1, phone) ;

		List<User> user = query.getResultList() ;
		
		return user ;
	}
	public List<User> getAllUser() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		Query query = entityManager.createQuery("select t from User t") ;
		
		return query.getResultList() ;	
	}
	public User deleteUser(User user) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();

		return entityManager.find(User.class, user.getId()) ;
	}
	public User updateUserPhone(User user) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		entityTransaction.begin();
		User User1 =entityManager.merge(user);
		entityTransaction.commit();

		return User1 ;
	}
	public List<User> validateUser(String email) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		Query query = entityManager.createQuery("select t from User t where t.email=?1") ;
		query.setParameter(1, email) ;

		List<User> user = query.getResultList() ;
		
		return user ;
	}
}
