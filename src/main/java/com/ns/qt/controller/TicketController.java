package com.ns.qt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ns.qt.entities.Ticket;
import com.ns.qt.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Ticket> addTicket(@RequestBody final Ticket ticket) {
    	ticketService.save(ticket);
    	return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getAllTickets() {
    	List<Ticket> ticketList = ticketService.findAll();
    	if(ticketList.isEmpty()){
            return new ResponseEntity<List<Ticket>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Ticket>>(ticketList, HttpStatus.OK);
    }
    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> getTicket(@PathVariable("id") long id) {
		Ticket ticket = ticketService.findOne(id);
		if (ticket == null) {
			return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Ticket> updateTicket(@PathVariable("id") long id, @RequestBody Ticket ticket) {
		Ticket currentTicket = ticketService.findOne(id);
		if (currentTicket == null) {
			return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
		}
		currentTicket.setName(ticket.getName());
		currentTicket.setPrice(ticket.getPrice());
		ticketService.save(currentTicket);
		return new ResponseEntity<Ticket>(currentTicket, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Ticket> deleteTicket(@PathVariable("id") long id) {
		Ticket ticket = ticketService.findOne(id);
		if (ticket == null) {
			return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
		}
		ticketService.delete(id);
		return new ResponseEntity<Ticket>(HttpStatus.NO_CONTENT);
	}	

}
