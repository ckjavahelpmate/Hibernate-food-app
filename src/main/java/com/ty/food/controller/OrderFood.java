package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.dto.Menu;
import com.ty.food.dto.Tax;
import com.ty.food.dto.User;
import com.ty.food.service.FoodOrderService;
import com.ty.food.service.MenuService;
import com.ty.food.service.TaxService;

public class OrderFood {

	public static void main(String[] args) {
		String username = "chethan" ;
		long phone = 789456 ;
		String email = "chethu@mail.com" ;
		String food1 = "dosa" ;
		int quantity1 = 1 ;
		String food2 = "masala dosa" ;
//		String food1 = "dosa" ;
		
		User user = new User() ;
		user.setName(username);
		user.setPhone(phone);
		user.setEmail(email) ;
		
		MenuService menuService = new MenuService() ;
		
		Menu menu = menuService.getMenuByType(food1).get(0) ;
		Item item1 = new Item() ;
		item1.setName(menu.getName());
		item1.setQuantity(2);
		item1.setCost(menu.getCost());
		item1.setTotal(menu.getCost()*2);
		
		Menu menu2 = menuService.getMenuByType(food1).get(0) ;
		Item item2 = new Item() ;
		item2.setName(menu2.getName());
		item2.setQuantity(2);
		item2.setCost(menu2.getCost());
		item2.setTotal(menu2.getCost()*2);
		
		List<Item> items = new ArrayList<Item>() ;
		items.add(item1) ;
		items.add(item2) ;
		double ItemSum = 0 ;
		for(Item item : items ) {
			ItemSum += item.getTotal() ;
		}
		TaxService taxService = new TaxService() ;
		List<Tax> taxs = taxService.getAllTax() ;
		double taxSum = 0 ;
		
		for(Tax tax : taxs) {
			
			taxSum += tax.getGstValue() * ItemSum ;
			
		}
		
	
		FoodOrder foodOrder = new FoodOrder() ;
		foodOrder.setName(username);
		foodOrder.setPhone(phone);
		foodOrder.setTotal(ItemSum + taxSum);
		foodOrder.setTax(taxSum);
		
		foodOrder.setItems(items);
		item1.setFoodOrder(foodOrder);
		item2.setFoodOrder(foodOrder);
		
		
		FoodOrderService orderService = new FoodOrderService() ;
		orderService.saveFoodOrder(foodOrder) ;
		
		
		

	}

}
