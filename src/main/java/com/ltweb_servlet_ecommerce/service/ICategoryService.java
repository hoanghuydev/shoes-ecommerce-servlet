package com.ltweb_servlet_ecommerce.service;

import com.ltweb_servlet_ecommerce.model.CategoryModel;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    CategoryModel findWithFilter(CategoryModel model) throws SQLException;
    CategoryModel save(CategoryModel model) throws SQLException;
    CategoryModel delete(Long id) throws SQLException;
    CategoryModel update(CategoryModel model) throws SQLException;
    CategoryModel findById(Long id) throws SQLException;
    List<CategoryModel> findAll() throws SQLException;
}
