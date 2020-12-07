package com.tsayun.coffemachine.service;

import com.tsayun.coffemachine.bean.User;
import com.tsayun.coffemachine.service.exception.ServiceException;

import java.util.UUID;

public interface ClientService {
    User authorize(String login, String password) throws ServiceException;
    User register(User user) throws ServiceException;
    void addToCart(UUID userId, UUID drinkId) throws ServiceException;
    void removeFromCart(UUID userId, UUID drinkId) throws ServiceException;
    void orderCart(UUID userId) throws ServiceException;
}
