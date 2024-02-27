package com.xask.controller;

import com.xask.database.entity.Department;
import com.xask.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments-controller")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>>readAll(){
        return new ResponseEntity<>(departmentService.findAll(), HttpStatus.OK);
    }

}
