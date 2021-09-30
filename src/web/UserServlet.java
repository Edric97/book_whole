package web;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet{

    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        int userId = userService.findUserId(username, password);
        if (userId != -1) {
            req.getSession().setAttribute("userId", userId);
        }

        int login = userService.login(username, password);

        if (login == 1) {//等于1，说明登录成功
            req.getSession().setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        } else {//登录失败
            req.setAttribute("msg", "用户名或者密码错误");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }

    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());



        if (userService.isUsernameExists(user.getUsername())) {
            req.setAttribute("msg", "用户名已经存在!");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        } else {
            userService.register(user);
            req.getSession().setAttribute("username", user.getUsername());
            int userId = userService.findUserId(user.getUsername(), user.getPassword());
            if (userId != -1) {
                req.getSession().setAttribute("userId", userId);
            }
            req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
        }

    }

}
