package com.tsayun.coffemachine.dao;

import com.tsayun.coffemachine.bean.Drink;
import com.tsayun.coffemachine.bean.Ingredient;
import com.tsayun.coffemachine.dao.exception.DAOException;

import java.util.UUID;

public interface IngredientDAO {
    void add(Ingredient ingredient) throws DAOException;
    void remove (UUID id) throws DAOException;
    void update(Drink drink) throws DAOException;
    void refill(UUID id, float quantity) throws DAOException;
    void drain(UUID id, float quantity) throws DAOException;
}
