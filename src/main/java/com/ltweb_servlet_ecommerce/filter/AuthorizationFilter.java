package com.ltweb_servlet_ecommerce.filter;

import com.ltweb_servlet_ecommerce.model.UserModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private  ServletContext context;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        String url = req.getRequestURI();
//        if (url.startsWith("/admin")) {
//            UserModel user = (UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
//            if (user!=null) {
//                if (user.getRoleId()==true) filterChain.doFilter(servletRequest,servletResponse);
//                else resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=not_permission&alert=danger");
//
//            } else {
//                resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=not_login_yet&alert=danger");
//            }
//        } else {
            filterChain.doFilter(servletRequest,servletResponse);
//        }
    }
}
