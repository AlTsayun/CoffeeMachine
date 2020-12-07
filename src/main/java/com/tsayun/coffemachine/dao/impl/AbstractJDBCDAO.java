package com.tsayun.coffemachine.dao.impl;

import com.tsayun.coffemachine.dao.GenericDAO;
import com.tsayun.coffemachine.dao.exception.DAOException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Абстрактный класс предоставляющий базовую реализацию CRUD операций с использованием JDBC.
 *
 * @param <T>  тип объекта персистенции
 * @param <PK> тип первичного ключа
 */
public abstract class AbstractJDBCDAO<T, PK extends Serializable> implements GenericDAO<T, PK> {

    private Connection connection;

    /**
     * Возвращает sql запрос для получения всех записей.
     * <p/>
     * SELECT * FROM [Table]
     */
    protected abstract String getSelectQuery();

    /**
     * Возвращает sql запрос для удаления записи.
     * <p/>
     * DELETE FROM [Table]
     */
    protected abstract String getDeleteQuery();

    /**
     * Возвращает sql запрос для обновления записи.
     * <p/>
     * UPDATE [Table] SET [column1] = ?, [column2] = ?, [...]
     */
    protected abstract String getUpdateQuery();

    /**
     * Возвращает sql запрос для создания записи.
     * <p/>
     * INSERT INTO [Table] SET ([column1], [column2], [...]) VALUES (?, ?, [...])
     */
    protected abstract String getCreateQuery();


    protected abstract void prepareStatementForDelete(PreparedStatement statement, PK id);

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T item);

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T newItem);


    /**
     * Разбирает ResultSet и возвращает список объектов соответствующих содержимому ResultSet.
     */
    protected abstract List<T> parseResultSet(ResultSet rs);

    @Override
    public T get(PK key) throws DAOException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            toDo: replace setObject with something more suitable
            statement.setObject(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new DAOException("Received more than one record.");
        }
        return list.iterator().next();
    }

    @Override
    public List<T> getAll(long from, long count) throws DAOException {
        List<T> list;
        String sql = getSelectQuery();
        sql +=" LIMIT ?, ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, from);
            statement.setLong(2, count);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return list;
    }

    @Override
    public T add(T newItem) throws DAOException {
        T persistInstance;
        // Добавляем запись
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, newItem);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DAOException("On persist modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
        // Получаем только что вставленную запись
        sql = getSelectQuery() + "WHERE id = last_insert_id();";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if ((list == null) || (list.size() != 1)) {
                throw new DAOException("Exception on finding created row.");
            }
            persistInstance = list.iterator().next();
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return persistInstance;
    }

    @Override
    public void remove(PK id) throws DAOException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForDelete(statement, id); // заполнение аргументов запроса оставим на совесть потомков
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DAOException("On delete modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }


    @Override
    public T update(T item) throws DAOException {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            prepareStatementForUpdate(statement, item); // заполнение аргументов запроса оставим на совесть потомков
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DAOException("On update modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
        //toDo: check if there is a need for getting item from database
        return item;
    }



    public AbstractJDBCDAO(Connection connection) {
        this.connection = connection;
    }
}