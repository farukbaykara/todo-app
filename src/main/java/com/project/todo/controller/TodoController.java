package com.project.todo.controller;


import com.project.todo.dto.TodoDto;
import com.project.todo.model.document.Food;
import com.project.todo.repository.mongo.FoodRepository;
import com.project.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class TodoController {

    private final TodoService todoService;

    private final FoodRepository foodRepository;

    public TodoController(TodoService todoService, FoodRepository foodRepository) {
        this.todoService = todoService;
        this.foodRepository = foodRepository;
    }



    @GetMapping("/api/users/{username}/todos")
    public ResponseEntity<List<TodoDto>> getAllTodos(@PathVariable String username) {


        foodRepository.findAll().forEach(food -> log.info(food.toString()));

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

        Food newFood = new Food(
                "1",
                "nameeee",
                "asdfasdf",
                "10",
                "2",
                "0123412"
        );

        foodRepository.save(newFood);

        return ResponseEntity.status(201).body(todo);
    }

    @PostMapping("/api/foods")
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        log.info("Food: {}", food.toString());
        Food newFood = foodRepository.save(food);
        return ResponseEntity.status(201).body(newFood);
    }

    @GetMapping("/api/foods")
    public ResponseEntity<List<Food>> getAllFood() {
        log.info("Get all foods request received");
        List<Food> foods = foodRepository.findAll();
        return ResponseEntity.ok().body(foods);
    }

}
