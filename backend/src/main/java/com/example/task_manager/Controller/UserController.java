package com.example.task_manager.Controller;

import com.example.task_manager.Model.Task;
import com.example.task_manager.Model.User;
import com.example.task_manager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/taskmanager/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<ResponseWrapper<List<User>>> findAll() {
        return ResponseEntity.ok(new ResponseWrapper<>("Success", userService.findAll()));
    }
}
