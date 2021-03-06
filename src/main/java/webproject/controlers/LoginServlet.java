package webproject.controlers;

import webproject.models.User;
import webproject.services.ILoginService;
import webproject.services.impl.LoginService;
import webproject.utils.Numbers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrew Zarazka on 29.04.2017.
 */
@WebServlet(urlPatterns = "/login", name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (request.getParameter("loginBtn") != null) {
            ILoginService loginService = new LoginService();
            boolean result = loginService.authenticate(login, password);

            if (result) {
                User user = loginService.getUser(login);
                request.getSession().setAttribute("user", user);
                if (Numbers.ADMIN_ID.getNumber() == user.getRole().getId() || Numbers.MODERATOR_ID.getNumber() == user.getRole().getId()) {
                    response.sendRedirect("dashboard");
                    return;
                } else {
                    response.sendRedirect("profile");
                    return;
                }
            } else {
                boolean error = true;
                request.setAttribute("error", error);
                request.getRequestDispatcher("pages/login.jsp").forward(request, response);
                return;
            }
        }
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("signupBtn") != null) {
            response.sendRedirect("signup");
        } else {
            request.getRequestDispatcher("pages/login.jsp").forward(request, response);
        }
    }
}
