package com.xask.service;

import com.xask.database.entity.Department;
import com.xask.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department>readAll(){
        return departmentRepository.findAll();
    }

    public Department readById(Integer id){
        return departmentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Данного отдела нет в списке. "+id));
    }

}
