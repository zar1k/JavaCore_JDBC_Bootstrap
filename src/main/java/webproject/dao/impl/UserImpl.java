package webproject.dao.impl;

import webproject.models.MusicType;
import webproject.templates.Template;
import webproject.templates.UserTemplate;
import webproject.dao.IUser;
import webproject.models.Model;
import webproject.models.User;
import webproject.utils.DataSource;

import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class UserImpl implements IUser {
    private static final String GET_ALL = "SELECT * FROM test_db.users";
    private static final String GET_BY_ID = "SELECT id, login, password, first_name, last_name, age, role_id, address_id FROM test_db.users WHERE id = ?";
    private static final String GET_BY_LOGIN = "SELECT id, login, password, first_name, last_name, age, role_id, address_id FROM test_db.users WHERE login = ?";
    private static final String CREATE = "INSERT INTO test_db.users (login, password, first_name, last_name, age, role_id, address_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE test_db.users SET login = ?, password = ?, first_name = ?, last_name = ?, age = ?, role_id = ?, address_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM test_db.users WHERE id = ?";

    private static final String ADD_LINK_USER_HAS_MUSIC_TYPE = "INSERT INTO test_db.users_has_music_type (users_id, music_type_id) VALUES (?, ?)";
    private static final String GET_LINK_USER_HAS_MUSIC_TYPE = "SELECT mt.id, mt.name FROM music_type AS mt JOIN users_has_music_type AS uhmt ON mt.id = uhmt.music_type_id AND uhmt.users_id = (SELECT id FROM users WHERE login = ?)";
    private static final String DELETE_LINK_USER_HAS_MUSIC_TYPE = "DELETE FROM test_db.users_has_music_type WHERE users_id = ?";

    private DataSource instance = DataSource.getInstance();

    @Override
    public List<Model> getAll() {
        Template template = new UserTemplate();
        return template.executeAndReturn(instance, GET_ALL);
    }

    @Override
    public List<Model> getById(int id) {
        Template template = new UserTemplate();
        return template.executeAndReturn(instance, GET_BY_ID, id);
    }

    @Override
    public void create(User user) {
        Template template = new UserTemplate();
        template.execute(instance, CREATE, user.getLogin().trim(), user.getPassword().trim(), user.getFirstName().trim(),
                user.getLastName().trim(), user.getAge(), user.getRole().getId(), user.getAddress());
    }

    @Override
    public void update(User user) {
        Template template = new UserTemplate();
        template.execute(instance, UPDATE, user.getLogin().trim(), user.getPassword().trim(), user.getFirstName().trim(),
                user.getLastName().trim(), user.getAge(), user.getRole().getId(), user.getAddress().getId(), user.getId());
    }

    @Override
    public void delete(int id) {
        Template template = new UserTemplate();
        template.execute(instance, DELETE, id);
    }

    @Override
    public List<Model> getByLogin(String login) {
        Template template = new UserTemplate();
        return template.executeAndReturn(instance, GET_BY_LOGIN, login.trim());
    }

    @Override
    public List<Model> getMusicTypes(User user) {
        Template template = new UserTemplate();
        return template.executeAndReturn(instance, GET_LINK_USER_HAS_MUSIC_TYPE, user.getLogin().trim());
    }

    @Override
    public void addUserMusicTypes(User user, MusicType musicType) {
        Template template = new UserTemplate();
        template.execute(instance, ADD_LINK_USER_HAS_MUSIC_TYPE, user.getLogin().trim(), musicType.getName().trim());
    }
}
