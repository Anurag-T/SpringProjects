package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean isValid(String name,String password) {
		if(name.equals("anurag") && password.equals(password)) {
			return true;
		}
		return false;
	}

}
