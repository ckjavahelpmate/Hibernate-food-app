package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestGetFoodOrderByPhone {

	public static void main(String[] args) {
		
		FoodOrderService service = new FoodOrderService() ;
		
		FoodOrder foodOrder = service.getFoodOrderByPhone(789456) ;
		
		if( foodOrder != null ) {
			List<Item> items = foodOrder.getItems() ;
			
			System.out.println("FoodOrder ID: "+ foodOrder.getId());
			System.out.println("FoodOrder name: "+ foodOrder.getName());
			System.out.println("FoodOrder phone: "+ foodOrder.getPhone());
			System.out.println("FoodOrder Total: "+ foodOrder.getTotal());
			
			
			System.out.println("Item Id====Item name====Item quantity====Item cost====Item Total");
			System.out.println("=====================================================================");
			for(Item item : items) {
				System.out.print(item.getId()+"		");
				System.out.print(item.getName()+"	  ");
				System.out.print(item.getQuantity()+"		");
				System.out.print(item.getCost()+"		");
				System.out.print(item.getTotal()+"		");
				System.out.println();
			}
			System.out.println("=====================================================================");
			System.out.println("				            	   Tax: "+ foodOrder.getTax());
			System.out.println("=====================================================================");
			System.out.println("						 Total: "+ foodOrder.getTotal());
		
		}
		else {
			System.out.println("No FoodOrder Found");
		}

	}

}
