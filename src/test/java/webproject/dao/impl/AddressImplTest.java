package webproject.dao.impl;

import org.junit.Test;
import webproject.models.Address;
import webproject.models.Model;
import webproject.models.User;
import webproject.services.IAddressService;
import webproject.services.LoginService;
import webproject.services.impl.AddressServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Andrew Zarazka on 04.05.2017.
 */
public class AddressImplTest {
    @Test
    public void getAll() throws Exception {
        IAddressService addressService = new AddressServiceImpl();
        List<Address> addressList = addressService.getAll();
        for (Address address : addressList) {
            System.out.println(address);
        }
    }

    @Test
    public void Arr() throws Exception {
        String[] mass = {"a", "b", "c"};
        for (int i = 0; i < mass.length; i++) {
            System.out.println(mass[i]);
        }
        String login = "user";
        LoginService loginService = new LoginService();
        User user = loginService.getUser(login);
        System.out.println(user);

    }
}