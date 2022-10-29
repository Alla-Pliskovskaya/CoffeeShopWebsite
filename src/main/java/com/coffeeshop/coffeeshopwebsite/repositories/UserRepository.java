package com.coffeeshop.coffeeshopwebsite.repositories;

import com.coffeeshop.coffeeshopwebsite.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
