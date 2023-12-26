package com.ltweb_servlet_ecommerce.dao;

import com.ltweb_servlet_ecommerce.model.ProductModel;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<ProductModel> findAll() throws SQLException;
    ProductModel findById(Long id) throws SQLException;
    Long save(ProductModel productModel) throws SQLException;
    void update(ProductModel productModel) throws SQLException;
    void delete(Long id) throws SQLException;

}
