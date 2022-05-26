package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestGetAllMenu {

	public static void main(String[] args) {

		MenuService menuService = new MenuService() ;

		List<Menu> menus =	menuService.getAllMenu();
		
		if(menus.size() != 0 ) {
			for(Menu menu : menus) {
				System.out.println("Menu Id: "+ menu.getId());
				System.out.println("Menu name: "+ menu.getName());
				System.out.println("Menu description: "+ menu.getDescription());
				System.out.println("Menu cost: "+ menu.getCost());
				System.out.println("Menu type: "+ menu.getType());
				System.out.println("Menu offer: "+ menu.getOffer());
				System.out.println("Menu image: "+ menu.getImage());
			}	
		}
		else {
			System.out.println("No menu found for given id");
		}



	}

}
