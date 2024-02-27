package com.xask.unit;
import com.xask.database.dto.SecurityDTO;
import com.xask.database.entity.Department;
import com.xask.database.entity.Security;
import com.xask.repository.SecurityRepository;
import com.xask.service.DepartmentService;
import com.xask.service.SecurityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SecurityServiceTest {
    @Mock
    private SecurityRepository securityRepository;
    @Mock
    private DepartmentService departmentService;
    @InjectMocks
    private SecurityService securityService;


    @Test
    public void createTest(){

        Department department = new Department();
        department.setId(1);

        SecurityDTO dto = new SecurityDTO();
        dto.setFullName("Ivanov Ivan Ivanovich");
        dto.setDepartmentId(department.getId());



        Mockito.when(departmentService.findById(dto.getDepartmentId()))
                .thenReturn(department);

        var expectedSecurity = Security.builder()
                .fullName(dto.getFullName())
                .department(department)
                .build();

        Mockito.when(securityRepository.save(expectedSecurity))
                .thenReturn(expectedSecurity);

        Security actualSecurity = securityService.create(dto);

        assertEquals(expectedSecurity,actualSecurity);

        verify(departmentService,times(1)).findById(dto.getDepartmentId());
        verify(securityRepository,times(1)).save(expectedSecurity);
    }

    @Test
    public void findByDepartmentIdTest(){
        Integer departmentId = 1;

        Department department = new Department();
        department.setId(departmentId);

        List<Security> expectedSecurityList = new ArrayList<>();

        expectedSecurityList.add(new Security());
        expectedSecurityList.add(new Security());


        Mockito.when(securityRepository.findByDepartmentId(departmentId))
                .thenReturn(expectedSecurityList);

        List<Security>actualSecurityList = securityService.findByDepartmentId(departmentId);

        assertEquals(expectedSecurityList,actualSecurityList);

        verify(securityRepository, times(1)).findByDepartmentId(departmentId);
    }
}
