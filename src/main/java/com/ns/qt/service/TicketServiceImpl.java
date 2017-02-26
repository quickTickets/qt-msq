package com.ns.qt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ns.qt.entities.Ticket;
import com.ns.qt.repositories.TicketsRepository;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketsRepository tickets;

	@Override
	public void save(Ticket ticket) {
		tickets.save(ticket);
	}

	@Override
	public List<Ticket> findAll() {
		List<Ticket> ticketList = new ArrayList<>();
    	Iterable<Ticket> ticketIterator = tickets.findAll();
    	ticketIterator.forEach(ticketList::add);
    	return ticketList;
	}

	@Override
	public Ticket findOne(long id) {
		Ticket ticket = tickets.findOne(id);
		return ticket;
	}

	@Override
	public void delete(long id) {
		tickets.delete(id);
	}

}
