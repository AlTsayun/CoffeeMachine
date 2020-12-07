package com.tsayun.coffemachine.service;

import com.tsayun.coffemachine.bean.DrinkInStorage;
import com.tsayun.coffemachine.bean.DrinkToOrder;
import com.tsayun.coffemachine.bean.Ingredient;
import com.tsayun.coffemachine.service.exception.ServiceException;

import java.math.BigDecimal;
import java.util.UUID;

public interface AdminService {
    DrinkInStorage addDrink(DrinkInStorage drinkInStorage) throws ServiceException;
    void removeDrink(UUID drinkInStorageId) throws ServiceException;
    DrinkInStorage refillDrinkInStorage(UUID drinkInStorageId, Long quantity) throws ServiceException;
    DrinkInStorage updateDrinkPrice(UUID drinkInStorageId, BigDecimal price) throws ServiceException;

    Ingredient addIngredient(Ingredient ingredient) throws ServiceException;
    void removeIngredient(UUID ingredientId) throws ServiceException;
    void refillIngredient(UUID ingredientId, Float quantity) throws ServiceException;
}
