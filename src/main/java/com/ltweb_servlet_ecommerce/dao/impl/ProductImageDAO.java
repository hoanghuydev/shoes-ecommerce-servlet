package com.ltweb_servlet_ecommerce.dao.impl;

import com.ltweb_servlet_ecommerce.dao.IProductDAO;
import com.ltweb_servlet_ecommerce.dao.IProductImageDAO;
import com.ltweb_servlet_ecommerce.mapper.impl.ProductImageMapper;
import com.ltweb_servlet_ecommerce.mapper.result.MapSQLAndParamsResult;
import com.ltweb_servlet_ecommerce.model.ProductImageModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImageDAO extends AbstractDAO<ProductImageModel> implements IProductImageDAO {
    @Override
    public List<ProductImageModel> findAll() throws SQLException {
        String sql = "select * from productImage";
        return query(sql,new ProductImageMapper(),null, ProductImageModel.class);
    }

    @Override
    public ProductImageModel findById(Long id) throws SQLException {
        String sql = "select * from productImage where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<ProductImageModel> result =  query(sql,new ProductImageMapper(),params,ProductImageModel.class);
        return result.isEmpty() ? null : result.get(0);
    }
    @Override
    public ProductImageModel findWithFilter(ProductImageModel model) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("SELECT * FROM user WHERE 1=1 ");
        MapSQLAndParamsResult sqlAndParams = new ProductImageMapper().mapSQLAndParams(sqlStrBuilder,model,"select");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        List<ProductImageModel> result = query(sql.toString(), new ProductImageMapper(),params,ProductImageModel.class);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Long save(ProductImageModel productImageImageModel) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("INSERT INTO productImage SET ");
        MapSQLAndParamsResult sqlAndParams = new ProductImageMapper().mapSQLAndParams(sqlStrBuilder,productImageImageModel,"insert");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        return insert(sql,params);
    }

    @Override
    public void update(ProductImageModel productImageImageModel) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("UPDATE productImage SET ");
        MapSQLAndParamsResult sqlAndParams = new ProductImageMapper().mapSQLAndParams(sqlStrBuilder,productImageImageModel,"update");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        update(sql,params);
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "delete from productImage where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        delete(sql,params);
    }
}