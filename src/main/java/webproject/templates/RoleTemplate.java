package webproject.templates;

import webproject.models.Model;
import webproject.models.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class RoleTemplate extends Template {
    @Override
    public List<Model> getListOfResult(ResultSet rs) throws SQLException {
        List<Model> models = new ArrayList<>();
        while (rs.next()) {
            Role role = new Role();
            role.setId(rs.getInt("id"));
            role.setName(rs.getString("name"));
            models.add(role);
        }
        return models;
    }
}
