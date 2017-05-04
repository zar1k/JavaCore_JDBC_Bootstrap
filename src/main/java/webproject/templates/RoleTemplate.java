package webproject.templates;

import webproject.models.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class RoleTemplate extends Template<Role> {
    @Override
    public List<Role> getListOfResult(ResultSet rs) throws SQLException {
        List<Role> roles = new ArrayList<>();
        while (rs.next()) {
            Role role = new Role();
            role.setId(rs.getInt("id"));
            role.setName(rs.getString("name"));
            roles.add(role);
        }
        return roles;
    }
}
