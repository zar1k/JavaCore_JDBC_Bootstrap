package webproject.templates;

import webproject.models.Model;
import webproject.models.MusicType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOB on 28.04.2017.
 */
public class MusicTypeTemplate extends Template {
    @Override
    public List<Model> getListOfResult(ResultSet rs) throws SQLException {
        List<Model> models = new ArrayList<>();
        while (rs.next()) {
            MusicType musicType = new MusicType();
            musicType.setId(rs.getInt("id"));
            musicType.setName(rs.getString("name"));
            models.add(musicType);
        }
        return models;
    }
}
