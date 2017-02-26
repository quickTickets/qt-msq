package com.ns.qt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ns.qt.entities.Order;
import com.ns.qt.repositories.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersRepository orders;
	
	@Override
	public void save(Order order) {
		orders.save(order);
	}

	@Override
	public List<Order> findAll() {
		List<Order> orderList = new ArrayList<>();
    	Iterable<Order> orderIterator = orders.findAll();
    	orderIterator.forEach(orderList::add);
    	return orderList;
	}

	@Override
	public Order findOne(long id) {
		Order order = orders.findOne(id);
		return order;
	}

	@Override
	public void delete(long id) {
		orders.delete(id);
	}

}
