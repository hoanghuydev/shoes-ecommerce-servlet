package com.ltweb_servlet_ecommerce.service.impl;

import com.ltweb_servlet_ecommerce.dao.IOrderDAO;
import com.ltweb_servlet_ecommerce.dao.ISizeDAO;
import com.ltweb_servlet_ecommerce.model.SizeModel;
import com.ltweb_servlet_ecommerce.model.UserModel;
import com.ltweb_servlet_ecommerce.service.ISizeService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class SizeService implements ISizeService {
    @Inject
    ISizeDAO sizeDAO;

    @Override
    public SizeModel findWithFilter(SizeModel model) throws SQLException {
        return sizeDAO.findWithFilter(model);
    }
    @Override
    public SizeModel update(SizeModel model) throws SQLException {
        SizeModel oldProduct = sizeDAO.findById(model.getId());
        model.setCreateAt(oldProduct.getCreateAt());
        model.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        sizeDAO.update(model);
        return sizeDAO.findById(model.getId());
    }

    @Override
    public SizeModel delete(Long id) throws SQLException {
        SizeModel oldModel = sizeDAO.findById(id);
        sizeDAO.delete(id);
        return oldModel;
    }

    @Override
    public List<SizeModel> findAll() throws SQLException {
        return sizeDAO.findAll();
    }

    @Override
    public SizeModel findById(Long id) throws SQLException {
        return sizeDAO.findById(id);
    }

    @Override
    public SizeModel save(SizeModel model) throws SQLException {
        Long productId = sizeDAO.save(model);
        return sizeDAO.findById(productId);
    }
}
