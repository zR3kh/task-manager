package com.example.task_manager.Controller;

import com.example.task_manager.Errors.BadFormatException;
import com.example.task_manager.Errors.ResourceNotFoundException;
import com.example.task_manager.Model.Task;
import com.example.task_manager.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/taskmanager/api")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<ResponseWrapper<List<Task>>> findAll() {
        return ResponseEntity.ok(new ResponseWrapper<>("Success", taskService.findAll()));
    }

    @GetMapping("/tasks/users/{userId}")
    public ResponseEntity<ResponseWrapper<List<Task>>> findByUserId(@PathVariable long userId) {
        return ResponseEntity.ok(new ResponseWrapper<>("Success", taskService.findByUserId(userId)));
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<ResponseWrapper<Optional<Task>>> findById(@PathVariable long id) {
        return ResponseEntity.ok(new ResponseWrapper<>("Success", taskService.findById(id)));
    }

    @PostMapping("/tasks")
    public ResponseEntity<ResponseWrapper<Task>> saveTask(@Valid @RequestBody Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadFormatException("Bad format.");
        }
        return ResponseEntity.ok(new ResponseWrapper<>("Success", taskService.save(task)));
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<ResponseWrapper<Optional<Task>>> updateTask(@PathVariable long id, @Valid @RequestBody Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadFormatException("Bad format.");
        }
        return ResponseEntity.ok(new ResponseWrapper<>("Success", taskService.update(id, task)));
    }

    @DeleteMapping("tasks/{id}")
    public ResponseEntity<ResponseWrapper<Optional<Task>>> deleteTask(@PathVariable long id) {
        return ResponseEntity.ok(new ResponseWrapper<>("Task successfully deleted.", taskService.deleteTask(id)));
    }
}
