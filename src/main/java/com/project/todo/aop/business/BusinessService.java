package com.project.todo.aop.business;

import com.project.todo.aop.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class BusinessService {

    @Autowired
    private DataService dataService;

    public int calculateSum() {
        int[] data = dataService.retrieveData();

        return Arrays.stream(data).max().orElse(0);
    }

}
