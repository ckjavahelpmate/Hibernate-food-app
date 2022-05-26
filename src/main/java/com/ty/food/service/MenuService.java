package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.MenuDao;
import com.ty.food.dto.Menu;

public class MenuService {

	MenuDao dao = new MenuDao() ;
	
	public Menu saveMenu(Menu menu) {
		
		return dao.saveMenu(menu) ;
		
	}
	public List<Menu> getMenuByType(String type) {
		
		return dao.getMenuByType(type) ;
		
	}
	public List<Menu> getAllMenu() {
		
		return dao.getAllMenu() ;
		
	}
}
