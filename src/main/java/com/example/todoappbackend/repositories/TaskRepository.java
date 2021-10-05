package com.example.todoappbackend.repositories;

import com.example.todoappbackend.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}