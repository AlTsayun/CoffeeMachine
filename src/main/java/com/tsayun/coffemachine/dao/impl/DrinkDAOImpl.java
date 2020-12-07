package com.tsayun.coffemachine.dao.impl;

import com.tsayun.coffemachine.bean.DrinkInStorage;
import com.tsayun.coffemachine.dao.DrinkDAO;
import com.tsayun.coffemachine.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

public class DrinkDAOImpl extends AbstractJDBCDAO<DrinkInStorage, UUID> implements DrinkDAO {
    public DrinkDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    public DrinkInStorage refill(UUID id, Long quantity) throws DAOException {
        DrinkInStorage drinkInStorage = get(id);
        drinkInStorage.setQuantity(drinkInStorage.getQuantity() + quantity);
        return update(drinkInStorage);
    }

    @Override
    public DrinkInStorage drain(UUID id, Long quantity) throws DAOException {
        DrinkInStorage drinkInStorage = get(id);
        drinkInStorage.setQuantity(drinkInStorage.getQuantity() - quantity);
        return update(drinkInStorage);
    }

    @Override
    protected String getSelectQuery() {
        return null;
    }

    @Override
    protected String getDeleteQuery() {
        return null;
    }

    @Override
    protected String getUpdateQuery() {
        return null;
    }

    @Override
    protected String getCreateQuery() {
        return null;
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, UUID id) {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, DrinkInStorage item) {

    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, DrinkInStorage newItem) {

    }

    @Override
    protected List<DrinkInStorage> parseResultSet(ResultSet rs) {
        return null;
    }
}
