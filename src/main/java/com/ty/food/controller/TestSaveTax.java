package com.ty.food.controller;

import com.ty.food.dto.Tax;
import com.ty.food.service.TaxService;

public class TestSaveTax {

	public static void main(String[] args) {
		
		Tax tax = new Tax() ;
		tax.setGstName("SGST");
		tax.setGstValue(.18);
		
		TaxService service = new TaxService() ;
		
		service.saveTax(tax) ;
		
	}

}
