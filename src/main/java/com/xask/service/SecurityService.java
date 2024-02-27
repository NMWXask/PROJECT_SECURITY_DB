package com.xask.service;

import com.xask.database.dto.SecurityDTO;
import com.xask.database.entity.Security;
import com.xask.repository.SecurityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityService {

    private final SecurityRepository securityRepository;
    private final DepartmentService departmentService;

    public Security create(SecurityDTO dto){

        Security security = Security.builder()
                .fullName(dto.getFullName())
                .department(departmentService.findById(dto.getDepartmentId()))
                .build();

        return securityRepository.save(security);
    }
    public List<Security> findByDepartmentId(Integer id){
        return securityRepository.findByDepartmentId(id);
    }

    public List<Security> findAll(){
        return securityRepository.findAll();
    }

    public Security update(Security security){
        return securityRepository.save(security);
    }

    public void delete(Integer id){
        securityRepository.deleteById(id);
    }
}
