package com.tsayun.coffemachine.dao;

import com.tsayun.coffemachine.bean.Drink;
import com.tsayun.coffemachine.dao.exception.DAOException;

import java.util.UUID;

public interface DrinkDAO {
    void add(Drink drink) throws DAOException;
    void remove (UUID id) throws DAOException;
    void update(Drink drink) throws DAOException;
}
