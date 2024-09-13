package com.example.task_manager.Errors;

import com.example.task_manager.Controller.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionFactory {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseWrapper> handleResourceNotFound(ResourceNotFoundException r) {
        return ResponseEntity.ok(new ResponseWrapper(r.getMessage(), null));
    }

    @ExceptionHandler(BadFormatException.class)
    public ResponseEntity<ResponseWrapper> handleBadFormat(BadFormatException b) {
        return ResponseEntity.ok(new ResponseWrapper(b.getMessage(), null));
    }
}
