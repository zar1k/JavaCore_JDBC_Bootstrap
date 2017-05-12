package webproject.services;

import webproject.models.User;

/**
 * Created by Andrew Zarazka on 12.05.2017.
 */
public interface ILoginService {
    /**
     * User authentication by login and password
     *
     * @param login    User's login
     * @param password User's password
     * @return True if the user is registered, false if the user is not registered
     */
    boolean authenticate(String login, String password);

    /**
     * Get user by login
     *
     * @param login User's login
     * @return User
     */
    User getUser(String login);
}
