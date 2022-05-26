package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.TaxDao;
import com.ty.food.dto.Tax;

public class TaxService {

	TaxDao dao = new TaxDao() ;

	public Tax saveTax(Tax tax) {

		return dao.saveTax(tax) ;
	}
	public List<Tax> getAllTax( ) {

		return dao.getAllTax() ;
	}
	public Tax getTaxByName(String name ) {

		return dao.getTaxByName(name) ;
	}
	public Tax updateTaxByname(String name, double value ) {

		return dao.updateTaxByName(name, value) ;
	}
	public Tax updateTaxByValue(double value ) {

		return dao.updateTaxByValue(value) ;
	}
	public Tax deleteTaxByName(String name ) {

		return dao.deleteTaxByName(name) ;
	}

}
