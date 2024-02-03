package com.xask.repository;

import com.xask.database.util.HibernateUtil;
import com.xask.database.entity.Security;

import java.util.List;

public class SecurityRepositoryImpl {


    public List<Security> getAll() {

        List<Security> allSecurities;

        try (var session = HibernateUtil.openSession()) {
            session.beginTransaction();

            allSecurities = session.createQuery("FROM Security", Security.class).getResultList();


            session.getTransaction().commit();
        }


        return allSecurities;
    }
    //разобраться с этим методом уточнить должен принимать все аргументы или только объект класса

    public Security save(Security security) {
        try (var session = HibernateUtil.openSession()){
            session.beginTransaction();

            security = (Security) session.save(security);

            session.getTransaction().commit();
        }
        return security;
    }


    public void get(Integer id) {


        Security security;
        try (var session = HibernateUtil.openSession()) {
            session.beginTransaction();

            security = session.get(Security.class, id);

            session.getTransaction().commit();
        }

        System.out.println(security);
    }


    public void delete(Integer id) {

        Security security = Security.builder().id(id).build();

        try (var session = HibernateUtil.openSession()) {
            session.beginTransaction();

            session.delete(security);

            session.getTransaction().commit();
        }
    }

}
