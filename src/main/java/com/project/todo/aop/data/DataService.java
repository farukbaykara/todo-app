package com.project.todo.aop.data;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DataService {

    public int[] retrieveData() {
        return new int[] {11,22,33,44,55};
    }


}
