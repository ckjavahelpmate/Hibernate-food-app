package com.ty.food.controller;

import com.ty.food.dto.User;
import com.ty.food.service.UserService;

public class TestGetuserByPhone {

	public static void main(String[] args) {

		UserService service = new UserService() ; 
		
		User user =  service.getUserByPhone(456788) ;
		
		if ( user != null ) {
			
			System.out.println( user );
		}
		else {
			
			System.out.println( "No user found for given number");
		}

	}

}
