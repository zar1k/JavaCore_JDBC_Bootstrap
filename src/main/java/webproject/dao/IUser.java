package webproject.dao;

import webproject.models.Model;
import webproject.models.MusicType;
import webproject.models.User;

import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public interface IUser extends IModel<User> {
    /**
     * Gets by User name
     *
     * @param login the User login
     * @return the User login
     */
    List<User> getByLogin(String login);

    /**
     * Gets by User
     *
     * @param login    the user's login
     * @param password the user's password
     * @return user
     */
    List<User> getByLoginAndPassword(String login, String password);

    /**
     * Get a list of the user's music
     *
     * @param user
     * @return list of MusicTypes
     */
    List<MusicType> getUserMusicTypes(User user);

    /**
     * Adds a type of music to the user
     *
     * @param user
     * @param musicType
     */
    void addUserMusicTypes(User user, MusicType musicType);

    /**
     * Delete links to user's music
     *
     * @param user
     */
    void deleteUserMusicTypes(User user);
}
