package webproject.services.impl;

import webproject.dao.impl.MusicTypeImpl;
import webproject.models.MusicType;
import webproject.services.IMusicTypeService;

import java.util.List;

/**
 * Created by Andrew Zarazka on 04.05.2017.
 */
public class MusicTypeServiceImpl implements IMusicTypeService {
    MusicTypeImpl musicTypeRepository = new MusicTypeImpl();

    @Override
    public List<MusicType> getAll() {
        return this.musicTypeRepository.getAll();
    }

    @Override
    public List<MusicType> getById(int id) {
        return this.musicTypeRepository.getById(id);
    }

    @Override
    public void create(MusicType musicType) {
        this.musicTypeRepository.create(musicType);
    }

    @Override
    public void update(MusicType musicType) {
        this.musicTypeRepository.update(musicType);
    }

    @Override
    public void delete(int id) {
        this.musicTypeRepository.delete(id);
    }

    @Override
    public List<MusicType> getByName(String name) {
        return this.musicTypeRepository.getByName(name);
    }
}
