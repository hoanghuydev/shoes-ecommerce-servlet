package com.ltweb_servlet_ecommerce.dao.impl;

import com.ltweb_servlet_ecommerce.dao.ICategoryDAO;
import com.ltweb_servlet_ecommerce.mapper.impl.CategoryMapper;
import com.ltweb_servlet_ecommerce.mapper.result.MapSQLAndParamsResult;
import com.ltweb_servlet_ecommerce.model.CategoryModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

    @Override
    public List<CategoryModel> findAll() throws SQLException {
        String sql = "select * from category";
        return query(sql,new CategoryMapper(),null,CategoryModel.class);
    }

    @Override
    public CategoryModel findById(Long id) throws SQLException {
        String sql = "select * from category where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<CategoryModel> result = query(sql,new CategoryMapper(),params,CategoryModel.class);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Long save(CategoryModel categoryModel) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("INSERT INTO category SET ");
        MapSQLAndParamsResult sqlAndParams = new CategoryMapper().mapSQLAndParams(sqlStrBuilder,categoryModel,"insert");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        return insert(sql,params);
    }
}
