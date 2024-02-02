package com.xask.dao;

import com.xask.config.DatabaseSession;
import com.xask.entity.Security;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SecurityDaoImpl implements Dao<Security,Integer>{
    private EntityManager entityManager;
    @Override
    public List<Security> getAll() {
        var session = entityManager.unwrap(Session.class);
        List<Security>allSecurities = new ArrayList<>();

        return null;
    }

    @Override
    public void save(Security security) {

    }


    public void save(String fullName,String gender,LocalDate birthDate,int departmentId) {
        try (var session = DatabaseSession.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(Security.builder()
                    .fullName(fullName)
                    .gender(gender)
                    .birthDate(birthDate)
                    .departmentId(departmentId).build());

            session.getTransaction().commit();
        }
    }

    @Override
    public void get(Integer integer) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
