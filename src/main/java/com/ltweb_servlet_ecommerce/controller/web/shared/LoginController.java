package com.ltweb_servlet_ecommerce.controller.web.shared;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.ltweb_servlet_ecommerce.model.UserModel;
import com.ltweb_servlet_ecommerce.service.IUserService;
import com.ltweb_servlet_ecommerce.utils.FormUtil;
import com.ltweb_servlet_ecommerce.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/sign-in","/sign-out"})
public class LoginController extends HttpServlet {
    @Inject
    IUserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getRequestURI().startsWith("/sign-out")){
        SessionUtil.getInstance().removeValue(req,"USER_MODEL");
        resp.sendRedirect(req.getContextPath()+"/home");
    } else {
        String message = req.getParameter("message");
        String toast = req.getParameter("toast");
        if (message!=null && toast!=null) {
            ResourceBundle resourceMsg = ResourceBundle.getBundle("message");
            ResourceBundle resourceToast = ResourceBundle.getBundle("toast");
            req.setAttribute("message",resourceMsg.getString(message));
            req.setAttribute("toast",resourceToast.getString(toast));
        }
        RequestDispatcher rd = req.getRequestDispatcher("/views/shared/login.jsp");
        rd.forward(req, resp);
    }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            UserModel userModel = null;
            try {
                userModel = FormUtil.toModel(UserModel.class,req);
                if (userModel.getPassword()!=null && userModel.getEmail()!=null) {
                    UserModel tmpUser = new UserModel();
                    tmpUser.setEmail(userModel.getEmail());
                    tmpUser = userService.findWithFilter(tmpUser);
                    BCrypt.Verifyer verifyer = BCrypt.verifyer();
                    BCrypt.Result result = verifyer.verify(userModel.getPassword().toCharArray(), tmpUser.getPassword());
                    if (tmpUser!=null && result.verified) {
                        SessionUtil.getInstance().putValue(req,"USER_MODEL",tmpUser);
                        if (tmpUser.getAdmin()) {
                            resp.sendRedirect(req.getContextPath()+"/home");
                        } else {
                            resp.sendRedirect(req.getContextPath()+"/home");
                        }
                    } else {
                        resp.sendRedirect(req.getContextPath()+"/sign-in?action=login&message=username_password_invalid&toast=danger");
                    }
                } else {
                    resp.sendRedirect(req.getContextPath()+"/sign-in?action=login&message=fill_all_fields&toast=danger");

                }
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }



    }
}
