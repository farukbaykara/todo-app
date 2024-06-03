package com.project.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


import com.project.todo.model.Todo;
import com.project.todo.dto.TodoDto;
import com.project.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TodoService {


    private final TodoRepository todoRepository;


    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    private static List<TodoDto> todos = new ArrayList<>();

    private static long todosCount = 0;

    static {
        todos.add(new TodoDto(++todosCount, "user","Get AWS Certified",
                LocalDate.now().plusYears(10), false ));
        todos.add(new TodoDto(++todosCount, "user","Learn DevOps",
                LocalDate.now().plusYears(11), false ));
        todos.add(new TodoDto(++todosCount, "user","Learn Full Stack Development",
                LocalDate.now().plusYears(12), false ));
    }

    public List<TodoDto> findByUsername(String username){

        /*
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
        */
        List<TodoDto> todoDto = new ArrayList<>();
        List<Todo> todos = todoRepository.findByUsername(username);

        //todoDto = todos.stream().map(todoMapper::todoToTodoDto).collect(Collectors.toList());

        todoDto = todos.stream().map(todo -> new TodoDto(todo.getId(), todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isDone())).collect(Collectors.toList());

        return todoDto;
    }

    public TodoDto addTodo(String username, String description, LocalDate targetDate, boolean done) {

        Todo todoV = new Todo();

        todoV.setUsername(username);
        todoV.setDescription(description);
        todoV.setTargetDate(targetDate);
        todoV.setDone(done);

        todoRepository.save(todoV);

        TodoDto todoDto = new TodoDto(todoV.getId(), todoV.getUsername(), todoV.getDescription(), todoV.getTargetDate(), todoV.isDone());
        return todoDto;
    }

    public void deleteById(long id) {
        //Predicate<? super TodoDto> predicate = todo -> todo.getId() == id;
        //todos.removeIf(predicate);
        todoRepository.deleteById(id);
    }

    public TodoDto findById(long id) {
        //Predicate<? super TodoDto> predicate = todo -> todo.getId() == id;
        //TodoDto todo = todos.stream().filter(predicate).findFirst().orElse(null);

        Todo todo = todoRepository.findById(id);
        TodoDto todoDto = new TodoDto(todo.getId(), todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isDone());

        return todoDto;
    }

    public void updateTodo(TodoDto todo) {
        //deleteById(todo.getId());
        //todos.add(todo);
        Todo todoV = new Todo();
        todoV.setId(todo.getId());
        todoV.setUsername(todo.getUsername());
        todoV.setDescription(todo.getDescription());
        todoV.setTargetDate(todo.getTargetDate());
        todoV.setDone(todo.isDone());

        todoRepository.save(todoV);
    }
}