package com.ltweb_servlet_ecommerce.dao;

import com.ltweb_servlet_ecommerce.mapper.RowMapper;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMapper<T> rowMapper, List<Object> parameters, Class<T> modelClass) throws SQLException;
    Long insert(String sql, List<Object> parameters) throws SQLException;
    void update(String sql,  List<Object> parameters) throws SQLException;
    void delete(String sql,  List<Object> parameters) throws SQLException;
}

