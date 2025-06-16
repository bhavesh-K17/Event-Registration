package com.example.Event_Registration.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Registration {

	@Id
	@Column(name="registration_id")
	@GeneratedValue
	private Long id;
	
	private LocalDate registrationDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;

	public Registration(LocalDate registrationDate) {
		super();
		this.registrationDate = registrationDate;
	}

	public Registration() {
		super();
	}

	public Long getId() {
		return id;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public User getUser() {
		return user;
	}

	public Event getEvent() {
		return event;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", registrationDate=" + registrationDate + ", user=" + user + ", event="
				+ event + "]";
	}
	
	
}
