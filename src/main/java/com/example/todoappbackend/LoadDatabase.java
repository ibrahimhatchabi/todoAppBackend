package com.example.todoappbackend;

import com.example.todoappbackend.entities.Category;
import com.example.todoappbackend.entities.Task;
import com.example.todoappbackend.entities.User;
import com.example.todoappbackend.repositories.TaskRepository;
import com.example.todoappbackend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TaskRepository taskRepository, UserRepository userRepository) {

        return args -> {
            User adminUser = new User();
            adminUser.setUserName("admin");
            adminUser.setPassword("admin");
            log.info("Preloading " + userRepository.save(adminUser));

            log.info("Preloading " + taskRepository.save(new Task("Daily meeting with team", new Date().toString(), false, Category.business)));
            log.info("Preloading " + taskRepository.save(new Task("Pay for rent", new Date().toString(), true, Category.personal)));
            log.info("Preloading " + taskRepository.save(new Task("Check emails", new Date().toString(), false, Category.personal)));
            log.info("Preloading " + taskRepository.save(new Task("Laundry", new Date().toString(), false, Category.personal)));
            log.info("Preloading " + taskRepository.save(new Task("Lunch with client", new Date().toString(), false, Category.business)));
            log.info("Preloading " + taskRepository.save(new Task("New project kick off prep", new Date().toString(), false, Category.business)));
            log.info("Preloading " + taskRepository.save(new Task("Pick up fuel", new Date().toString(), false, Category.business)));
            log.info("Preloading " + taskRepository.save(new Task("Quick run", new Date().toString(), false, Category.personal)));
            log.info("Preloading " + taskRepository.save(new Task("CI/CD talk prep", new Date().toString(), false, Category.business)));
        };
    }
}