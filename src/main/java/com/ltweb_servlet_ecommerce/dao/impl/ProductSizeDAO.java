package com.ltweb_servlet_ecommerce.dao.impl;

import com.ltweb_servlet_ecommerce.dao.IProductSizeDAO;
import com.ltweb_servlet_ecommerce.dao.ISizeDAO;
import com.ltweb_servlet_ecommerce.mapper.impl.ProductSizeMapper;
import com.ltweb_servlet_ecommerce.mapper.result.MapSQLAndParamsResult;
import com.ltweb_servlet_ecommerce.model.ProductSizeModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductSizeDAO extends AbstractDAO<ProductSizeModel> implements IProductSizeDAO {
    @Override
    public List<ProductSizeModel> findAll() throws SQLException {
        String sql = "select * from size";
        return query(sql,new ProductSizeMapper(),null, ProductSizeModel.class);
    }

    @Override
    public ProductSizeModel findById(Long id) throws SQLException {
        String sql = "select * from size where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<ProductSizeModel> result =  query(sql,new ProductSizeMapper(),params,ProductSizeModel.class);
        return result.isEmpty() ? null : result.get(0);
    }
    @Override
    public ProductSizeModel findWithFilter(ProductSizeModel model) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("SELECT * FROM user WHERE 1=1 ");
        MapSQLAndParamsResult sqlAndParams = new ProductSizeMapper().mapSQLAndParams(sqlStrBuilder,model,"select");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        List<ProductSizeModel> result = query(sql.toString(), new ProductSizeMapper(),params,ProductSizeModel.class);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Long save(ProductSizeModel model) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("INSERT INTO size SET ");
        MapSQLAndParamsResult sqlAndParams = new ProductSizeMapper().mapSQLAndParams(sqlStrBuilder,model,"insert");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        return insert(sql,params);
    }

    @Override
    public void update(ProductSizeModel model) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("UPDATE size SET ");
        MapSQLAndParamsResult sqlAndParams = new ProductSizeMapper().mapSQLAndParams(sqlStrBuilder,model,"update");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        update(sql,params);
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "delete from size where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        delete(sql,params);
    }
}

