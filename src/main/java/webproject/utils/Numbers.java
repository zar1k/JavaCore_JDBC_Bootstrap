package webproject.utils;

/**
 * Created by Andrew Zarazka on 05.05.2017.
 */
public enum Numbers {
    FIRST_ELEMENT_OF_LIST(0), DEFAULT_ID(-1), DEFAULT_ROLE(3), PLUS_ONE_CHARACTER(1);

    private int number;

    Numbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
