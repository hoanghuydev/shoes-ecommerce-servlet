package com.ltweb_servlet_ecommerce.service;

import com.ltweb_servlet_ecommerce.model.OrderModel;

import java.sql.SQLException;
import java.util.List;

public interface IOrderService {
    OrderModel findById(Long id) throws SQLException;
    OrderModel save(OrderModel productModel) throws SQLException;
    OrderModel update(OrderModel productModel) throws SQLException;
    OrderModel delete(Long id) throws SQLException;
    List<OrderModel> findAll() throws SQLException;
}
