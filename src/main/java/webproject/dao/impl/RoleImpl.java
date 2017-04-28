package webproject.dao.impl;

import webproject.templates.RoleTemplate;
import webproject.templates.Template;
import webproject.dao.IRole;
import webproject.models.Model;
import webproject.models.Role;
import webproject.utils.DataSource;

import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class RoleImpl implements IRole {
    private static final String GET_ALL = "SELECT * FROM test_db.role";
    private static final String GET_BY_ID = "SELECT * FROM test_db.role WHERE id = ?";
    private static final String CREATE = "INSERT INTO test_db.role (name) VALUES (?)";
    private static final String UPDATE = "UPDATE test_db.role SET name = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM test_db.role WHERE id = ?";
    private static final String GET_BY_NAME = "SELECT * FROM test_db.role WHERE name = ?";

    private DataSource instance = DataSource.getInstance();

    @Override
    public List<Model> getAll() {
        Template template = new RoleTemplate();
        return template.executeAndReturn(instance, GET_ALL);
    }

    @Override
    public List<Model> getById(int id) {
        Template template = new RoleTemplate();
        return template.executeAndReturn(instance, GET_BY_ID, id);
    }

    @Override
    public void create(Role role) {
        Template template = new RoleTemplate();
        template.execute(instance, CREATE, role.getName().trim());
    }

    @Override
    public void update(Role role) {
        Template template = new RoleTemplate();
        template.execute(instance, UPDATE, role.getName().trim(), role.getId());
    }

    @Override
    public void delete(int id) {
        Template template = new RoleTemplate();
        template.execute(instance, DELETE, id);
    }

    @Override
    public List<Model> getByName(String name) {
        Template template = new RoleTemplate();
        return template.executeAndReturn(instance, GET_BY_NAME, name.trim());
    }
}
