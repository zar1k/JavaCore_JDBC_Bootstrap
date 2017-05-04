package webproject.services.impl;

import webproject.dao.impl.AddressImpl;
import webproject.models.Address;
import webproject.services.IAddressService;

import java.util.List;

/**
 * Created by Andrew Zarazka on 04.05.2017.
 */
public class AddressServiceImpl implements IAddressService {
    AddressImpl addressRepository = new AddressImpl();

    @Override
    public List<Address> getAll() {
        return this.addressRepository.getAll();
    }

    @Override
    public List<Address> getById(int id) {
        return this.addressRepository.getById(id);
    }

    @Override
    public void create(Address address) {
        this.addressRepository.create(address);
    }

    @Override
    public void update(Address address) {
        this.addressRepository.update(address);
    }

    @Override
    public void delete(int id) {
        this.addressRepository.delete(id);
    }
}
