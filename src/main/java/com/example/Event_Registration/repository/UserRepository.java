package com.example.Event_Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Event_Registration.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
