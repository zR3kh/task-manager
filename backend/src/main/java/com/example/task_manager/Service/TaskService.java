package com.example.task_manager.Service;

import com.example.task_manager.Errors.ResourceNotFoundException;
import com.example.task_manager.Model.Task;
import com.example.task_manager.Model.TaskRepository;
import org.hibernate.query.spi.QueryOptionsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> findAll() {
        List<Task> list = taskRepository.findAll();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found.");
        }
        return list;
    }

    public List<Task> findByUserId(Long userId) {
        List<Task> list = taskRepository.findByUserId(userId);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found.");
        }
        return list;
    }

    public Optional<Task> findById(long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new ResourceNotFoundException("No task found.");
        }
        return task;
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> update(long id, Task task) {
        Optional<Task> toUpdateTask = taskRepository.findById(id);
        if (toUpdateTask.isPresent()) {
            toUpdateTask.get().setDescription(task.getDescription());
            toUpdateTask.get().setName(task.getName());
            taskRepository.save(toUpdateTask.get());
        } else {
            throw new ResourceNotFoundException("Task not found.");
        }
        return toUpdateTask;
    }

    public Optional<Task> deleteTask(long id) {
        Optional<Task> toDeleteTask = taskRepository.findById(id);
        if (toDeleteTask.isPresent()) {
            taskRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Task not found.");
        }
        return toDeleteTask;
    }
}
