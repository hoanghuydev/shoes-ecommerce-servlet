package com.ltweb_servlet_ecommerce.service;

import com.ltweb_servlet_ecommerce.model.CategoryModel;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll() throws SQLException;
    CategoryModel save(CategoryModel categoryModel) throws SQLException;
    CategoryModel findById(Long id) throws SQLException;
}
