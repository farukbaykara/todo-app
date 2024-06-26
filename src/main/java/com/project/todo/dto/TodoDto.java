package com.project.todo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    private Long id;
    private String username;
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
