package com.example.Event_Registration.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Event> eventList = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Registration> registration = new ArrayList<>();

	public User(String name, String email, String role) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public List<Registration> getRegistration() {
		return registration;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public void setRegistration(List<Registration> registration) {
		this.registration = registration;
	}

	public List<Event> getEvents() {
		return eventList;
	}

	public void setEvents(List<Event> events) {
		this.eventList = events;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role +"]";
	}

	
	
}
