package fr.xebia.test.bo;

/**
 * Created by Grégory SOH on 30/08/2016.
 */
public enum Orientation {
    N("North"), E("East"), W("West"), S("South");

    private String firstLetter;
    Orientation(String  l) {
        firstLetter = l;
    }
    String getFirstLetter() {
        return firstLetter;
    }
}
