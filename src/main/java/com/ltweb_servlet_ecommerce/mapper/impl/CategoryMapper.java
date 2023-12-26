package com.ltweb_servlet_ecommerce.mapper.impl;

import com.ltweb_servlet_ecommerce.mapper.RowMapper;
import com.ltweb_servlet_ecommerce.mapper.result.MapSQLAndParamsResult;
import com.ltweb_servlet_ecommerce.model.CategoryModel;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper extends AbstractMapper<CategoryModel> implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel mapRow(ResultSet resultSet, Class<CategoryModel> modelClass) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return mapper(resultSet,modelClass);
    }

    @Override
    public MapSQLAndParamsResult mapSQLAndParams(StringBuilder sql, CategoryModel model, String typeSQL) {
        return mapSQL(sql, model, typeSQL);
    }
}
