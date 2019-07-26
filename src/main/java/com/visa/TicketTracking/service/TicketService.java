package com.visa.TicketTracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.TicketTracking.dao.TicketDao;
import com.visa.TicketTracking.dao.UserDao;
import com.visa.TicketTracking.entity.Ticket;
import com.visa.TicketTracking.entity.User;

@Service
public class TicketService {
	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private UserDao userDao;

	@Transactional
	public void addTicket(Ticket u) {
		ticketDao.save(u);
	}

	public List<Ticket> getTickets() {
		return ticketDao.findAll();
	}

	public User getByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Transactional
	public void resolveTicket(Ticket t) {
		Ticket ticketToUpdate = ticketDao.getOne(t.getTicketId());
		ticketToUpdate.setTicketResolved(true);
		ticketToUpdate.setTicketResolvedBy(t.getTicketResolvedBy());
		ticketToUpdate.setTicketResolveDate(t.getTicketResolveDate());
		ticketToUpdate.setTicketResolvedInfo(t.getTicketResolvedInfo());
		ticketDao.save(ticketToUpdate);
	}

}
