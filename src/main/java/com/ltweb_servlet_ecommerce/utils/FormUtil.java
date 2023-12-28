package com.ltweb_servlet_ecommerce.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class FormUtil {
    public static <T> T toModel(Class<T> tClass, HttpServletRequest request)
            throws InstantiationException, IllegalAccessException, InvocationTargetException, UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        T object = tClass.newInstance();
        BeanUtils.populate(object, escapeParameterMap(request.getParameterMap()));
        return object;
    }



    // prevent XSS
    private static Map<String, String[]> escapeParameterMap(Map<String, String[]> parameterMap) {
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String[] values = entry.getValue();
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    values[i] = StringEscapeUtils.escapeHtml4(values[i]);
                }
            }
        }
        return parameterMap;
    }
}

