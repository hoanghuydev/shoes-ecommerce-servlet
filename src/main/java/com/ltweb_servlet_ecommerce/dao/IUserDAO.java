package com.ltweb_servlet_ecommerce.dao;

import com.ltweb_servlet_ecommerce.model.UserModel;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    List<UserModel> findAll() throws SQLException;
    UserModel findById(Long id) throws SQLException;
    UserModel findWithFilter(UserModel userModel) throws SQLException;
    Long save(UserModel userModel) throws SQLException;
    void delete(Long id) throws SQLException;
    void update(UserModel userModel) throws SQLException;
}
