package com.kohinoor_multi_agency.controllers;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kohinoor_multi_agency.Exception.DuplicateIDExcepton;
import com.kohinoor_multi_agency.email.MailRequest;
import com.kohinoor_multi_agency.email.MailResponse;
import com.kohinoor_multi_agency.email.MailService;
import com.kohinoor_multi_agency.model.Register;
import com.kohinoor_multi_agency.service.RegisterService;


@RestController
public class EmployeeRegisterController 
{		
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private MailService service;
	
	@PostMapping("/sendingEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model= new HashMap<>();
		model.put("Name", request.getName());
		model.put("location","Banglore,India");
		
		return service.sendEmail(request, model);
	}
		
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200")
    public Register registerUser(@RequestBody Register register) throws Exception {
		String tempEmailId = register.getEmailId();
		if(tempEmailId!=null) {
			 Register registerObj = registerService.featchUserByEmailId(tempEmailId);
			 if(registerObj!=null) {
				 throw new DuplicateIDExcepton("User with "+tempEmailId+" already present");
			 } 
		}
	   Register registerObj  =null;
	   registerObj =  registerService.saveUser(register);
	   return registerObj;
   }
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public Register loginUser(@RequestBody Register register) throws Exception {
		String tempemailId = register.getEmailId();
		String temppassword = register.getPassword();
		Register registerObj = null;
		if(tempemailId !=null && temppassword!=null ) {
			registerObj = registerService.findByEmailIdAndPassword(tempemailId, temppassword);
		}
		if(registerObj ==null) {
			throw new Exception("user doest not exist");
		}
		return registerObj;
		
	}

}
