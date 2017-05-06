package webproject.dao.impl;

import org.junit.Test;
import webproject.models.Model;
import webproject.models.MusicType;
import webproject.models.User;
import webproject.services.IUserService;
import webproject.services.impl.UserServiceImpl;
import webproject.utils.Numbers;

import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class UserImplTest {
    @Test
    public void getAll() throws Exception {
        UserImpl userImpl = new UserImpl();
        List<User> users = userImpl.getAll();
        for (Model user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void getByLogin() throws Exception {
        String login = "user";
        UserImpl userImpl = new UserImpl();
        List<User> users = userImpl.getByLogin(login);
        User user = users.get(0);
        System.out.println(user);
    }

    @Test
    public void getMusicTypes() throws Exception {
        String login = "admin";
        UserImpl userImpl = new UserImpl();
        List<User> users = userImpl.getByLogin(login);
        User user = users.get(0);

        List<MusicType> musics = userImpl.getUserMusicTypes(user);
        for (MusicType music : musics) {
            System.out.println(music);
        }
    }

    @Test
    public void create() throws Exception {
        IUserService userService = new UserServiceImpl();
        System.out.println(userService.getByLogin("user").get(Numbers.FIRST_ELEMENT_OF_LIST.getNumber()));
    }
}
