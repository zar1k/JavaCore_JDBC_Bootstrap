package webproject.utils;

/**
 * Created by Andrew Zarazka on 05.05.2017.
 */
public enum Numbers {
    FIRST_ELEMENT_OF_LIST(0);

    private int number;

    Numbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
