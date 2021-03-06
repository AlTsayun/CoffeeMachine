package com.tsayun.coffemachine.dao.factory.impl;

import com.tsayun.coffemachine.dao.DrinkDAO;
import com.tsayun.coffemachine.dao.IngredientDAO;
import com.tsayun.coffemachine.dao.OrderDAO;
import com.tsayun.coffemachine.dao.UserDAO;
import com.tsayun.coffemachine.dao.factory.DAOFactory;
import com.tsayun.coffemachine.dao.impl.DrinkDAOImpl;

public class DAOFactoryImpl implements DAOFactory {

    private static final DAOFactoryImpl instance = new DAOFactoryImpl();
//    private static final DrinkDAO drinkDAO = new DrinkDAOImpl();

    public static DAOFactory getInstance(){
        return instance;
    }

    private DAOFactoryImpl(){}

    @Override
    public DrinkDAO getDrinkDAO() {
        return null;
    }

    @Override
    public OrderDAO getOrderDAO() {
        return null;
    }

    @Override
    public UserDAO getUserDAO() {
        return null;
    }

    @Override
    public IngredientDAO getIngredientDAO() {
        return null;
    }
}
