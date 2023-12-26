package com.ltweb_servlet_ecommerce.service.impl;

import com.ltweb_servlet_ecommerce.dao.ICategoryDAO;
import com.ltweb_servlet_ecommerce.model.CategoryModel;
import com.ltweb_servlet_ecommerce.service.ICategoryService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService {
    @Inject
    ICategoryDAO categoryDAO;

    @Override
    public List<CategoryModel> findAll() throws SQLException {
        return categoryDAO.findAll();
    }

    @Override
    public CategoryModel save(CategoryModel categoryModel) throws SQLException {
        Long categoryId = categoryDAO.save(categoryModel);
        return categoryDAO.findById(categoryId);
    }

    @Override
    public CategoryModel findById(Long id) throws SQLException {
        return categoryDAO.findById(id);
    }
}
