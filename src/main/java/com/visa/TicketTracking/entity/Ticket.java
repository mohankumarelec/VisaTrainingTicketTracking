package com.visa.TicketTracking.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;
	private boolean ticketResolved = false;
	private String ticketDescription;

	@CreationTimestamp
	private Date ticketRaiseDate;
	
	private Date ticketResolveDate;
	@ManyToOne
	@JoinColumn(name = "raised_by_user_fk")
	private User ticketRaisedBy;

	@ManyToOne
	@JoinColumn(name = "resolved_by_user_fk")
	private User ticketResolvedBy;

	private String ticketResolvedInfo;

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public User getTicketResolvedBy() {
		return ticketResolvedBy;
	}

	public void setTicketResolvedBy(User ticketResolvedBy) {
		this.ticketResolvedBy = ticketResolvedBy;
	}

	public String getTicketResolvedInfo() {
		return ticketResolvedInfo;
	}

	public void setTicketResolvedInfo(String ticketResolvedInfo) {
		this.ticketResolvedInfo = ticketResolvedInfo;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public boolean isTicketResolved() {
		return ticketResolved;
	}

	public void setTicketResolved(boolean ticketResolved) {
		this.ticketResolved = ticketResolved;
	}

	public Date getTicketRaiseDate() {
		return ticketRaiseDate;
	}

	public void setTicketRaiseDate(Date ticketRaiseDate) {
		this.ticketRaiseDate = ticketRaiseDate;
	}

	public Date getTicketResolveDate() {
		return ticketResolveDate;
	}

	public void setTicketResolveDate(Date ticketResolveDate) {
		this.ticketResolveDate = ticketResolveDate;
	}

	public User getTicketRaisedBy() {
		return ticketRaisedBy;
	}

	public void setTicketRaisedBy(User ticketRaisedBy) {
		this.ticketRaisedBy = ticketRaisedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
