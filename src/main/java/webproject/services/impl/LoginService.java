package webproject.services.impl;

import webproject.models.User;
import webproject.services.ILoginService;
import webproject.services.IUserService;
import webproject.services.impl.UserServiceImpl;
import webproject.utils.Numbers;

import java.util.List;

/**
 * Created by Andrew Zarazka on 29.04.2017.
 */
public class LoginService implements ILoginService {
    @Override
    public boolean authenticate(String login, String password) {
        boolean userExists;
        IUserService userService = new UserServiceImpl();
        List<User> users = userService.getByLoginAndPassword(login, password);
        if (users.isEmpty()) {
            userExists = false;
        } else {
            userExists = true;
        }
        return userExists;
    }

    @Override
    public User getUser(String login) {
        IUserService userService = new UserServiceImpl();
        List<User> users = userService.getByLogin(login);
        User user = users.get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber());
        return user;
    }
}
