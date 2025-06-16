package com.example.Event_Registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Event_Registration.model.User;
import com.example.Event_Registration.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void saveUser(User user) {
		
		userRepository.save(user);
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public void deleteUser(Long id) {
		User user = userRepository.findById(id).orElse(null);
		userRepository.delete(user);
	}
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
}

