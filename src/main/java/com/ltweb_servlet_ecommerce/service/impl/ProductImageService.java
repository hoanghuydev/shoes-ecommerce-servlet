package com.ltweb_servlet_ecommerce.service.impl;

import com.ltweb_servlet_ecommerce.dao.IOrderDAO;
import com.ltweb_servlet_ecommerce.dao.IProductImageDAO;
import com.ltweb_servlet_ecommerce.model.ProductImageModel;
import com.ltweb_servlet_ecommerce.model.ProductImageModel;
import com.ltweb_servlet_ecommerce.service.IProductImageService;
import com.ltweb_servlet_ecommerce.service.IProductService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class ProductImageService implements IProductImageService {
@Inject IProductImageDAO productImageDAO;
    @Override
    public ProductImageModel findWithFilter(ProductImageModel model) throws SQLException {
        return productImageDAO.findWithFilter(model);
    }
    @Override
    public ProductImageModel update(ProductImageModel model) throws SQLException {
        ProductImageModel oldProduct = productImageDAO.findById(model.getId());
        model.setCreateAt(oldProduct.getCreateAt());
        model.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        productImageDAO.update(model);
        return productImageDAO.findById(model.getId());
    }

    @Override
    public ProductImageModel delete(Long id) throws SQLException {
        ProductImageModel oldModel = productImageDAO.findById(id);
        productImageDAO.delete(id);
        return oldModel;
    }

    @Override
    public List<ProductImageModel> findAll() throws SQLException {
        return productImageDAO.findAll();
    }

    @Override
    public ProductImageModel findById(Long id) throws SQLException {
        return productImageDAO.findById(id);
    }

    @Override
    public ProductImageModel save(ProductImageModel model) throws SQLException {
        Long productId = productImageDAO.save(model);
        return productImageDAO.findById(productId);
    }
}
