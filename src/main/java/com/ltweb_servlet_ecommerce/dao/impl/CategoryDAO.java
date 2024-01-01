package com.ltweb_servlet_ecommerce.dao.impl;

import com.ltweb_servlet_ecommerce.dao.ICategoryDAO;
import com.ltweb_servlet_ecommerce.dao.IOrderDAO;
import com.ltweb_servlet_ecommerce.mapper.impl.CategoryMapper;
import com.ltweb_servlet_ecommerce.mapper.impl.CategoryMapper;
import com.ltweb_servlet_ecommerce.mapper.impl.CategoryMapper;
import com.ltweb_servlet_ecommerce.mapper.result.MapSQLAndParamsResult;
import com.ltweb_servlet_ecommerce.model.CategoryModel;
import com.ltweb_servlet_ecommerce.model.CategoryModel;
import com.ltweb_servlet_ecommerce.model.CategoryModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public List<CategoryModel> findAll() throws SQLException {
        String sql = "select * from category";
        return query(sql,new CategoryMapper(),null, CategoryModel.class);
    }

    @Override
    public CategoryModel findById(Long id) throws SQLException {
        String sql = "select * from category where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<CategoryModel> result =  query(sql,new CategoryMapper(),params,CategoryModel.class);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Long save(CategoryModel model) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("INSERT INTO category SET ");
        MapSQLAndParamsResult sqlAndParams = new CategoryMapper().mapSQLAndParams(sqlStrBuilder,model,"insert");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        return insert(sql,params);
    }

    @Override
    public void update(CategoryModel model) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("UPDATE category SET ");
        MapSQLAndParamsResult sqlAndParams = new CategoryMapper().mapSQLAndParams(sqlStrBuilder,model,"update");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        update(sql,params);
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "delete from category where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        delete(sql,params);
    }
    @Override
    public CategoryModel findWithFilter(CategoryModel model) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("SELECT * FROM category WHERE 1=1 ");
        MapSQLAndParamsResult sqlAndParams = new CategoryMapper().mapSQLAndParams(sqlStrBuilder,model,"select");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        List<CategoryModel> result = query(sql.toString(), new CategoryMapper(),params,CategoryModel.class);
        return result.isEmpty() ? null : result.get(0);
    }
}