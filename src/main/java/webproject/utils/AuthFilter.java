package webproject.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Andrew Zarazka on 11.05.2017.
 */
@WebFilter(urlPatterns = "/*", filterName = "AuthFilter")
public class AuthFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

}
