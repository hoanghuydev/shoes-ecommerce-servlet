package com.ltweb_servlet_ecommerce.controller.web;

import com.ltweb_servlet_ecommerce.service.ICategoryService;
import com.ltweb_servlet_ecommerce.service.IUserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    @Inject
    ICategoryService categoryService;
    @Inject
    IUserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
            rd.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
