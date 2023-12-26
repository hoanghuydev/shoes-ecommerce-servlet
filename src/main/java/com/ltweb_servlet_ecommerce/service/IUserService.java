package com.ltweb_servlet_ecommerce.service;

import com.ltweb_servlet_ecommerce.model.UserModel;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    UserModel findWithFilter(UserModel userModel) throws SQLException;
    UserModel save(UserModel userModel) throws SQLException;
    UserModel delete(Long id) throws SQLException;
    UserModel update(UserModel userModel) throws SQLException;
    UserModel findById(Long id) throws SQLException;
    List<UserModel> findAll() throws SQLException;

}
