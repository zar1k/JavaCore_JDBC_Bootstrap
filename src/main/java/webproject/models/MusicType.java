package webproject.models;

import java.util.List;
import java.util.Objects;

/**
 * Created by JOB on 28.04.2017.
 */
public class MusicType extends Model {
    private String name;
    private List<User> users;

    public MusicType() {
        super();
    }

    public MusicType(int id) {
        super(id);
    }

    public MusicType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MusicType)) return false;
        MusicType musicType = (MusicType) obj;
        return Objects.equals(getName(), musicType.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    /**
     * Needed for logging
     *
     * @return MusicType description
     */
    @Override
    public String toString() {
        return "MusicType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
