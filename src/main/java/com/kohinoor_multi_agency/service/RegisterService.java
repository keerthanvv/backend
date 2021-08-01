package com.kohinoor_multi_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kohinoor_multi_agency.model.Register;
import com.kohinoor_multi_agency.repository.RegisterRepository;

@Service
public class RegisterService {
	
	@Autowired
	private RegisterRepository registerRepository;
	
	public Register saveUser(Register register) {
		return registerRepository.save(register);
	}

	public Register featchUserByEmailId(String email) {
		return registerRepository.findByEmailId(email);
		
	}
	
	public Register findByEmailIdAndPassword(String emailID,String password) {
		return registerRepository.findByEmailIdAndPassword(emailID, password);
	}
	
}   
