package webproject.controlers;

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
    private int userID;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        String role = request.getParameter("userRole");
        String country = request.getParameter("country");
        String street = request.getParameter("street");
        String zipCode = request.getParameter("zipCode");
        String[] musicTypes = request.getParameterValues("musicTypeList");

        IUserService userService = new UserServiceImpl();
        IRoleService roleService = new RoleServiceImpl();
        IAddressService addressService = new AddressServiceImpl();
        IMusicTypeService musicTypeService = new MusicTypeServiceImpl();

        User user = userService.getById(userID).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber());
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(Integer.parseInt(age));
        user.setRole(roleService.getById(Integer.parseInt(role)).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber()));


        Address address = addressService.getById(userID).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber());
        address.setCountry(country);
        address.setStreet(street);
        address.setZipCode(Integer.parseInt(zipCode));
        addressService.update(address);

        user.setAddress(address);
        userService.update(user);

        userService.deleteUserMusicTypes(user);

        for (int i = 0; i < musicTypes.length; i++) {
            List<MusicType> types = musicTypeService.getByName(musicTypes[i]);
            for (MusicType type : types) {
                userService.addUserMusicTypes(userService.getByLogin(user.getLogin()).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber()), type);
            }
        }
        response.sendRedirect("panel");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> enumeration = request.getParameterNames();
        userID = Integer.parseInt(enumeration.nextElement());

        IUserService userService = new UserServiceImpl();
        IRoleService roleService = new RoleServiceImpl();
        IAddressService addressService = new AddressServiceImpl();
        IMusicTypeService musicTypeService = new MusicTypeServiceImpl();

        User tmpUser = userService.getById(userID).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber());
        Role role = tmpUser.getRole();
        List<MusicType> userMusicTypes = userService.getUserMusicTypes(tmpUser);
        List<Role> roleList = roleService.getAll();
        Address address = addressService.getById(userID).get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber());
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
