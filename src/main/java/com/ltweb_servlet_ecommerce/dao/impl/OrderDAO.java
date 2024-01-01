package com.ltweb_servlet_ecommerce.dao.impl;

import com.ltweb_servlet_ecommerce.dao.IOrderDAO;
import com.ltweb_servlet_ecommerce.mapper.impl.OrderMapper;
import com.ltweb_servlet_ecommerce.mapper.result.MapSQLAndParamsResult;
import com.ltweb_servlet_ecommerce.model.OrderModel;
import com.ltweb_servlet_ecommerce.model.OrderModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends AbstractDAO<OrderModel> implements IOrderDAO {
    @Override
    public List<OrderModel> findAll() throws SQLException {
        String sql = "select * from order";
        return query(sql,new OrderMapper(),null, OrderModel.class);
    }

    @Override
    public OrderModel findById(Long id) throws SQLException {
        String sql = "select * from order where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<OrderModel> result =  query(sql,new OrderMapper(),params,OrderModel.class);
        return result.isEmpty() ? null : result.get(0);
    }
    @Override
    public OrderModel findWithFilter(OrderModel model) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("SELECT * FROM order WHERE 1=1 ");
        MapSQLAndParamsResult sqlAndParams = new OrderMapper().mapSQLAndParams(sqlStrBuilder,model,"select");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        List<OrderModel> result = query(sql.toString(), new OrderMapper(),params,OrderModel.class);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Long save(OrderModel model) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("INSERT INTO order SET ");
        MapSQLAndParamsResult sqlAndParams = new OrderMapper().mapSQLAndParams(sqlStrBuilder,model,"insert");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        return insert(sql,params);
    }

    @Override
    public void update(OrderModel model) throws SQLException {
        StringBuilder sqlStrBuilder = new StringBuilder("UPDATE order SET ");
        MapSQLAndParamsResult sqlAndParams = new OrderMapper().mapSQLAndParams(sqlStrBuilder,model,"update");
        String sql = sqlAndParams.getSql();
        List<Object> params = sqlAndParams.getParams();
        update(sql,params);
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "delete from order where id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        delete(sql,params);
    }
}
