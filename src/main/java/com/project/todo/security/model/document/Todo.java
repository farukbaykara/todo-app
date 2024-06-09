package com.example.jwttoken.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Todo {
    @Id
    private String userId;
    private String name;
    private String rollNumber;
    
    public Todo(String name, String rollNumber) {
        super();
        this.name = name;
        this.rollNumber = rollNumber;
    }
    public String getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
}