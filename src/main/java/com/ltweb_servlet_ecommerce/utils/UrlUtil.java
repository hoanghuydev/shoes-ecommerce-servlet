package com.ltweb_servlet_ecommerce.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UrlUtil {
    public Long getIdFromUrl(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");

        try {
            Long id = Long.parseLong(pathParts[pathParts.length-1]);
            return id;
        } catch (NumberFormatException e) {
            // Xử lý nếu giá trị không hợp lệ
            resp.getWriter().println("Invalid user ID");
        }
        return null;

    }
}
