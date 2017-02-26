package com.ns.qt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ns.qt.entities.Ticket;

public interface TicketsRepository extends CrudRepository<Ticket, Long> {

	Ticket findByName(String ticketName);

	void delete(Long id);

	Ticket save(Ticket entity);

}
