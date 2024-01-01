package com.ltweb_servlet_ecommerce.mapper.impl;

import com.ltweb_servlet_ecommerce.mapper.RowMapper;
import com.ltweb_servlet_ecommerce.mapper.result.MapSQLAndParamsResult;
import com.ltweb_servlet_ecommerce.model.SizeModel;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SizeMapper extends AbstractMapper<SizeModel> implements RowMapper<SizeModel> {
    @Override
    public SizeModel mapRow(ResultSet resultSet, Class<SizeModel> modelClass) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return mapper(resultSet,modelClass);
    }

    @Override
    public MapSQLAndParamsResult mapSQLAndParams(StringBuilder sql, SizeModel model, String typeSQL) {
        return mapSQL(sql, model, typeSQL);
    }
}
