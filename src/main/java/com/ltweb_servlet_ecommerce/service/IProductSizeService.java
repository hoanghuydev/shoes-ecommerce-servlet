package com.ltweb_servlet_ecommerce.service;

import com.ltweb_servlet_ecommerce.model.ProductSizeModel;

import java.sql.SQLException;
import java.util.List;

public interface IProductSizeService {
    ProductSizeModel findWithFilter(ProductSizeModel model) throws SQLException;
    ProductSizeModel save(ProductSizeModel model) throws SQLException;
    ProductSizeModel delete(Long id) throws SQLException;
    ProductSizeModel update(ProductSizeModel model) throws SQLException;
    ProductSizeModel findById(Long id) throws SQLException;
    List<ProductSizeModel> findAll() throws SQLException;
}
