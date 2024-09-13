package com.example.task_manager.Model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();
    List<Task> findByUserId(Long userId);
}
