package com.coffeeshop.coffeeshopwebsite.repositories;

import com.coffeeshop.coffeeshopwebsite.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
