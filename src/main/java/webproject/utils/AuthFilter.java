package webproject.utils;

import webproject.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrew Zarazka on 11.05.2017.
 */
@WebFilter(urlPatterns = "/*", filterName = "AuthFilter")
public class AuthFilter implements Filter {
    private List<String> pathFilters = Arrays.asList(new String[]{
            "dashboard.jsp", "dashboard", "controlPanel.jsp", "panel",
            "create.jsp", "create", "edit.jsp", "edit", "profile.jsp", "profile"});
    private static final char DELIMITER = '/';

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String uri = ((HttpServletRequest) request).getRequestURI();
        String path = uri.substring(uri.lastIndexOf(DELIMITER) + Numbers.PLUS_ONE_CHARACTER.getNumber());

        if (!pathFilters.contains(path)) {
            chain.doFilter(request, response);
            return;
        }

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        User user = (User) req.getSession().getAttribute("user");

        if (user != null) {
            chain.doFilter(request, response);
        }
        resp.sendRedirect("login");
    }

    public void destroy() {
    }

}
