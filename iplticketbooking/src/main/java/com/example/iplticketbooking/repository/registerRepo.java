package com.example.iplticketbooking.repository;

import com.example.iplticketbooking.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface registerRepo extends CrudRepository<User, Long> {
  public User findByUsername(String username);
}
