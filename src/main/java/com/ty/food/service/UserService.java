package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.UserDao;
import com.ty.food.dto.User;


public class UserService {

	UserDao dao = new UserDao() ;
	
	public User saveUser(User User) {

		return dao.saveUser(User) ;
	}
	public User getUserByPhone(long phone) {
		
		List<User> users = dao.getUserByPhone(phone) ;
		if( users.size() != 0) {

			return users.get(0) ;
		}
		else {
			return null ;
		}
		
	}
	public List<User> getAllUser() {
		
		return dao.getAllUser() ;
	}
	public User deleteUserByPhone(long phone) {

		List<User> users = dao.getUserByPhone(phone) ;
		if( users.size() != 0 ) {
			if( users.get(0) != null ) {
				return dao.deleteUser(users.get(0)) ;
			}
			else {
				return null ;
			}
		}
		else {
			return null ;
		}
	}
	public User updateUserPhone(long oldPhone, long newPhone) {

		List<User> users = dao.getUserByPhone(oldPhone) ;
		if( users.size() != 0) {
			if( users.get(0) != null ) {
				
				users.get(0).setPhone(newPhone);
				
				return dao.updateUserPhone(users.get(0)) ;
			}
			else {
				return null ;
			}
		}
		else {
			return null ;
		}
	}
	public User validateUser(String email, String password) {
		
		List<User> users = dao.validateUser(email) ;
		if( users.size() != 0) {
			if( users.get(0) != null ) {
				
				if( users.get(0).getPassword().equals(password)) {
					return users.get(0) ;
				}
				else {
					return null ;
				}
					
			}
			else {
				return null ;
			}
		}
		else {
			return null ;
		}
	}
}
