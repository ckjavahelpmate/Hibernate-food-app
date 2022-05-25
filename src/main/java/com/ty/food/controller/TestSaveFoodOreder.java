package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestSaveFoodOreder {

	public static void main(String[] args) {
		
		FoodOrder foodOrder = new FoodOrder() ;
		foodOrder.setName("shivu");
		foodOrder.setPhone(97178798);
		
		Item item1 = new Item() ;
		item1.setName("mutton fry");
		item1.setQuantity(02);
		item1.setCost(250);
		
		Item item2 = new Item() ;
		item2.setName("chicken kurma");
		item2.setQuantity(01);
		item2.setCost(150);
		
		Item item3 = new Item() ;
		item3.setName("thale mamsa");
		item3.setQuantity(01);
		item3.setCost(150);
		
		List<Item> items = new ArrayList<Item>() ;
		items.add(item1) ;
		items.add(item2) ;
		items.add(item3) ;
		
		item1.setFoodOrder(foodOrder);
		item2.setFoodOrder(foodOrder);
		item3.setFoodOrder(foodOrder);
		foodOrder.setItems(items);
		
		FoodOrderService service = new FoodOrderService() ;
		service.saveFoodOrder(foodOrder) ;
		System.out.println("************* Done ***************");

	}

}
