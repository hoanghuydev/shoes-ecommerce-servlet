package com.ltweb_servlet_ecommerce.dao.impl;

import com.ltweb_servlet_ecommerce.dao.IUserDAO;
import com.ltweb_servlet_ecommerce.mapper.impl.ProductMapper;
import com.ltweb_servlet_ecommerce.mapper.result.MapSQLAndParamsResult;
import com.ltweb_servlet_ecommerce.mapper.impl.UserMapper;
import com.ltweb_servlet_ecommerce.model.ProductModel;
import com.ltweb_servlet_ecommerce.model.UserModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {
    @Override
    public List<UserModel> findAll() throws SQLException {
        String sql = "select * from user";
        return query(sql,new UserMapper(),null,UserModel.class);
    }

    @Override
    public UserModel findById(Long id) throws SQLException {
        String sql = "select * from user where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<UserModel> result =  query(sql,new UserMapper(),params,UserModel.class);
        return result.isEmpty() ? null : result.get(0);
    }


    @Override
    public UserModel findWithFilter(UserModel userModel) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("SELECT * FROM user WHERE 1=1");
        MapSQLAndParamsResult sqlAndParams = new UserMapper().mapSQLAndParams(sqlStrBuilder,userModel,"select");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        List<UserModel> result = query(sql.toString(), new UserMapper(),params,UserModel.class);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Long save(UserModel userModel) throws SQLException {
        StringBuilder sqlStringBuilder = new StringBuilder("INSERT INTO user SET ");
        MapSQLAndParamsResult sqlAndParams = new UserMapper().mapSQLAndParams(sqlStringBuilder,userModel,"insert");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        return insert(sql,params);
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "delete from user where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        delete(sql,params);
    }

    @Override
    public void update(UserModel userModel) throws SQLException {
        StringBuilder sqlStringBuilder = new StringBuilder("UPDATE user SET ");
        MapSQLAndParamsResult sqlAndParams = new UserMapper().mapSQLAndParams(sqlStringBuilder,userModel,"update");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        update(sql,params);
    }
}
