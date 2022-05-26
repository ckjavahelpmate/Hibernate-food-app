package com.ty.food.controller;

import com.ty.food.dto.Tax;
import com.ty.food.service.TaxService;

public class TestGetgstByName {

	public static void main(String[] args) {

		TaxService service = new TaxService() ;
		
		Tax tax = service.getTaxByName("cgst") ;
		
		if(tax != null) {
			System.out.println(tax);
		}
		else {
			System.out.println("No gst found for given name");
		}
		
	}

}
