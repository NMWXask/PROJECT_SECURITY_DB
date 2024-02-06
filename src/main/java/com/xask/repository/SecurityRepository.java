package com.xask.repository;

import com.xask.database.entity.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SecurityRepository extends JpaRepository<Security,Integer> {
    List<Security> findByDepartmentId(Integer id);
}
