package com.ltweb_servlet_ecommerce.dao.impl;

import com.ltweb_servlet_ecommerce.dao.IProductDAO;
import com.ltweb_servlet_ecommerce.mapper.impl.UserMapper;
import com.ltweb_servlet_ecommerce.mapper.result.MapSQLAndParamsResult;
import com.ltweb_servlet_ecommerce.mapper.impl.ProductMapper;
import com.ltweb_servlet_ecommerce.model.ProductModel;
import com.ltweb_servlet_ecommerce.model.UserModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {
    @Override
    public List<ProductModel> findAll() throws SQLException {
        String sql = "select * from product";
        return query(sql,new ProductMapper(),null, ProductModel.class);
    }

    @Override
    public ProductModel findById(Long id) throws SQLException {
        String sql = "select * from product where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<ProductModel> result =  query(sql,new ProductMapper(),params,ProductModel.class);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Long save(ProductModel productModel) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("INSERT INTO product SET ");
        MapSQLAndParamsResult sqlAndParams = new ProductMapper().mapSQLAndParams(sqlStrBuilder,productModel,"insert");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        return insert(sql,params);
    }

    @Override
    public void update(ProductModel productModel) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("UPDATE product SET ");
        MapSQLAndParamsResult sqlAndParams = new ProductMapper().mapSQLAndParams(sqlStrBuilder,productModel,"update");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        update(sql,params);
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "delete from product where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        delete(sql,params);
    }
}
