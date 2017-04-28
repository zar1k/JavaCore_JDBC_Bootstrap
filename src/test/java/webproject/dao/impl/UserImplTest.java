package webproject.dao.impl;

import org.junit.Test;
import webproject.models.Model;
import webproject.models.User;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class UserImplTest {
    @Test
    public void getAll() throws Exception {
        UserImpl userImpl = new UserImpl();
        List<Model> users = userImpl.getAll();
        for (Model user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void getByLogin() throws Exception {
        String login = "user";
        UserImpl userImpl = new UserImpl();
        List<Model> users = userImpl.getByLogin(login);
        User user = (User) users.get(0);
        System.out.println(user);
    }

    @Test
    public void getMusicTypes() throws Exception {
        String login = "user";
        UserImpl userImpl = new UserImpl();
        List<Model> users = userImpl.getByLogin(login);
        User user = (User) users.get(0);

        List<Model> musics = userImpl.getMusicTypes(user);
        for (Model music : musics) {
            System.out.println(music);
        }
    }

}