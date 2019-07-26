package com.visa.TicketTracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.TicketTracking.entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

}
