package com.taskapi.task_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // That's it! Spring provides all CRUD methods automatically:
    // - save()
    // - findAll()
    // - findById()
    // - deleteById()
    // - etc.
}