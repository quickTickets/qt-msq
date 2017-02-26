package com.ns.qt.service;

import java.util.List;

import com.ns.qt.entities.Order;

public interface OrderService {

	void save(Order order);

	List<Order> findAll();

	Order findOne(long id);

	void delete(long id);
}
