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

import com.ns.qt.entities.Order;
import com.ns.qt.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Order> addOrder(@RequestBody final Order order) {
		orderService.save(order);
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orderList = orderService.findAll();
		if (orderList.isEmpty()) {
			return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Order>>(orderList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> getOrder(@PathVariable("id") long id) {
		Order order = orderService.findOne(id);
		if (order == null) {
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, @RequestBody Order order) {
		Order currentOrder = orderService.findOne(id);
		if (currentOrder == null) {
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
		currentOrder.setQuantity(order.getQuantity());
		currentOrder.setUser(order.getUser());
		currentOrder.setTicket(order.getTicket());
		orderService.save(currentOrder);
		return new ResponseEntity<Order>(currentOrder, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Order> deleteOrder(@PathVariable("id") long id) {
		Order order = orderService.findOne(id);
		if (order == null) {
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
		orderService.delete(id);
		return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
	}

}
