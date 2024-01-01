package com.ltweb_servlet_ecommerce.dao;

import com.ltweb_servlet_ecommerce.model.CategoryModel;
import com.ltweb_servlet_ecommerce.model.CategoryModel;
import com.ltweb_servlet_ecommerce.model.CategoryModel;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO {
    List<CategoryModel> findAll() throws SQLException;
    CategoryModel findById(Long id) throws SQLException;
    CategoryModel findWithFilter(CategoryModel model) throws SQLException;
    Long save(CategoryModel model) throws SQLException;
    void update(CategoryModel model) throws SQLException;
    void delete(Long id) throws SQLException;
}
