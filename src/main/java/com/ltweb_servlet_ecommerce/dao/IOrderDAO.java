package com.ltweb_servlet_ecommerce.dao;

import com.ltweb_servlet_ecommerce.model.OrderModel;
import com.ltweb_servlet_ecommerce.model.OrderModel;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDAO {
    List<OrderModel> findAll() throws SQLException;
    OrderModel findById(Long id) throws SQLException;
    OrderModel findWithFilter(OrderModel model) throws SQLException;
    Long save(OrderModel model) throws SQLException;
    void update(OrderModel model) throws SQLException;
    void delete(Long id) throws SQLException;
}
