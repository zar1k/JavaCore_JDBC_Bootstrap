package webproject.dao.impl;

import webproject.models.MusicType;
import webproject.templates.MusicTypeTemplate;
import webproject.templates.Template;
import webproject.templates.UserTemplate;
import webproject.dao.IUser;
import webproject.models.User;
import webproject.utils.DataSource;
import webproject.utils.Numbers;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class UserImpl implements IUser {
    private static Logger logger = Logger.getLogger(UserImpl.class.getName());

    private static final String GET_ALL = "SELECT * FROM test_db.users";
    private static final String GET_BY_ID = "SELECT id, login, password, first_name, last_name, age, role_id, address_id FROM test_db.users WHERE id = ?";
    private static final String GET_BY_LOGIN = "SELECT id, login, password, first_name, last_name, age, role_id, address_id FROM test_db.users WHERE login = ?";
    private static final String CREATE = "INSERT INTO test_db.users (login, password, first_name, last_name, age, role_id, address_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE test_db.users SET password = ?, first_name = ?, last_name = ?, age = ?, role_id = ?, address_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM test_db.users WHERE id = ?";
    private static final String GET_BY_LOGIN_AND_PASSWORD = "SELECT * FROM test_db.users WHERE login = ? AND password = ?";
    private static final String GET_NEXT_AUTO_INCREMENT = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'test_db' AND TABLE_NAME = 'users'";

    private static final String ADD_LINK_USER_HAS_MUSIC_TYPE = "INSERT INTO test_db.users_has_music_type (`users_id`, `music_type_id`) VALUES ((SELECT id FROM users WHERE login = ?), (SELECT id FROM music_type WHERE name = ?))";
    private static final String GET_LINK_USER_HAS_MUSIC_TYPE = "SELECT mt.id, mt.name FROM music_type AS mt JOIN users_has_music_type AS uhmt ON mt.id = uhmt.music_type_id AND uhmt.users_id = (SELECT id FROM users WHERE login = ?)";
    private static final String DELETE_LINK_USER_HAS_MUSIC_TYPE = "DELETE FROM test_db.users_has_music_type WHERE users_id = ?";

    private DataSource instance = DataSource.getInstance();

    @Override
    public List<User> getAll() {
        Template template = new UserTemplate();
        List<User> users = template.executeAndReturn(instance, GET_ALL);

        for (User user : users) {
            logger.info("User list: " + user);
        }
        return users;
    }

    @Override
    public List<User> getById(int id) {
        Template template = new UserTemplate();
        List<User> users = template.executeAndReturn(instance, GET_BY_ID, id);
        logger.info("User uploaded successfully. User details: " + users.get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber()));
        return users;
    }

    @Override
    public void create(User user) {
        Template template = new UserTemplate();
        int addressId = template.getNextAutoIncrement(instance, GET_NEXT_AUTO_INCREMENT);
        template.execute(instance, CREATE, user.getLogin().trim(), user.getPassword().trim(), user.getFirstName().trim(),
                user.getLastName().trim(), user.getAge(), user.getRole().getId(), addressId);
        logger.info("User successfully created. User details: " + user);
    }

    @Override
    public void update(User user) {
        Template template = new UserTemplate();
        template.execute(instance, UPDATE, user.getPassword().trim(), user.getFirstName().trim(),
                user.getLastName().trim(), user.getAge(), user.getRole().getId(), user.getId(), user.getId());
        logger.info("User updated successfully. User details: " + user);
    }

    @Override
    public void delete(int id) {
        Template template = new UserTemplate();
        template.execute(instance, DELETE, id);
        logger.info("User successfully deleted. User ID: " + id);
    }

    @Override
    public List<User> getByLogin(String login) {
        Template template = new UserTemplate();
        List<User> users = template.executeAndReturn(instance, GET_BY_LOGIN, login.trim());
        if (users.isEmpty()) {
            logger.info("User is not found. User login: " + login);
        }
        logger.info("User successfully found by login. User login: " + login);
        return users;
    }

    @Override
    public List<User> getByLoginAndPassword(String login, String password) {
        Template template = new UserTemplate();
        List<User> users = template.executeAndReturn(instance, GET_BY_LOGIN_AND_PASSWORD, login.trim(), password.trim());
        if (users.isEmpty()) {
            logger.trace("User is not found. User login: " + login + " and password: " + password);
        }
        logger.info("User successfully found by login and password. User details: " + users.get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber()));
        return users;
    }

    @Override
    public void addUserMusicTypes(User user, MusicType musicType) {
        Template template = new UserTemplate();
        template.execute(instance, ADD_LINK_USER_HAS_MUSIC_TYPE, user.getLogin().trim(), musicType.getName().trim());
        logger.info("User Music successfully Added. User details: " + user + " .Music details: " + musicType);
    }

    @Override
    public List<MusicType> getUserMusicTypes(User user) {
        Template template = new MusicTypeTemplate();
        List<MusicType> musicTypes = template.executeAndReturn(instance, GET_LINK_USER_HAS_MUSIC_TYPE, user.getLogin().trim());
        for (MusicType type : musicTypes) {
            logger.info("The user's music was successfully uploaded. User details: " + user + " .Music list: " + type);
        }
        return musicTypes;
    }

    @Override
    public void deleteUserMusicTypes(User user) {
        Template template = new UserTemplate();
        template.execute(instance, DELETE_LINK_USER_HAS_MUSIC_TYPE, user.getId());
        logger.info("User Music successfully deleted. User details: " + user);
    }
}
