package com.example.todoappbackend.repositories;

import com.example.todoappbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : Ibrahim Hatchabi
 * @DateTime : 15/11/2021 at 16:30
 * @Project : todo-app-backend
 */
public interface UserRepository extends JpaRepository<User, Long> {

    boolean findByUserNameAndPassword(String userName, String password);
}
