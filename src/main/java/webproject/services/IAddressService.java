package webproject.services;

import webproject.models.Address;

import java.util.List;

/**
 * Created by Andrew Zarazka on 04.05.2017.
 */
public interface IAddressService {
    /**
     * Gets all addresses
     *
     * @return list of addresses
     */
    List<Address> getAll();

    /**
     * Gets by id
     *
     * @param id the id
     * @return list of address
     */
    List<Address> getById(int id);

    /**
     * Create new Address
     *
     * @param address new address
     */
    void create(Address address);

    /**
     * Update current Address
     *
     * @param address Current object Address
     */
    void update(Address address);

    /**
     * Delete Address by id
     *
     * @param id address id
     */
    void delete(int id);
}
