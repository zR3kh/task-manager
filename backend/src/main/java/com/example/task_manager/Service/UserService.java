package com.example.task_manager.Service;

import com.example.task_manager.Errors.ResourceNotFoundException;
import com.example.task_manager.Model.User;
import com.example.task_manager.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        List<User> list = userRepository.findAll();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found.");
        }
        return list;
    }
}
