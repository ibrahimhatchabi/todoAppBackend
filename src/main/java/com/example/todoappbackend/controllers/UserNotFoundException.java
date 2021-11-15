package com.example.todoappbackend.controllers;

/**
 * @Author : Ibrahim Hatchabi
 * @DateTime : 15/11/2021 at 17:05
 * @Project : todo-app-backend
 */

class UserNotFoundException extends RuntimeException {

    UserNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}