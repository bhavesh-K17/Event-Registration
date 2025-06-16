package com.example.Event_Registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Event_Registration.model.Registration;
import com.example.Event_Registration.repository.RegistrationRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegistrationService {
	
	@Autowired
	RegistrationRepository registrationRepository;

	public void saveRegistration(Registration registration) {
		
		registrationRepository.save(registration);
	}
	

}
