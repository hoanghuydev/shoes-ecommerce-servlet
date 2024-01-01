package com.ltweb_servlet_ecommerce.dao;

import com.ltweb_servlet_ecommerce.model.ProductSizeModel;

import java.sql.SQLException;
import java.util.List;

public interface IProductSizeDAO {
    List<ProductSizeModel> findAll() throws SQLException;
    ProductSizeModel findById(Long id) throws SQLException;
    ProductSizeModel findWithFilter(ProductSizeModel model) throws SQLException;
    Long save(ProductSizeModel model) throws SQLException;
    void update(ProductSizeModel model) throws SQLException;
    void delete(Long id) throws SQLException;
}
