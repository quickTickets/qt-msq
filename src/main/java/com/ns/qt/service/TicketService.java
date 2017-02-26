package com.ns.qt.service;

import java.util.List;

import com.ns.qt.entities.Ticket;

public interface TicketService {

	void save(Ticket ticket);

	List<Ticket> findAll();

	Ticket findOne(long id);

	void delete(long id);
}
