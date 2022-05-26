package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.FoodOredrDao;
import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderService {

	FoodOredrDao dao = new FoodOredrDao() ;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		if( foodOrder.getItems().size() != 0 ) {
			return dao.saveFoodOrder(foodOrder) ;
		}
		else {
			return null ;
		}
	}

	public FoodOrder getFoodOrderByPhone(long phone) {

		List<FoodOrder> foodOrders = dao.getFoodOrderByPhone(phone) ;

		if( foodOrders.size() != 0 ) {
			return foodOrders.get(0) ;
		}
		else {
			return null ;
		}

	}
	public FoodOrder deleteFoodOrderByPhone(long phone) {

		List<FoodOrder> foodOrders = dao.getFoodOrderByPhone(phone) ;

		if( foodOrders.size() != 0 ) {
			return dao.deleteFoodOrder(foodOrders.get(0)) ;
		}
		else {
			return null ;
		}
	}
	public FoodOrder deleteItemById(long phone, int id) {

		List<FoodOrder> foodOrders = dao.getFoodOrderByPhone(phone) ;
		if( foodOrders.size() != 0 ) {
			if(foodOrders.get(0) != null ) {
				return dao.deleteItem(foodOrders.get(0) , id) ;
			}
			else {
				return null ;
			}
		}
		else {
			return null ;
		}


	}
	public FoodOrder updateFoodOrderByPhone(long phone, List<Item> items) {

		List<FoodOrder> foodOrders = dao.getFoodOrderByPhone(phone) ;
		if( foodOrders.size() != 0 ) {

			foodOrders.get(0).setItems(items);
			for(Item item : items) {
				item.setFoodOrder(foodOrders.get(0));
			}
			return dao.updateFoodOrder(foodOrders.get(0)) ;

		}
		else {
			return null ;
		}
	}
}
