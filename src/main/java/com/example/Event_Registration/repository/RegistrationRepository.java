package com.example.Event_Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Event_Registration.model.Registration;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
