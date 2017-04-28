package webproject.dao.impl;

import webproject.templates.AddressTemplate;
import webproject.templates.Template;
import webproject.dao.IAddress;
import webproject.models.Address;
import webproject.models.Model;
import webproject.utils.DataSource;

import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class AddressImpl implements IAddress {
    private static final String GET_ALL = "SELECT * FROM test_db.address";
    private static final String GET_BY_ID = "SELECT id, country, street, zip_code FROM test_db.address WHERE id = ?";
    private static final String CREATE = "INSERT INTO test_db.address (country, street, zip_code) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE test_db.address SET country = ?, street = ?, zip_code = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM test_db.address WHERE id = ?";

    private DataSource instance = DataSource.getInstance();

    @Override
    public List<Model> getAll() {
        Template template = new AddressTemplate();
        return template.executeAndReturn(instance, GET_ALL);
    }

    @Override
    public List<Model> getById(int id) {
        Template template = new AddressTemplate();
        return template.executeAndReturn(instance, GET_BY_ID, id);
    }

    @Override
    public void create(Address address) {
        Template template = new AddressTemplate();
        template.execute(instance, CREATE, address.getCountry().trim(), address.getStreet().trim(), address.getZipCode());
    }

    @Override
    public void update(Address address) {
        Template template = new AddressTemplate();
        template.execute(instance, UPDATE, address.getCountry().trim(), address.getStreet().trim(), address.getZipCode(), address.getId());
    }

    @Override
    public void delete(int id) {
        Template template = new AddressTemplate();
        template.execute(instance, DELETE, id);
    }
}
