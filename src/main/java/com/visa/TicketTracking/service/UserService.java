package com.visa.TicketTracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.TicketTracking.dao.UserDao;
import com.visa.TicketTracking.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	@Transactional
	public void addUser(User u) {
		userDao.save(u);
	}

	public List<User> getUsers() {
		return userDao.findAll();
	}

}
