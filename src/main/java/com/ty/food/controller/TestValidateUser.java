package com.ty.food.controller;

import com.ty.food.dto.User;
import com.ty.food.service.UserService;

public class TestValidateUser {

	public static void main(String[] args) {
		UserService service = new UserService() ; 

		User user =  service.validateUser("nayi@gmail.com", "nayi@123") ;

		if ( user != null ) {

			System.out.println("User validated successfully" );
		}
		else {

			System.out.println( "User or password wrong ");
		}

	}

}
