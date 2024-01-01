package com.ltweb_servlet_ecommerce.service.impl;

import com.ltweb_servlet_ecommerce.dao.IProductSizeDAO;
import com.ltweb_servlet_ecommerce.dao.ISizeDAO;
import com.ltweb_servlet_ecommerce.model.ProductSizeModel;
import com.ltweb_servlet_ecommerce.service.IProductSizeService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class ProductSizeService implements IProductSizeService {
    @Inject
    IProductSizeDAO productSizeDAO;

    @Override
    public ProductSizeModel findWithFilter(ProductSizeModel model) throws SQLException {
        return productSizeDAO.findWithFilter(model);
    }
    @Override
    public ProductSizeModel update(ProductSizeModel model) throws SQLException {
        ProductSizeModel oldProduct = productSizeDAO.findById(model.getId());
        model.setCreateAt(oldProduct.getCreateAt());
        model.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        productSizeDAO.update(model);
        return productSizeDAO.findById(model.getId());
    }

    @Override
    public ProductSizeModel delete(Long id) throws SQLException {
        ProductSizeModel oldModel = productSizeDAO.findById(id);
        productSizeDAO.delete(id);
        return oldModel;
    }

    @Override
    public List<ProductSizeModel> findAll() throws SQLException {
        return productSizeDAO.findAll();
    }

    @Override
    public ProductSizeModel findById(Long id) throws SQLException {
        return productSizeDAO.findById(id);
    }

    @Override
    public ProductSizeModel save(ProductSizeModel model) throws SQLException {
        Long productId = productSizeDAO.save(model);
        return productSizeDAO.findById(productId);
    }
}
