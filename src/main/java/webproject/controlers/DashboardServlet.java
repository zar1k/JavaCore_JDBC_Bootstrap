package webproject.controlers;

import webproject.models.*;
import webproject.services.IAddressService;
import webproject.services.IRoleService;
import webproject.services.IUserService;
import webproject.services.impl.AddressServiceImpl;
import webproject.services.impl.RoleServiceImpl;
import webproject.services.impl.UserServiceImpl;
import webproject.utils.Numbers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew Zarazka on 04.05.2017.
 */
@WebServlet(urlPatterns = "/dashboard", name = "DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = new UserServiceImpl();
        IRoleService roleService = new RoleServiceImpl();
        IAddressService addressService = new AddressServiceImpl();

        List<Address> addresses = addressService.getAll();
        List<User> userList = new ArrayList<>();

        List<User> users = userService.getAll();
        for (User user : users) {
            user.setRole(roleService.getById(user.getRole().getId()).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber()));
            user.setAddress(addressService.getById(user.getAddress().getId()).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber()));
            user.setMusicTypes(userService.getUserMusicTypes(user));
            userList.add(user);
        }

        request.setAttribute("userList", userList);
        request.setAttribute("addresses", addresses);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
