package webproject.services;

import webproject.models.Role;

import java.util.List;

/**
 * Created by Andrew Zarazka on 04.05.2017.
 */
public interface IRoleService {
    /**
     * Gets all roles
     *
     * @return list of roles
     */
    List<Role> getAll();

    /**
     * Gets by id
     *
     * @param id the id
     * @return list of role
     */
    List<Role> getById(int id);

    /**
     * Create new Role
     *
     * @param role new role
     */
    void create(Role role);

    /**
     * Update current Role
     *
     * @param role Current object Role
     */
    void update(Role role);

    /**
     * Delete Role by id
     *
     * @param id role id
     */
    void delete(int id);

    /**
     * Gets by Role name
     *
     * @param name the Role name
     * @return the Role name
     */
    List<Role> getByName(String name);
}
