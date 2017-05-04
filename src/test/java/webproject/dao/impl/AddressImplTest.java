package webproject.dao.impl;

import org.junit.Test;
import webproject.models.Address;
import webproject.models.Model;
import webproject.services.IAddressService;
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
}