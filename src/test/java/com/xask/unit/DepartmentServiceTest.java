package com.xask.unit;
import com.xask.database.entity.Department;
import com.xask.repository.DepartmentRepository;
import com.xask.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private DepartmentRepository departmentRepository;
    @InjectMocks
    private DepartmentService departmentService;

    @Test
    void findByIdTest() {
        Integer DEPARTMENT_ID = 1;
        Department department = new Department(1, "ГПУ", null);

        Mockito.when(departmentRepository.findById(DEPARTMENT_ID))
                .thenReturn(Optional.of(department));

        Department actualResult = departmentService.findById(DEPARTMENT_ID);

        assertEquals(department, actualResult);

        verify(departmentRepository, times(1)).findById(DEPARTMENT_ID);
    }

    @Test
    void findAllTest() {
        List<Department>departments = new ArrayList<>();
        departments.add(new Department(1,"ГПУ",null));
        departments.add(new Department(2,"УСТ 250",null));
        departments.add(new Department(3,"ЗО",null));

        Mockito.when(departmentRepository.findAll()).thenReturn(departments);

        List<Department> actualResult = departmentService.findAll();

        assertEquals(departments,actualResult);

        verify(departmentRepository, times(1)).findAll();
    }
}
