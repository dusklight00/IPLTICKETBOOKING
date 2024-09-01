package com.example.iplticketbooking.controllers;

import com.example.iplticketbooking.entity.Dummy;
import com.example.iplticketbooking.entity.User;
import com.example.iplticketbooking.repository.DummyRepository;
import com.example.iplticketbooking.repository.registerRepo;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

class Response {

  public String message;
  public int code;

  public Response(String message, int code) {
    this.message = message;
    this.code = code;
  }
}

@RestController
public class MainController {

  @Autowired
  private DummyRepository dummyRepository;

  @GetMapping("/login")
  public Response login(
    @RequestParam String username,
    @RequestParam String password
  ) {
    String USERNAME = "admin";
    String PASSWORD = "admin";

    if (username.equals(USERNAME) && password.equals(PASSWORD)) {
      Response response = new Response("Login successfully", 200);
      return response;
    } else {
      Response response = new Response("Login Failed", 400);
      return response;
    }
  }

  @GetMapping("/add")
  public Response add() {
    Dummy user = new Dummy();
    user.setid(1);
    user.setAge(20);
    user.setUser("joe");
    dummyRepository.save(user);
    return new Response("Successfully Added", 200);
  }

  @GetMapping("/get")
  public Dummy get(@RequestParam int id) {
    Dummy user = dummyRepository.findById(id);
    return user;
  }

  @Autowired
  private registerRepo registerrepo;

  @GetMapping("/register")
  public Response newRegister(@ModelAttribute User user) {
    registerrepo.save(user);
    return new Response("Succesfully Registered :) ", 200);
  }

  @GetMapping("/user")
  public User getUserByUserName(@RequestParam String userName) {
    return registerrepo.findByUsername(userName);
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return (List<User>) registerrepo.findAll();
  }

  @GetMapping("/userlogin")
  public Response get(
    @RequestParam String username,
    @RequestParam String password
  ) {
    User user = registerrepo.findByUsername(username);

    if (
      user != null &&
      username.equals(user.getUsername()) &&
      password.equals(user.getPassword())
    ) {
      String adhar = user.getAadhar();
      Response response = new Response(String.valueOf(adhar), 400);
      return response;
    } else {
      Response response = new Response("Login Failed", 400);
      return response;
    }
  }
  // @GetMapping("/")
  // public String mainPage(){
  // return "index.html";
  // }

  // @GetMapping("/about")
  // public String AboutMe() {
  //     return "about.html";
  // }

}
