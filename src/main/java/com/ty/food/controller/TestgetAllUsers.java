package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.User;
import com.ty.food.service.UserService;

public class TestgetAllUsers {

	public static void main(String[] args) {

		UserService service = new UserService() ;
		
		List<User> users = service.getAllUser() ;
		
		if( users.size() != 0 ) {
			
			for( User user : users ) {
				
				System.out.println(user);
			}
		}
		else {
			System.out.println("No user found in table");
		}
		
		
	}

}
