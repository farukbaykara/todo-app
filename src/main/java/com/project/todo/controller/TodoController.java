package com.project.todo.controller;


import com.project.todo.dto.TodoDto;
import com.project.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/api/users/{username}/todos")
    public ResponseEntity<List<TodoDto>> getAllTodos(@PathVariable String username) {
        return ResponseEntity.ok().body(todoService.findByUsername(username));
    }

    @GetMapping("/api/users/{username}/todos/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable String username, @PathVariable long id) {
        TodoDto todo = todoService.findById(id);
        if (todo == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(todo);
        }
    }

    @DeleteMapping("/api/users/user/todos/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable long id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/users/{username}/todos/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody TodoDto todo) {

        todoService.updateTodo(todo);
        return ResponseEntity.ok().body(todo);
    }

    @PostMapping("/api/users/{username}/todos")
    public ResponseEntity<TodoDto> addTodo(@PathVariable String username, @RequestBody TodoDto todo) {
        TodoDto newTodo = todoService.addTodo(
                username,
                todo.getDescription(),
                todo.getTargetDate(),
                todo.isDone()
        );
        return ResponseEntity.status(201).body(newTodo);
    }

}
