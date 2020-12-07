package com.tsayun.coffemachine.dao;

import com.tsayun.coffemachine.bean.User;
import com.tsayun.coffemachine.dao.exception.DAOException;

import java.util.UUID;

public interface UserDAO extends GenericDAO<User, UUID> {
    User signIn(String login, String password) throws DAOException;
}
