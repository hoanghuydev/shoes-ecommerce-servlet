package com.ltweb_servlet_ecommerce.mapper.impl;


import com.ltweb_servlet_ecommerce.mapper.result.MapSQLAndParamsResult;
import com.ltweb_servlet_ecommerce.mapper.RowMapper;
import com.ltweb_servlet_ecommerce.model.UserModel;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper extends AbstractMapper<UserModel> implements RowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet resultSet, Class<UserModel> modelClass) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return mapper(resultSet,modelClass);
    }

    @Override
    public MapSQLAndParamsResult mapSQLAndParams(StringBuilder sql, UserModel userModel, String typeSQL) {
        return mapSQL(sql,userModel,typeSQL);
    }
}
