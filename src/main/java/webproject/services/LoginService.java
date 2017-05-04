package webproject.services;

import webproject.models.User;
import webproject.services.impl.UserServiceImpl;

import java.util.List;

/**
 * Created by Andrew Zarazka on 29.04.2017.
 */
public class LoginService {
    public boolean authenticate(String login, String password) {
        boolean userExists;
        IUserService userImpl = new UserServiceImpl();
        List<User> users = userImpl.getByLoginAndPassword(login, password);
        if (users.isEmpty()) {
            userExists = false;
        } else {
            userExists = true;
        }
        return userExists;
    }

    public User getUser(String login) {
        IUserService userImpl = new UserServiceImpl();
        List<User> users = userImpl.getByLogin(login);
        User user = users.get(0);
        return user;
    }
}
