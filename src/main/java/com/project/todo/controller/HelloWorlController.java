package com.project.todo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.todo.dto.HelloWorld;

@RestController
@RequestMapping("/api")
public class HelloWorlController {

    HelloWorld helloWorld = new HelloWorld("Hello World");

    @GetMapping("/basicauth")
    public ResponseEntity<String> basicAuth() {

        return ResponseEntity.ok().body("Success");
    }


    @GetMapping("/hello")
    public ResponseEntity<HelloWorld> getHello() {
        return ResponseEntity.ok().body(helloWorld);
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<HelloWorld> getHelloName(@PathVariable String name) {
        return ResponseEntity.ok().body(new HelloWorld("Hello " + name));
    }

}
