package com.visa.TicketTracking.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.TicketTracking.entity.Ticket;
import com.visa.TicketTracking.entity.User;
import com.visa.TicketTracking.service.TicketService;

@RestController
@RequestMapping("tickets")
public class TicketController {
	@Autowired
	private TicketService ticketService;

	@GetMapping
	public @ResponseBody List<Ticket> getTickets() {
		return ticketService.getTickets();
	}

	@PostMapping
	public ResponseEntity<Ticket> addTicket(@RequestBody Ticket u) {
		ticketService.addTicket(u);
		return new ResponseEntity<>(u, HttpStatus.CREATED);
	}

	@PutMapping	
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket t) {
		String[] roles = new String[] { "Admin" };
		User u = ticketService.getByEmail(t.getTicketResolvedBy().getEmail());
		if (Arrays.asList(roles).contains(u.getRole())) {
			ticketService.resolveTicket(t);
			return new ResponseEntity<>(t, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>(t, HttpStatus.FORBIDDEN);			
		}
	}

}
