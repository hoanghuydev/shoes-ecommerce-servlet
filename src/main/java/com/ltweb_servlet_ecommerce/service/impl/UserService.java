package com.ltweb_servlet_ecommerce.service.impl;

import com.ltweb_servlet_ecommerce.dao.IUserDAO;
import com.ltweb_servlet_ecommerce.model.ProductModel;
import com.ltweb_servlet_ecommerce.model.UserModel;
import com.ltweb_servlet_ecommerce.service.IUserService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class UserService implements IUserService {
    @Inject
    IUserDAO userDAO;
    @Override
    public UserModel findWithFilter(UserModel model) throws SQLException {
        return userDAO.findWithFilter(model);
    }

    @Override
    public UserModel save(UserModel model) throws SQLException {
        model.setCreateAt(new Timestamp(System.currentTimeMillis()));
        Long userId = userDAO.save(model);
        return userDAO.findById(userId);
    }

    @Override
    public UserModel delete(Long id) throws SQLException {
        UserModel oldProduct = userDAO.findById(id);
        userDAO.delete(id);
        return oldProduct;

    }

    @Override
    public UserModel update(UserModel model) throws SQLException {
        UserModel oldProduct = userDAO.findById(model.getId());
        model.setCreateAt(oldProduct.getCreateAt());
        model.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        userDAO.update(model);
        return userDAO.findById(model.getId());
    }

    @Override
    public UserModel findById(Long id) throws SQLException {
        return userDAO.findById(id);
    }

    @Override
    public List<UserModel> findAll() throws SQLException {
        return userDAO.findAll();
    }
}
