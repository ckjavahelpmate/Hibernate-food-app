package com.ty.food.controller;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestMenuSave {

	public static void main(String[] args) {

		Menu menu = new Menu() ;
		menu.setName("Benne-Masala dosa");
		menu.setDescription("Single");
		menu.setCost(80);
		menu.setType("Veg");
		menu.setOffer("0% off");
		menu.setImage("@@@@@@@");
		
		
		MenuService menuService = new MenuService() ;
		menuService.saveMenu(menu) ;
		System.out.println("************** Done **************");

	}

}
