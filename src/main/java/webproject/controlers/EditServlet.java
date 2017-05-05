package webproject.controlers;

import webproject.dao.IMusicType;
import webproject.models.Address;
import webproject.models.MusicType;
import webproject.models.Role;
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
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Andrew Zarazka on 05.05.2017.
 */
@WebServlet(urlPatterns = "/edit", name = "EditServlet")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        String role = request.getParameter("userRole");
        String country = request.getParameter("country");
        String street = request.getParameter("street");
        String zipCode = request.getParameter("zipCode");
        String[] musicTypes = request.getParameterValues("listMusics");

        IRoleService roleService = new RoleServiceImpl();
        IUserService userService = new UserServiceImpl();
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(Integer.parseInt(age));
        user.setRole(roleService.getById(Integer.parseInt(role)).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber()));


        Address address = new Address();
        address.setCountry(country);
        address.setStreet(street);
        address.setZipCode(Integer.parseInt(zipCode));

        user.setAddress(address);
        userService.create(user);

        userService.deleteUserMusicTypes(user);
        IMusicTypeService musicTypeService = new MusicTypeServiceImpl();
        for (int i = 0; i < musicTypes.length; i++) {
            user.setMusicTypes(musicTypeService.getByName(musicTypes[i]));
        }
        userService.addUserMusicTypes(user, null);
        userService.create(user);
        response.sendRedirect("edit");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> enumeration = request.getParameterNames();
        int id = Integer.parseInt(enumeration.nextElement());

        IUserService userService = new UserServiceImpl();
        IRoleService roleService = new RoleServiceImpl();
        IAddressService addressService = new AddressServiceImpl();
        IMusicTypeService musicTypeService = new MusicTypeServiceImpl();

        User tmpUser = userService.getById(id).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber());
        Role role = tmpUser.getRole();
        List<MusicType> userMusicTypes = userService.getUserMusicTypes(tmpUser);
        List<Role> roleList = roleService.getAll();
        Address address = addressService.getById(id).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber());
        List<MusicType> musicTypeList = musicTypeService.getAll();

        request.setAttribute("tmpUser", tmpUser);
        request.setAttribute("role", role);
        request.setAttribute("address", address);
        request.setAttribute("userMusicTypes", userMusicTypes);
        request.setAttribute("roleList", roleList);
        request.setAttribute("musicTypeList", musicTypeList);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }
}
