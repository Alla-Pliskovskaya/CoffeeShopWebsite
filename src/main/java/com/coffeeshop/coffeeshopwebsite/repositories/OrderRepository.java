package com.coffeeshop.coffeeshopwebsite.repositories;

import com.coffeeshop.coffeeshopwebsite.models.Order;
import com.coffeeshop.coffeeshopwebsite.models.User;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Iterable<Order> getOrdersByUser (User user);
}
