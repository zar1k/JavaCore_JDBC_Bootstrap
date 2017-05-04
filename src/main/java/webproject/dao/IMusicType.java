package webproject.dao;

import webproject.models.Model;
import webproject.models.MusicType;

import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public interface IMusicType extends IModel<MusicType> {
    /**
     * Gets by Role name
     *
     * @param name the MusicType name
     * @return the MusicType name
     */
    List<MusicType> getByName(String name);
}
