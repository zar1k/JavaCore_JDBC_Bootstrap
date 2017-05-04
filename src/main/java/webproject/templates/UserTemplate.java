package webproject.templates;

import webproject.models.Address;
import webproject.models.Role;
import webproject.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class UserTemplate extends Template<User> {
    @Override
    public List<User> getListOfResult(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setAge(rs.getInt("age"));
            user.setRole(new Role(rs.getInt("role_id")));
            user.setAddress(new Address(rs.getInt("address_id")));
            users.add(user);
        }
        return users;
    }
}
