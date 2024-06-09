package com.example.jwttoken.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwttoken.model.document.Todo;
import com.example.jwttoken.model.document.TodoRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;




@RestController
@RequestMapping("/auth/user")
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class TodoController {

    @Autowired
    private TodoRepository todoService;

   
    @GetMapping("/deneme")
    public ResponseEntity<String> getDeneme() {
        log.info("Wdenemee");
        return ResponseEntity.ok("Wdeneme");
    }

    @GetMapping("/todo")
    public ResponseEntity<List<Todo>> getTodo() {

        return ResponseEntity.status(200).body(todoService.findAll());
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> addNewUser() {
        Todo todo = new Todo("deneme", "123");
        todoService.save(todo);
        return ResponseEntity.ok(todo);
    }


}
