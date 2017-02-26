package com.ns.qt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ns.qt.entities.Order;

public interface OrdersRepository extends CrudRepository<Order, Long>  {

	void delete(Long id);

	Order save(Order entity);
}
