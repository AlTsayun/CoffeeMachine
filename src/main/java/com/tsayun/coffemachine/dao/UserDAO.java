package com.tsayun.coffemachine.dao;

import com.tsayun.coffemachine.bean.User;
import com.tsayun.coffemachine.dao.exception.DAOException;

import java.util.UUID;

public interface UserDAO {
    void add(User user) throws DAOException;
    void remove(UUID id)throws DAOException;
    void update(User user)throws DAOException;
    void signIn(String login, String password) throws DAOException;
}
