package webproject.services.impl;

import webproject.dao.impl.RoleImpl;
import webproject.models.Role;
import webproject.services.IRoleService;

import java.util.List;

/**
 * Created by Andrew Zarazka on 04.05.2017.
 */
public class RoleServiceImpl implements IRoleService {
    RoleImpl roleRepository = new RoleImpl();

    @Override
    public List<Role> getAll() {
        return this.roleRepository.getAll();
    }

    @Override
    public List<Role> getById(int id) {
        return this.roleRepository.getById(id);
    }

    @Override
    public void create(Role role) {
        this.roleRepository.create(role);
    }

    @Override
    public void update(Role role) {
        this.roleRepository.update(role);
    }

    @Override
    public void delete(int id) {
        this.roleRepository.delete(id);
    }

    @Override
    public List<Role> getByName(String name) {
        return this.roleRepository.getByName(name);
    }
}
