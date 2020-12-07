package com.tsayun.coffemachine.dao;

import com.tsayun.coffemachine.bean.DrinkInStorage;
import com.tsayun.coffemachine.dao.exception.DAOException;

import java.util.UUID;

public interface DrinkDAO extends GenericDAO<DrinkInStorage, UUID> {
    DrinkInStorage refill(UUID id, Long quantity) throws DAOException;
    DrinkInStorage drain(UUID id, Long quantity) throws DAOException;
}
