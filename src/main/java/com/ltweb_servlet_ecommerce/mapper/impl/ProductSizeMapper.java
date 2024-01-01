package com.ltweb_servlet_ecommerce.mapper.impl;

import com.ltweb_servlet_ecommerce.mapper.RowMapper;
import com.ltweb_servlet_ecommerce.mapper.result.MapSQLAndParamsResult;
import com.ltweb_servlet_ecommerce.model.ProductSizeModel;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSizeMapper extends AbstractMapper<ProductSizeModel> implements RowMapper<ProductSizeModel> {
    @Override
    public ProductSizeModel mapRow(ResultSet resultSet, Class<ProductSizeModel> modelClass) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return mapper(resultSet,modelClass);
    }

    @Override
    public MapSQLAndParamsResult mapSQLAndParams(StringBuilder sql, ProductSizeModel model, String typeSQL) {
        return mapSQL(sql, model, typeSQL);
    }
}