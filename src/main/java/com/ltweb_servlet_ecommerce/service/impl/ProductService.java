package com.ltweb_servlet_ecommerce.service.impl;

import com.ltweb_servlet_ecommerce.dao.IProductDAO;
import com.ltweb_servlet_ecommerce.model.ProductModel;
import com.ltweb_servlet_ecommerce.model.SizeModel;
import com.ltweb_servlet_ecommerce.service.IProductService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class ProductService implements IProductService {
@Inject
    IProductDAO productDAO;
    @Override
    public ProductModel findWithFilter(ProductModel model) throws SQLException {
        return productDAO.findWithFilter(model);
    }
    @Override
    public ProductModel update(ProductModel productModel) throws SQLException {
        ProductModel oldProduct = productDAO.findById(productModel.getId());
        productModel.setCreateAt(oldProduct.getCreateAt());
        productModel.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        productDAO.update(productModel);
        return productDAO.findById(productModel.getId());
    }

    @Override
    public ProductModel delete(Long id) throws SQLException {
        ProductModel oldProduct = productDAO.findById(id);
        productDAO.delete(id);
        return oldProduct;
    }

    @Override
    public List<ProductModel> findAll() throws SQLException {
        return productDAO.findAll();
    }

    @Override
    public ProductModel findById(Long id) throws SQLException {
        return productDAO.findById(id);
    }

    @Override
    public ProductModel save(ProductModel productModel) throws SQLException {
        Long productId = productDAO.save(productModel);
        return productDAO.findById(productId);
    }
}
