package com.example.todoappbackend.controllers;

import com.example.todoappbackend.entities.Task;
import com.example.todoappbackend.repositories.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskRepository repository;

    TaskController(TaskRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/tasks")
    List<Task> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/tasks")
    Task newTask(@RequestBody Task newTask) {
        return repository.save(newTask);
    }

    // Single item

    @GetMapping("/tasks/{id}")
    Task one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @PutMapping("/tasks/{id}")
    Task replaceTask(@RequestBody Task newTask, @PathVariable Long id) {

        return repository.findById(id)
                .map(Task -> {
                    Task.setTitle(newTask.getTitle());
                    Task.setCategory(newTask.getCategory());
                    Task.setDone(newTask.isDone());
                    Task.setDueTime(newTask.getDueTime());
                    return repository.save(Task);
                })
                .orElseGet(() -> {
                    newTask.setId(id);
                    return repository.save(newTask);
                });
    }

    @DeleteMapping("/tasks/{id}")
    void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
