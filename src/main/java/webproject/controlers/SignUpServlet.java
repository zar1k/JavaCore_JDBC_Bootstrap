package webproject.controlers;

import webproject.models.Address;
import webproject.models.MusicType;
import webproject.models.User;
import webproject.services.IAddressService;
import webproject.services.IMusicTypeService;
import webproject.services.IRoleService;
import webproject.services.IUserService;
import webproject.services.impl.AddressServiceImpl;
import webproject.services.impl.MusicTypeServiceImpl;
import webproject.services.impl.RoleServiceImpl;
import webproject.services.impl.UserServiceImpl;
import webproject.utils.Numbers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrew Zarazka on 10.05.2017.
 */
@WebServlet(urlPatterns = "/signup", name = "SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = new UserServiceImpl();
        IRoleService roleService = new RoleServiceImpl();
        IAddressService addressService = new AddressServiceImpl();
        IMusicTypeService musicTypeService = new MusicTypeServiceImpl();

        User user = new User();
        Address address = new Address();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        String country = request.getParameter("country");
        String street = request.getParameter("street");
        String zipCode = request.getParameter("zipCode");
        String[] musicTypes = request.getParameterValues("listMusics");

        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(Integer.parseInt(age));
        user.setRole(roleService.getById(Numbers.DEFAULT_ROLE.getNumber()).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber()));

        address.setCountry(country);
        address.setStreet(street);
        address.setZipCode(Integer.parseInt(zipCode));
        addressService.create(address);

        user.setAddress(address);
        userService.create(user);

        for (int i = 0; i < musicTypes.length; i++) {
            List<MusicType> types = musicTypeService.getByName(musicTypes[i]);
            for (MusicType type : types) {
                userService.addUserMusicTypes(userService.getByLogin(login).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber()), type);
            }
        }
        request.getSession().setAttribute("user", user);
        response.sendRedirect("profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IMusicTypeService musicTypeService = new MusicTypeServiceImpl();
        List<MusicType> musicTypes = musicTypeService.getAll();
        request.setAttribute("musicTypes", musicTypes);
        request.getRequestDispatcher("pages/signup.jsp").forward(request, response);
    }
}
