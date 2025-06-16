package com.example.Event_Registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Event_Registration.model.Event;
import com.example.Event_Registration.model.User;
import com.example.Event_Registration.service.EventService;
import com.example.Event_Registration.service.RegistrationService;
import com.example.Event_Registration.service.UserService;

@Controller
public class EventController {

	@Autowired
	UserService userService;
	@Autowired
	EventService eventService;
	
	@Autowired
	RegistrationService registrationService;
	@GetMapping("/users")
	public String getAllUsers(@RequestParam(value="id",required = false) Long id, Model model) {
		
		if(id!=null) {
			User user = userService.getUserById(id);
			model.addAttribute("users", user);
		}
		else
		{
			List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		}
		
		return"users";
	}
	
	@GetMapping("/user/add")
	public String addUser(Model model) {
		List<Event> eventList = eventService.getAllEvents();
		model.addAttribute("eventList", eventList);
		model.addAttribute("user", new User());
		return "add-user";
	}
	
	@GetMapping("user/add-event")
	public String addEvent(Model model) {
		model.addAttribute("event", new Event());
		return "event-add";
	}
	
	@PostMapping("/save-event")
	public String saveEvent(@ModelAttribute("evente")Event event) {
		eventService.saveEvent(event);
		return "redirect:/users";
	}
	
	@PostMapping("/save-user")
	public String saveUser(@ModelAttribute("user") User user) {
		if(user.getEvents()!=null) {
			for(Event event:user.getEvents()) {
				event.setUser(user);
			}
		}
		
		userService.saveUser(user);
		return"redirect:/users";
	}
	
	@GetMapping("user/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
	
	@GetMapping("user/edit/{id}")
	public String editUser(@PathVariable Long id,Model model) {
		
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		List<Event> events = eventService.getAllEvents();
		model.addAttribute("events", events);
		
		return"user-edit";
	}
	
}
