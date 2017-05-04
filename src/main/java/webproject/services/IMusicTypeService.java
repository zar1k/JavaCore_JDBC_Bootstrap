package webproject.services;

import webproject.models.MusicType;

import java.util.List;

/**
 * Created by Andrew Zarazka on 04.05.2017.
 */
public interface IMusicTypeService {
    /**
     * Gets all Music Types
     *
     * @return list of Music Types
     */
    List<MusicType> getAll();

    /**
     * Gets by id
     *
     * @param id the id
     * @return list of Music Type
     */
    List<MusicType> getById(int id);

    /**
     * Create new Music Type
     *
     * @param musicType new Music Type
     */
    void create(MusicType musicType);

    /**
     * Update current Music Type
     *
     * @param musicType Current object Music Type
     */
    void update(MusicType musicType);

    /**
     * Delete Music Type by id
     *
     * @param id Music Type id
     */
    void delete(int id);

    /**
     * Gets by Role name
     *
     * @param name the MusicType name
     * @return the MusicType name
     */
    List<MusicType> getByName(String name);

}
