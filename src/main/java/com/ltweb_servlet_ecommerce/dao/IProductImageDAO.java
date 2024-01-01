package com.ltweb_servlet_ecommerce.dao;

import com.ltweb_servlet_ecommerce.model.ProductImageModel;

import java.sql.SQLException;
import java.util.List;

public interface IProductImageDAO {
    List<ProductImageModel> findAll() throws SQLException;
    ProductImageModel findById(Long id) throws SQLException;
    ProductImageModel findWithFilter(ProductImageModel model) throws SQLException;
    Long save(ProductImageModel model) throws SQLException;
    void update(ProductImageModel model) throws SQLException;
    void delete(Long id) throws SQLException;
}
