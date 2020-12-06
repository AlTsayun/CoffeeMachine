package com.tsayun.coffemachine.dao.factory;

import com.tsayun.coffemachine.dao.DrinkDAO;
import com.tsayun.coffemachine.dao.IngredientDAO;
import com.tsayun.coffemachine.dao.OrderDAO;
import com.tsayun.coffemachine.dao.UserDAO;

public interface DAOFactory {
    DrinkDAO getDrinkDAO();
    OrderDAO getOrderDAO();
    UserDAO getUserDAO();
    IngredientDAO getIngredientDAO();
}
