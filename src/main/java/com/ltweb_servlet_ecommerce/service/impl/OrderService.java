package com.ltweb_servlet_ecommerce.service.impl;

import com.ltweb_servlet_ecommerce.dao.IOrderDAO;
import com.ltweb_servlet_ecommerce.dao.IProductDAO;
import com.ltweb_servlet_ecommerce.model.OrderModel;
import com.ltweb_servlet_ecommerce.service.IOrderService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class OrderService implements IOrderService {
    @Inject
    IOrderDAO orderDAO;
    @Override
    public OrderModel update(OrderModel productModel) throws SQLException {
        OrderModel oldProduct = orderDAO.findById(productModel.getId());
        productModel.setCreateAt(oldProduct.getCreateAt());
        productModel.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        orderDAO.update(productModel);
        return orderDAO.findById(productModel.getId());
    }

    @Override
    public OrderModel delete(Long id) throws SQLException {
        OrderModel oldProduct = orderDAO.findById(id);
        orderDAO.delete(id);
        return null;
    }

    @Override
    public List<OrderModel> findAll() throws SQLException {
        return orderDAO.findAll();
    }

    @Override
    public OrderModel findById(Long id) throws SQLException {
        return orderDAO.findById(id);
    }

    @Override
    public OrderModel save(OrderModel productModel) throws SQLException {
        Long productId = orderDAO.save(productModel);
        return orderDAO.findById(productId);
    }
}
