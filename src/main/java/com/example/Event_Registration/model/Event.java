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
public class Event {

	@Id
	@Column(name = "event_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String description;
	private String location;
	private String category;
	private int availableSeats;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	

	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Registration> registration = new ArrayList<>();

	public Event(String title, String description, String location, String category, int availableSeats) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.category = category;
		this.availableSeats = availableSeats;
	}

	public Event() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public String getCategory() {
		return category;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}


	public List<Registration> getRegistration() {
		return registration;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}



	public void setRegistration(List<Registration> registration) {
		this.registration = registration;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", category=" + category + ", availableSeats=" + availableSeats + ", user=" + user + ", registration="
				+ registration + "]";
	}

	
	
	
}
