package com.example.Event_Registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Event_Registration.model.Event;
import com.example.Event_Registration.repository.EventRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventService {

	@Autowired
	EventRepository eventRepository;
	
	public void saveEvent(Event event) {
		eventRepository.save(event);	
	}
	
	public Event getEventById(Long id) {
		return eventRepository.findById(id).orElse(null);
	}
	
	public void deleteEvent(Long id) {
		Event event = eventRepository.findById(id).orElse(null);
		eventRepository.delete(event);
	}
	
	public List<Event> getAllEvents()
	{
		return eventRepository.findAll();
	}
}
