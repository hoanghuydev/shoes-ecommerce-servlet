package com.ltweb_servlet_ecommerce.dao.impl;


import com.ltweb_servlet_ecommerce.dao.GenericDAO;
import com.ltweb_servlet_ecommerce.mapper.RowMapper;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;

public class AbstractDAO<T> implements GenericDAO<T> {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Lưu trong /bin/setenv.bat của tomcat
            ResourceBundle resourceBundle = ResourceBundle.getBundle("env");
            return DriverManager.getConnection(resourceBundle.getString("DB_URL"), resourceBundle.getString("DB_USERNAME"), resourceBundle.getString("DB_PASSWORD"));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, List<Object> parameters, Class<T> modelClass) throws SQLException {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (parameters != null) {
                setParameter(preparedStatement, parameters);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet, modelClass));
            }
            return results;
        } catch (SQLException e) {
            return null;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
            if (results != null && preparedStatement != null) {
                preparedStatement.close();
                resultSet.close();
            }
        }

    }

    @Override
    public Long insert(String sql, List<Object> parameters) throws SQLException {
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(preparedStatement, parameters);
            preparedStatement.executeUpdate();
            rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                connection.commit();
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            return null;
        } finally {
            connection.close();
            if (rs != null && preparedStatement != null) {
                preparedStatement.close();
                rs.close();
            }
        }
        return null;
    }

    @Override
    public void update(String sql, List<Object> parameters) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            setParameter(preparedStatement, parameters);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
        } finally {
            connection.close();
            if (preparedStatement != null) {
                preparedStatement.close();

            }
        }
    }

    @Override
    public void delete(String sql, List<Object> parameters) throws SQLException {
        this.update(sql, parameters);
    }


    private void setParameter(PreparedStatement preparedStatement, List<Object> parameters) {
        try {
            for (int i = 0; i < parameters.size(); i++) {
                int index = i + 1;
                preparedStatement.setObject(index, parameters.get(i));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}