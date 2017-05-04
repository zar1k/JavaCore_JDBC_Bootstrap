package webproject.services.impl;

import webproject.dao.impl.UserImpl;
import webproject.models.MusicType;
import webproject.models.User;
import webproject.services.IUserService;

import java.util.List;

/**
 * Created by Andrew Zarazka on 04.05.2017.
 */
public class UserServiceImpl implements IUserService {
    UserImpl userRepository = new UserImpl();

    @Override
    public List<User> getAll() {
        return this.userRepository.getAll();
    }

    @Override
    public List<User> getById(int id) {
        return this.userRepository.getById(id);
    }

    @Override
    public void create(User user) {
        this.userRepository.create(user);
    }

    @Override
    public void update(User user) {
        this.userRepository.update(user);
    }

    @Override
    public void delete(int id) {
        this.userRepository.delete(id);
    }

    @Override
    public List<User> getByLogin(String login) {
        return this.userRepository.getByLogin(login);
    }

    @Override
    public List<User> getByLoginAndPassword(String login, String password) {
        return this.userRepository.getByLoginAndPassword(login, password);
    }

    @Override
    public List<MusicType> getUserMusicTypes(User user) {
        return this.userRepository.getUserMusicTypes(user);
    }

    @Override
    public void addUserMusicTypes(User user, MusicType musicType) {
        this.userRepository.addUserMusicTypes(user, musicType);
    }

    @Override
    public void deleteUserMusicTypes(User user) {
        this.userRepository.deleteUserMusicTypes(user);
    }
}
