package webproject.services;

import webproject.dao.impl.UserImpl;
import webproject.models.Model;
import webproject.models.User;

import java.util.List;

/**
 * Created by Andrew Zarazka on 29.04.2017.
 */
public class LoginService {
    public boolean authenticate(String login, String password) {
        boolean userExists;
        UserImpl userImpl = new UserImpl();
        List<Model> models = userImpl.getByLoginAndPassword(login, password);
        if (models.isEmpty()) {
            userExists = false;
        } else {
            userExists = true;
        }
        return userExists;
    }

    public User getUser(String login) {
        UserImpl userImpl = new UserImpl();
        List<Model> models = userImpl.getByLogin(login);
        User user = (User) models.get(0);
        return user;
    }
}
