package com.tsayun.coffemachine.dao;

import com.tsayun.coffemachine.bean.Drink;
import com.tsayun.coffemachine.bean.Order;
import com.tsayun.coffemachine.dao.exception.DAOException;

import java.util.UUID;

public interface OrderDAO {
    void add(Order order);
    void remove(UUID id);
    void update(Order order) throws DAOException;
    void complete (UUID idOrder);
}
