package com.example.iplticketbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Dummy {
    @Id
    private int id;

    private String user;
    private int age;

    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id=id;
    }
    public String getUser(){
        return user;
    }
    public void setUser(String user){
      this.user = user;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
}

