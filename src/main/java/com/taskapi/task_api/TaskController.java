package com.taskapi.task_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // CREATE
    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);  // Saves to database!
    }

    // READ ALL
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskRepository.findAll();  // Gets from database!
    }

    // READ ONE
    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setTitle(taskDetails.getTitle());
            task.setCompleted(taskDetails.isCompleted());
            return taskRepository.save(task);  // Updates in database!
        }
        return null;
    }

    // DELETE
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);  // Deletes from database!
        return "Task " + id + " deleted";
    }
}