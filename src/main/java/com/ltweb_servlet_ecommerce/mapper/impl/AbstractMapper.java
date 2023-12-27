package com.ltweb_servlet_ecommerce.mapper.impl;

import com.ltweb_servlet_ecommerce.mapper.GenericMapper;
import com.ltweb_servlet_ecommerce.mapper.result.MapSQLAndParamsResult;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractMapper<T> implements GenericMapper<T> {
//    Map model thành câu lệnh sql update
//StringBuilder sql = new StringBuilder("UPDATE news SET ");
//    thay news thành bảng cần update
    @Override
    public MapSQLAndParamsResult mapSQL(StringBuilder sql, T model, String typeSQL) {
        List<Object> params = new ArrayList<>();
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(model);
                if (value != null) {
                    if (typeSQL.toLowerCase().equals("update") || typeSQL.toLowerCase().equals("insert")) {
                        sql.append(field.getName()).append(" = ?, ");
                        params.add(value);
                    } else if (typeSQL.toLowerCase().equals("select")) {
                        sql.append(" AND ").append(field.getName()).append(" = ?");
                        params.add(value);
                    }
                    // Append the field name and placeholder to the SQL statement

                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for (Field field : model.getClass().getSuperclass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(model);
                if (value != null) {
                    if ((typeSQL.toLowerCase().equals("update") || typeSQL.toLowerCase().equals("insert")) && field.getName()!="id" ) {
                        sql.append(field.getName()).append(" = ?, ");
                        params.add(value);
                    } else if (typeSQL.toLowerCase().equals("select")) {
                        sql.append(" AND ").append(field.getName()).append(" = ?");
                        params.add(value);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if (sql.length() > 2 && sql.charAt(sql.length() - 2) == ',' && typeSQL.toLowerCase().equals("update") || typeSQL.toLowerCase().equals("insert")) {
            sql.delete(sql.length() - 2, sql.length());
        }
        //        Nếu là update thì mới set where id
        if (typeSQL.toLowerCase().equals("update")) {
            sql.append(" WHERE id = ?");
            try {
                Field idField = model.getClass().getSuperclass().getDeclaredField("id");
                idField.setAccessible(true);
                Object idValue = idField.get(model);
                params.add(idValue);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return new MapSQLAndParamsResult(sql.toString(),params);
    }
//    Map kết quả từ sql
    public T mapper(ResultSet resultSet, Class<T> modelClass) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Map<String,String[]> resultMap = new HashMap<String,String[]>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            List<String> colVal = new ArrayList<>();
            Object values =  resultSet.getObject(columnName);
            if (values!=null) {
                colVal.add(resultSet.getObject(columnName)+"");
                String[] columnValues = colVal.toArray(new String[0]);
                resultMap.put(columnName, columnValues);
            }
        }
        T object = modelClass.newInstance();
        BeanUtils.populate(object,resultMap);
        resultMap.clear();
        return object;
    }



}
