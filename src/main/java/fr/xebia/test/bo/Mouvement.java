package fr.xebia.test.bo;

/**
 * Created by Grégory SOH on 30/08/2016.
 */
public enum Mouvement {
    Avance("A"), Droite("D"), Gauche("G");

    private String firstLetter;
    Mouvement(String l) {
        firstLetter = l;
    }
    String getFirstLetter() {
        return firstLetter;
    }
}
