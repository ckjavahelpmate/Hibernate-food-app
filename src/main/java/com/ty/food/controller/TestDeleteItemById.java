package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestDeleteItemById {

	public static void main(String[] args) {

		FoodOrderService service = new  FoodOrderService() ;
		
		FoodOrder foodOrder = service.deleteItemById(97178798,2) ;
		
		if( foodOrder == null ) {
			System.out.println("No Item found for given ID");
		}
		
		
	}

}
