package com.xask.dao;

import java.util.List;

public interface Dao<E,T>{
    List<E>getAll();
    void save(E e);
    void get(T t);
    void delete(T t);
}
