package webproject.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by Andrew Zarazka on 11.05.2017.
 */
@WebFilter(urlPatterns = "/*", initParams = @WebInitParam(name = "requestEncoding", value = "UTF-8"), filterName = "UTF8Filter")
public class UTF8Filter implements Filter {
    private static final String UTF_8_ENCODING = "UTF-8";
    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("requestEncoding");
        if (!encoding.equalsIgnoreCase(UTF_8_ENCODING)) {
            encoding = UTF_8_ENCODING;
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // Setting the character set for the request
        request.setCharacterEncoding(encoding);

        // Set the default response content type and encoding
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding(encoding);

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
