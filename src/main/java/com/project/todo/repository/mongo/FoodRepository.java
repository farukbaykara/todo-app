package com.project.todo.repository.mongo;


import com.project.todo.model.document.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {
}
