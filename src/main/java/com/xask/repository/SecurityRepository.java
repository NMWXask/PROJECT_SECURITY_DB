package com.xask.repository;

import com.xask.database.entity.Security;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecurityRepository extends JpaRepository<Security,Integer> {
    List<Security> findByDepartment(Integer id);
}
