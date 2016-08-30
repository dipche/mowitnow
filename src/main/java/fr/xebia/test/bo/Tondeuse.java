package fr.xebia.test.bo;

/**
 * Created by Grégory SOH on 30/08/2016.
 */
public class Tondeuse {
    private Integer coordonneeX;
    private Integer coordonneeY;
    private Orientation orientation;

    public Tondeuse(int coordonneeX, int coordonneeY, Orientation orientation) {
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.orientation = orientation;
    }

    public Integer getCoordonneeX() {
        return coordonneeX;
    }

    public void setCoordonneeX(int coordonneeX) {
        this.coordonneeX = coordonneeX;
    }

    public Integer getCoordonneeY() {
        return coordonneeY;
    }

    public void setCoordonneeY(int coordonneeY) {
        this.coordonneeY = coordonneeY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
