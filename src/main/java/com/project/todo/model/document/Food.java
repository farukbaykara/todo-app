package com.project.todo.model.document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    private String id;
    private String name;
    private String description;
    private String price;
    private String category;
    private String image;

}
