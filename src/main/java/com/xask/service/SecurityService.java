package com.xask.service;

import com.xask.database.dto.SecurityDTO;
import com.xask.database.entity.Security;
import com.xask.repository.SecurityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SecurityService {

    private final SecurityRepository securityRepository;
    private final DepartmentService departmentService;

    public Security create(SecurityDTO dto){
        String fullName = dto.getName()+ " "+dto.getSecondName()+" "+dto.getSurname();

        Security security = Security.builder()
                .fullName(fullName)
                .department(departmentService.readById(dto.getDepartmentId()))
                .build();

        return securityRepository.save(security);
    }
    public List<Security>readByDepartmentId(Integer id){
        return securityRepository.findByDepartment(id);
    }

    public List<Security>returnAll(){
        return securityRepository.findAll();
    }

    public Security update(Security security){
        return securityRepository.save(security);
    }

    public void delete(Integer id){
        securityRepository.deleteById(id);
    }
}
