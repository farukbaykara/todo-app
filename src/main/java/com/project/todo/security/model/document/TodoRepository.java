package com.example.jwttoken.model.document;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String>{
    
}
