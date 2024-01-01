package com.ltweb_servlet_ecommerce.dao;

import com.ltweb_servlet_ecommerce.model.SizeModel;

import java.sql.SQLException;
import java.util.List;

public interface ISizeDAO {
    List<SizeModel> findAll() throws SQLException;
    SizeModel findById(Long id) throws SQLException;
    SizeModel findWithFilter(SizeModel model) throws SQLException;
    Long save(SizeModel model) throws SQLException;
    void update(SizeModel model) throws SQLException;
    void delete(Long id) throws SQLException;
}
