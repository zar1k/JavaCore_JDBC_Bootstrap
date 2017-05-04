package webproject.dao;

import webproject.models.Model;
import webproject.models.Role;

import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public interface IRole extends IModel<Role> {
    /**
     * Gets by Role name
     *
     * @param name the Role name
     * @return the Role name
     */
    List<Role> getByName(String name);
}
