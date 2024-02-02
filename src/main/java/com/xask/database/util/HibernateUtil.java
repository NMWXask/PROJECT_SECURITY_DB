package com.xask.database.config;
import com.xask.database.converter.BirthDayConverter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static Configuration hibernateConfig(){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAttributeConverter(new BirthDayConverter(),true);
        return configuration;
    }

    public static SessionFactory createSessionFactory(){
        return HibernateUtil.hibernateConfig().buildSessionFactory();
    }
    public static Session openSession(){
        return createSessionFactory().openSession();
    }

}
