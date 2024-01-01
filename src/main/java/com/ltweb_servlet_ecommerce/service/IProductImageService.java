package com.ltweb_servlet_ecommerce.service;

import com.ltweb_servlet_ecommerce.model.ProductImageModel;

import java.sql.SQLException;
import java.util.List;

public interface IProductImageService {
    ProductImageModel findWithFilter(ProductImageModel model) throws SQLException;
    ProductImageModel save(ProductImageModel model) throws SQLException;
    ProductImageModel delete(Long id) throws SQLException;
    ProductImageModel update(ProductImageModel model) throws SQLException;
    ProductImageModel findById(Long id) throws SQLException;
    List<ProductImageModel> findAll() throws SQLException;
}
