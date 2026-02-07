package com.taskapi.task_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        // For now, we'll return fake data (hardcoded)
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "Learn Spring Boot", false));
        tasks.add(new Task(2L, "Build REST API", true));
        tasks.add(new Task(3L, "Connect to MySQL", false));
        
        return tasks;
    }
}