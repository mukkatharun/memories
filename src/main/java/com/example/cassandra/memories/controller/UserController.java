package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.model.Users;
import com.example.cassandra.memories.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UsersRepository usersRepository;

    @PostMapping("/users")
    public Users addProduct(@RequestBody Users user){
        usersRepository.save(user);
        return user;
    }

    @GetMapping("/users")
    public List<Users> getProducts(){

        return usersRepository.findAll();
    }
}
