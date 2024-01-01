package com.ltweb_servlet_ecommerce.service;

import com.ltweb_servlet_ecommerce.model.OrderModel;

import java.sql.SQLException;
import java.util.List;

public interface IOrderService {
    OrderModel findWithFilter(OrderModel model) throws SQLException;
    OrderModel save(OrderModel model) throws SQLException;
    OrderModel delete(Long id) throws SQLException;
    OrderModel update(OrderModel model) throws SQLException;
    OrderModel findById(Long id) throws SQLException;
    List<OrderModel> findAll() throws SQLException;
}
