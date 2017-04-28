package webproject.models;

import java.util.Objects;

/**
 * Created by Andrew Zarazka on 28.04.2017.
 */
public class Address extends Model {
    private String country;
    private String street;
    private int zipCode;
    private User user;

    public Address() {
        super();
    }

    public Address(int id) {
        super(id);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Address)) return false;
        Address address = (Address) obj;
        return getZipCode() == address.getZipCode() &&
                Objects.equals(getCountry(), address.getCountry()) &&
                Objects.equals(getStreet(), address.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getStreet(), getZipCode());
    }

    /**
     * Needed for logging
     *
     * @return Address description
     */
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
