package com.tsayun.coffemachine.dao;

import com.tsayun.coffemachine.bean.Order;
import com.tsayun.coffemachine.dao.exception.DAOException;

import java.util.UUID;

public interface OrderDAO extends GenericDAO<Order, UUID> {
    Order complete(UUID idOrder) throws DAOException;
}
