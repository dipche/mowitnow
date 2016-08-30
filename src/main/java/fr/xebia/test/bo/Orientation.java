package fr.xebia.test.bo;

/**
 * Created by Grégory SOH on 30/08/2016.
 */
public enum Orientation {
    North("N"), East("E"), West("W"), South("S");

    private String firstLetter;
    Orientation(String  l) {
        firstLetter = l;
    }
    String getFirstLetter() {
        return firstLetter;
    }
}
