package webproject.models;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public abstract class Model {
    public int id;

    /**
     * Instantiates a new Model
     */
    public Model() {
    }

    /**
     * Instantiates a new Model
     *
     * @param id the model id
     */
    public Model(int id) {
        this.id = id;
    }

    /**
     * Get id
     *
     * @return the model id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id
     *
     * @param id the model id
     */
    public void setId(int id) {
        this.id = id;
    }
}
