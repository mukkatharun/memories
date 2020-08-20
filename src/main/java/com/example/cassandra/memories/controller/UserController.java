package com.example.cassandra.memories.controller;

import com.example.cassandra.memories.KeysHelper.CommentsByVideoKey;
import com.example.cassandra.memories.model.Users;
import com.example.cassandra.memories.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getUsers(){
        List<Users> users= usersRepository.findAll();
        return Optional.ofNullable(users)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("users/{id}")
    public ResponseEntity<Optional<Users>> getUserById(@PathVariable("id") UUID userid){
        Optional<Users> user = usersRepository.findById(userid);
        return Optional.ofNullable(user)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("/users")
    public ResponseEntity<Users> addUser(@RequestBody Users user){
        Users newUser = usersRepository.save(user);
        return Optional.ofNullable(newUser)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @PutMapping("/users")
    public ResponseEntity<Users> updateUser(@RequestBody Users user){
        Users updateUser = usersRepository.save(user);
        return Optional.ofNullable(updateUser)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/users")
    public boolean deleteUser(@RequestBody UUID user_id){
        try{
            usersRepository.deleteById(user_id);
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }

}
