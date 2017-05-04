package webproject.controlers;

import webproject.models.User;
import webproject.services.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrew Zarazka on 29.04.2017.
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        LoginService loginService = new LoginService();
        boolean result = loginService.authenticate(login, password);

        if (result) {
            User user = loginService.getUser(login);
            request.getSession().setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("greetings.jsp");
            dispatcher.forward(request, response);
            return;
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
            return;
        }
    }
}
