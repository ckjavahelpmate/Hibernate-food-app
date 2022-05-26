package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.Tax;

public class TaxDao {

	public Tax saveTax(Tax tax) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		entityTransaction.begin();
		entityManager.persist(tax);
		entityTransaction.commit();

		return entityManager.find(Tax.class, tax.getId()) ;
	}
	public Tax getTaxByName(String name) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;

		Query query = entityManager.createQuery("select t from Tax t where t.gstName=?1") ;
		query.setParameter(1, name) ;

		List<Tax> tax = query.getResultList() ;	
		return tax.get(0) ;
	}
	public List<Tax> getAllTax() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		Query query = entityManager.createQuery("select t from Tax t") ;
		
		return query.getResultList() ;	
	}
	public Tax deleteTaxByName(String name) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		Query query = entityManager.createQuery("select t from Tax t where t.gstName=?1") ;
		query.setParameter(1, name) ;

		List<Tax> tax = query.getResultList() ;	

		entityTransaction.begin();
		entityManager.remove(tax.get(0));;
		entityTransaction.commit();

		return entityManager.find(Tax.class, tax.get(0).getId()) ;
	}
	public Tax updateTaxByName(String name, double gstValue) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		Query query = entityManager.createQuery("select t from Tax t where t.gstName=?1") ;
		query.setParameter(1, name) ;

		List<Tax> tax = query.getResultList() ;	
		tax.get(0).setGstValue(gstValue);
		entityTransaction.begin();
		Tax tax1 =entityManager.merge(tax.get(0));
		entityTransaction.commit();

		return tax1 ;
	}
	public Tax updateTaxByValue(double gstValue) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		Query query = entityManager.createQuery("select t from Tax t where t.gstValue=?1") ;
		query.setParameter(1, gstValue) ;

		List<Tax> tax = query.getResultList() ;	
		tax.get(0).setGstValue(gstValue);
		entityTransaction.begin();
		Tax tax1 =entityManager.merge(tax.get(0));
		entityTransaction.commit();

		return tax1 ;
	}
}
