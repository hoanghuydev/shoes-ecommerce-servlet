package com.ltweb_servlet_ecommerce.service.impl;

import com.ltweb_servlet_ecommerce.dao.ICategoryDAO;
import com.ltweb_servlet_ecommerce.model.CategoryModel;
import com.ltweb_servlet_ecommerce.model.CategoryModel;
import com.ltweb_servlet_ecommerce.service.ICategoryService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class CategoryService implements ICategoryService {
    @Inject
    ICategoryDAO categoryDAO;

    @Override
    public CategoryModel findWithFilter(CategoryModel model) throws SQLException {
        return categoryDAO.findWithFilter(model);
    }

    @Override
    public CategoryModel save(CategoryModel model) throws SQLException {
        model.setCreateAt(new Timestamp(System.currentTimeMillis()));
        Long userId = categoryDAO.save(model);
        return categoryDAO.findById(userId);
    }

    @Override
    public CategoryModel delete(Long id) throws SQLException {
        CategoryModel oldProduct = categoryDAO.findById(id);
        categoryDAO.delete(id);
        return oldProduct;

    }

    @Override
    public CategoryModel update(CategoryModel model) throws SQLException {
        CategoryModel oldProduct = categoryDAO.findById(model.getId());
        model.setCreateAt(oldProduct.getCreateAt());
        model.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        categoryDAO.update(model);
        return categoryDAO.findById(model.getId());
    }

    @Override
    public CategoryModel findById(Long id) throws SQLException {
        return categoryDAO.findById(id);
    }

    @Override
    public List<CategoryModel> findAll() throws SQLException {
        return categoryDAO.findAll();
    }
}
