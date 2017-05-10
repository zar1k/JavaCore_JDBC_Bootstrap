package webproject.controlers;

import webproject.services.IAddressService;
import webproject.services.IUserService;
import webproject.services.impl.AddressServiceImpl;
import webproject.services.impl.UserServiceImpl;
import webproject.utils.Numbers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Andrew Zarazka on 05.05.2017.
 */
@WebServlet(urlPatterns = "/delete", name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = new UserServiceImpl();
        IAddressService addressService = new AddressServiceImpl();

        Enumeration<String> enumeration = request.getParameterNames();
        int userId = Integer.parseInt(enumeration.nextElement());

        userService.deleteUserMusicTypes(userService.getById(userId).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber()));
        userService.delete(userId);
        addressService.delete(userId);

        response.sendRedirect("panel");
    }
}
