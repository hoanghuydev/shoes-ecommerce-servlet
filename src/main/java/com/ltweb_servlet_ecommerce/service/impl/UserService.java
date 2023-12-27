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
    public UserModel findWithFilter(UserModel userModel) throws SQLException {
        return userDAO.findWithFilter(userModel);
    }

    @Override
    public UserModel save(UserModel userModel) throws SQLException {
        userModel.setCreateAt(new Timestamp(System.currentTimeMillis()));
        Long userId = userDAO.save(userModel);
        return userDAO.findById(userId);
    }

    @Override
    public UserModel delete(Long id) throws SQLException {
        UserModel oldProduct = userDAO.findById(id);
        userDAO.delete(id);
        return oldProduct;

    }

    @Override
    public UserModel update(UserModel userModel) throws SQLException {
        UserModel oldProduct = userDAO.findById(userModel.getId());
        userModel.setCreateAt(oldProduct.getCreateAt());
        userModel.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        userDAO.update(userModel);
        return userDAO.findById(userModel.getId());
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
