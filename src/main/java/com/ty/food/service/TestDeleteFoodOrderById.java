package com.ty.food.service;

public class TestDeleteFoodOrderById {

	public static void main(String[] args) {

		FoodOrderService service = new FoodOrderService() ;
		service.deleteFoodOrderById(2);
		
		System.out.println("************* Done ***************");
		
	}

}
