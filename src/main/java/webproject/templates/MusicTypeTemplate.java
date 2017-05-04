package webproject.templates;

import webproject.models.MusicType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class MusicTypeTemplate extends Template<MusicType> {
    @Override
    public List<MusicType> getListOfResult(ResultSet rs) throws SQLException {
        List<MusicType> types = new ArrayList<>();
        while (rs.next()) {
            MusicType musicType = new MusicType();
            musicType.setId(rs.getInt("id"));
            musicType.setName(rs.getString("name"));
            types.add(musicType);
        }
        return types;
    }
}
