package com.tsayun.coffemachine.dao;

import com.tsayun.coffemachine.bean.Ingredient;
import com.tsayun.coffemachine.dao.exception.DAOException;

import java.util.UUID;

public interface IngredientDAO extends GenericDAO<Ingredient, UUID> {
    Ingredient refill(UUID id, Float quantity) throws DAOException;
    Ingredient drain(UUID id, Float quantity) throws DAOException;
}
