package com.visa.TicketTracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.TicketTracking.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
