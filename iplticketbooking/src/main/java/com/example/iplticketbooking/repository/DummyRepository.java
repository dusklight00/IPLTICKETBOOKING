package com.example.iplticketbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.iplticketbooking.entity.Dummy;

public interface DummyRepository extends CrudRepository<Dummy,Integer>{
 public Dummy findById(int id);
}

