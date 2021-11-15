package com.example.todoappbackend.controllers;

import com.example.todoappbackend.entities.User;
import com.example.todoappbackend.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : Ibrahim Hatchabi
 * @DateTime : 15/11/2021 at 16:29
 * @Project : todo-app-backend
 */
@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @PostMapping("/authenticate")
    Boolean authenticate(@RequestBody User user) {
        User fetchedUser = repository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        return fetchedUser != null;
    }

    // Single item

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(User -> {
                    User.setUserName(newUser.getUserName());
                    User.setPassword(newUser.getPassword());
                    return repository.save(User);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
