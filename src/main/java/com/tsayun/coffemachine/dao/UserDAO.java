package com.tsayun.coffemachine.dao;

import com.tsayun.coffemachine.bean.User;
import com.tsayun.coffemachine.dao.exception.DAOException;

public interface UserDAO {
    void signIn(String login, String password) throws DAOException;
    void register(User user) throws DAOException;
}
