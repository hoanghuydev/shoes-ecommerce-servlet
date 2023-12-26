package com.ltweb_servlet_ecommerce.service;

import com.ltweb_servlet_ecommerce.model.ProductModel;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    ProductModel findById(Long id) throws SQLException;
    ProductModel save(ProductModel productModel) throws SQLException;
    ProductModel update(ProductModel productModel) throws SQLException;
    ProductModel delete(Long id) throws SQLException;
    List<ProductModel> findAll() throws SQLException;
}
