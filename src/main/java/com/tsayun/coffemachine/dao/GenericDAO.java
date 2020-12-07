package com.tsayun.coffemachine.dao;

import com.tsayun.coffemachine.bean.DrinkInStorage;
import com.tsayun.coffemachine.dao.exception.DAOException;

import java.util.List;
import java.util.UUID;

public interface GenericDAO<T, PK> {
    T get(PK key) throws DAOException;
    List<T> getAll(long from, long count) throws DAOException;
    T add(T newItem) throws DAOException;
    void remove (PK id) throws DAOException;
    T update(T item) throws DAOException;
}
