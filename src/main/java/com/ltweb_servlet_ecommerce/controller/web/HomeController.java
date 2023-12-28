package com.ltweb_servlet_ecommerce.controller.web;

import com.ltweb_servlet_ecommerce.service.ICategoryService;
import com.ltweb_servlet_ecommerce.service.IOrderService;
import com.ltweb_servlet_ecommerce.service.IUserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    @Inject
    ICategoryService categoryService;
    @Inject
    IUserService userService;
    @Inject
    IOrderService orderService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        String toast = req.getParameter("toast");
        if (message!=null && toast!=null) {
            ResourceBundle resourceMsg = ResourceBundle.getBundle("message");
            ResourceBundle resourceToast = ResourceBundle.getBundle("toast");
            req.setAttribute("message",resourceMsg.getString(message));
            req.setAttribute("toast",resourceToast.getString(toast));
        }
            RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
            rd.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
