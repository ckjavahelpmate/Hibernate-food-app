package com.ty.food.controller;

import com.ty.food.dto.User;
import com.ty.food.service.UserService;

public class TestSaveUser {

	public static void main(String[] args) {
		UserService service = new UserService() ;
		
		User user = new User() ;
		user.setName("champa");
		user.setPhone(123456);
		user.setEmail("champ@gmail.com");
		user.setPassword("chap@123");
		
		
		service.saveUser(user) ;
		
	}

}
