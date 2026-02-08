package com.taskapi.task_api;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        // For now, we'll search through our hardcoded list
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "Learn Spring Boot", false));
        tasks.add(new Task(2L, "Build REST API", true));
        tasks.add(new Task(3L, "Connect to MySQL", false));
        
        // Find the task with matching ID
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        
        // If not found, return null for now (we'll improve this later)
        return null;
    }
    @PostMapping("/tasks")
public Task createTask(@RequestBody Task task) {
    // In a real app, we'd save to database
    // For now, just return the task with a message
    System.out.println("New task created: " + task.getTitle());
    return task;
}
@PutMapping("/tasks/{id}")
public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
    // In a real app, we'd find the task in the database and update it
    // For now, we'll just return the updated task with the ID
    updatedTask.setId(id);  // Make sure the ID matches the URL
    System.out.println("Task " + id + " updated to: " + updatedTask.getTitle());
    return updatedTask;
}
@DeleteMapping("/tasks/{id}")
public String deleteTask(@PathVariable Long id) {
    // In a real app, we'd delete from the database
    // For now, just return a confirmation message
    System.out.println("Task " + id + " deleted");
    return "Task " + id + " has been deleted";
}
}  // ← Class ends here - both methods are inside!`

