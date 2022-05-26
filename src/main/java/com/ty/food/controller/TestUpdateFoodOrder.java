package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestUpdateFoodOrder {

	public static void main(String[] args) {

		Item item1 = new Item() ;
		item1.setName("kaima unde");
		item1.setQuantity(04);
		item1.setCost(150);
		
		List<Item> items = new ArrayList<Item>() ;
		
		items.add(item1) ;
		
		
		FoodOrderService service = new  FoodOrderService() ;
		
		service.updateFoodOrderByPhone(97178798, items) ;
	}

}
