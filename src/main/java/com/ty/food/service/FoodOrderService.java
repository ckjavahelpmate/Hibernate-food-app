package com.ty.food.service;

import com.ty.food.dao.FoodOredrDao;
import com.ty.food.dto.FoodOrder;

public class FoodOrderService {

	FoodOredrDao dao = new FoodOredrDao() ;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return dao.saveFoodOrder(foodOrder) ;
	}
	
	public FoodOrder getFoodOrderById(int id) {
		return dao.getFoodOrderById(id) ;
	}
	public void deleteFoodOrderById(int id) {

		dao.deleteFoodOrderById(id);
	}
}
