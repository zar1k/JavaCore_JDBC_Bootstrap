package webproject.dao;

import webproject.models.Model;

import java.util.List;

/**
 * The interface Model provides CRUD methods
 * Created by Andrew Zarazka on 28.04.2017.
 *
 * @param <T> the type parameter
 */
public interface IModel<T extends Model> {
    List<T> getAll();

    List<T> getById(int id);

    void create(T t);

    void update(T t);

    void delete(int id);
}
