package com.ty.food.service;

import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class TestGetFoodOrderById {

	public static void main(String[] args) {
		
		FoodOrderService service = new FoodOrderService() ;
		
		FoodOrder foodOrder = service.getFoodOrderById(2) ;
		
		if( foodOrder != null ) {
			List<Item> items = foodOrder.getItems() ;
			
			System.out.println("FoodOrder ID: "+ foodOrder.getId());
			System.out.println("FoodOrder name: "+ foodOrder.getName());
			System.out.println("FoodOrder phone: "+ foodOrder.getPhone());
			for(Item item : items) {
				System.out.println("**************************************");
				System.out.println("Item Id: "+ item.getId());
				System.out.println("Item name: "+ item.getName());
				System.out.println("Item quantity: "+ item.getQuantity());
				System.out.println("Item cost: "+ item.getCost());
				System.out.println("**************************************");
			}
		
		}
		else {
			System.out.println("No FoodOrder Found");
		}

	}

}
