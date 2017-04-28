package webproject.dao.impl;

import webproject.templates.MusicTypeTemplate;
import webproject.templates.Template;
import webproject.dao.IMusicType;
import webproject.models.Model;
import webproject.models.MusicType;
import webproject.utils.DataSource;

import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class MusicTypeImpl implements IMusicType {
    private static final String GET_ALL = "SELECT * FROM test_db.music_type";
    private static final String GET_BY_ID = "SELECT * FROM test_db.music_type WHERE id = ?";
    private static final String CREATE = "INSERT INTO test_db.music_type (name) VALUES (?)";
    private static final String UPDATE = "UPDATE test_db.music_type SET name = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM test_db.music_type WHERE id = ?";
    private static final String GET_BY_NAME = "SELECT * FROM test_db.music_type WHERE name = ?";

    private DataSource instance = DataSource.getInstance();

    @Override
    public List<Model> getAll() {
        Template template = new MusicTypeTemplate();
        return template.executeAndReturn(instance, GET_ALL);
    }

    @Override
    public List<Model> getById(int id) {
        Template template = new MusicTypeTemplate();
        return template.executeAndReturn(instance, GET_BY_ID, id);
    }

    @Override
    public void create(MusicType musicType) {
        Template template = new MusicTypeTemplate();
        template.execute(instance, CREATE, musicType.getName().trim());
    }

    @Override
    public void update(MusicType musicType) {
        Template template = new MusicTypeTemplate();
        template.execute(instance, UPDATE, musicType.getName().trim(), musicType.getId());
    }

    @Override
    public void delete(int id) {
        Template template = new MusicTypeTemplate();
        template.execute(instance, DELETE, id);
    }

    @Override
    public List<Model> getByName(String name) {
        Template template = new MusicTypeTemplate();
        return template.executeAndReturn(instance, GET_BY_NAME, name.trim());
    }
}
