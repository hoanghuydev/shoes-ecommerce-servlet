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
    public OrderModel findWithFilter(OrderModel model) throws SQLException {
        return orderDAO.findWithFilter(model);
    }
    @Override
    public OrderModel update(OrderModel model) throws SQLException {
        OrderModel oldProduct = orderDAO.findById(model.getId());
        model.setCreateAt(oldProduct.getCreateAt());
        model.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        orderDAO.update(model);
        return orderDAO.findById(model.getId());
    }

    @Override
    public OrderModel delete(Long id) throws SQLException {
        OrderModel oldModel = orderDAO.findById(id);
        orderDAO.delete(id);
        return oldModel;
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
    public OrderModel save(OrderModel model) throws SQLException {
        Long productId = orderDAO.save(model);
        return orderDAO.findById(productId);
    }
}
