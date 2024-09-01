package com.example.iplticketbooking.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.iplticketbooking.entity.Register;
public interface registerRepo extends CrudRepository<Register,Long> {
    public Register findByUserName(String userName);
}