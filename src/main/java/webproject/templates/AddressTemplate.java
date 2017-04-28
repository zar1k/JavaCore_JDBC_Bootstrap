package webproject.templates;

import webproject.models.Address;
import webproject.models.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class AddressTemplate extends Template {
    @Override
    public List<Model> getListOfResult(ResultSet rs) throws SQLException {
        List<Model> models = new ArrayList<>();
        while (rs.next()) {
            Address address = new Address();
            address.setId(rs.getInt("id"));
            address.setCountry(rs.getString("country"));
            address.setStreet(rs.getString("street"));
            address.setZipCode(rs.getInt("zipCode"));
            models.add(address);
        }
        return models;
    }
}
