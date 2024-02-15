package com.xask.controller;
import com.xask.database.dto.SecurityDTO;
import com.xask.database.entity.Security;
import com.xask.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/securities")
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityController {
    private final SecurityService securityService;
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Security> create(@RequestBody SecurityDTO dto){
        return mappingResponseSecurity(securityService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Security>>readAll(){
        return mappingResponseListSecurity(securityService.readAll());
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<List<Security>>readByDepartmentId(@PathVariable Integer id){
        return mappingResponseListSecurity(securityService.readByDepartmentId(id));
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping
    public ResponseEntity<Security>update(@RequestBody Security security){
        return mappingResponseSecurity(securityService.update(security));
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id){
        securityService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<Security>mappingResponseSecurity(Security security){
        return new ResponseEntity<>(security,HttpStatus.OK);
    }
    private ResponseEntity<List<Security>>mappingResponseListSecurity(List<Security>securities){
        return new ResponseEntity<>(securities,HttpStatus.OK);
    }
}
