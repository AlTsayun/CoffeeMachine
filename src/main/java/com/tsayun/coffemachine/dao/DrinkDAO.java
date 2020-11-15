package com.tsayun.coffemachine.dao;

import com.tsayun.coffemachine.bean.Drink;
import com.tsayun.coffemachine.dao.exception.DAOException;

public interface DrinkDAO {
    void add(Drink drink) throws DAOException;
}
