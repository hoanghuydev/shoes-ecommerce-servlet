package com.ltweb_servlet_ecommerce.service;

import com.ltweb_servlet_ecommerce.model.SizeModel;
import com.ltweb_servlet_ecommerce.model.SizeModel;

import java.sql.SQLException;
import java.util.List;

public interface ISizeService {
    SizeModel findWithFilter(SizeModel model) throws SQLException;
    SizeModel save(SizeModel model) throws SQLException;
    SizeModel delete(Long id) throws SQLException;
    SizeModel update(SizeModel model) throws SQLException;
    SizeModel findById(Long id) throws SQLException;
    List<SizeModel> findAll() throws SQLException;
}
