package com.kohinoor_multi_agency.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kohinoor_multi_agency.model.Register;
import com.kohinoor_multi_agency.service.RegisterService;

@RestController
public class EmployeeRegisterController 
{
	@Autowired
	private RegisterService registerService;
	
	@PostMapping("/register")
    public Register registerUser(@RequestBody Register register) throws Exception {
		String tempEmailId = register.getEmailId();
		if(tempEmailId!=null) {
			 Register registerObj = registerService.featchUserByEmailId(tempEmailId);
			 if(registerObj!=null) {
				 throw new Exception("User with "+tempEmailId+" already present");
			 } 
		}
	   Register registerObj  =null;
	   registerObj =  registerService.saveUser(register);
	   return registerObj;
   }
	
}
