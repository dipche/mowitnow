package fr.xebia.test.commandes;

import fr.xebia.test.bo.Mouvement;
import fr.xebia.test.bo.Orientation;
import fr.xebia.test.bo.Tondeuse;

/**
 * Created by Grégory SOH on 30/08/2016.
 */
public class Commandes {

    private static final int BORDER_MIN = 0;
    private static final int BORDER_MAX = 5;

    public static Tondeuse avancer(Tondeuse tondeuse) {

        if ( Commandes.isTondeuseIntoField( tondeuse) ) {
            Integer posX = tondeuse.getCoordonneeX();
            Integer posY = tondeuse.getCoordonneeY();

            switch (tondeuse.getOrientation()) {
                case N:
                    posY++;
                    break;
                case E:
                    posX++;
                    break;
                case S:
                    posY--;
                    break;
                case W:
                    posX--;
                    break;
            }
            tondeuse.setCoordonneeX(posX);
            tondeuse.setCoordonneeY(posY);
        }

        return tondeuse;
    }

    public static Tondeuse pivoter(Tondeuse tondeuse, Mouvement mouv){
        Orientation orient = tondeuse.getOrientation();
        if ( Commandes.isTondeuseIntoField( tondeuse) ) {
            switch (orient) {
                case N:
                    if (mouv == Mouvement.Droite)
                        tondeuse.setOrientation(Orientation.E);
                    else if (mouv == Mouvement.Gauche)
                        tondeuse.setOrientation(Orientation.W);
                    break;
                case E:
                    if (mouv == Mouvement.Droite)
                        tondeuse.setOrientation(Orientation.S);
                    else if (mouv == Mouvement.Gauche)
                        tondeuse.setOrientation(Orientation.N);
                    break;
                case S:
                    if (mouv == Mouvement.Droite)
                        tondeuse.setOrientation(Orientation.W);
                    else if (mouv == Mouvement.Gauche)
                        tondeuse.setOrientation(Orientation.E);
                    break;
                case W:
                    if (mouv == Mouvement.Droite)
                        tondeuse.setOrientation(Orientation.N);
                    else if (mouv == Mouvement.Gauche)
                        tondeuse.setOrientation(Orientation.S);
                    break;
            }
        }
        return tondeuse;
    }

    public static Boolean isTondeuseOnBorder(Tondeuse tondeuse){
        Integer posX = tondeuse.getCoordonneeX();
        Integer posY = tondeuse.getCoordonneeY();

        if ( posX.compareTo(BORDER_MIN) == 0 && tondeuse.getOrientation() == Orientation.W ){
           return Boolean.TRUE;
        } else if ( posY.compareTo(BORDER_MAX) == 0 && tondeuse.getOrientation() == Orientation.N ){
            return Boolean.TRUE;
        }  else if ( posX.compareTo(BORDER_MAX) == 0 && tondeuse.getOrientation() == Orientation.E ){
            return Boolean.TRUE;
        } else if ( posY.compareTo(BORDER_MIN) == 0 && tondeuse.getOrientation() == Orientation.S ){
            return Boolean.TRUE;
        } else
            return Boolean.FALSE;
    }

    public static Boolean isTondeuseIntoField(Tondeuse tondeuse){
        Integer posX = tondeuse.getCoordonneeX();
        Integer posY = tondeuse.getCoordonneeY();

        if ( posX.compareTo(BORDER_MIN) < 0 || posX.compareTo(BORDER_MAX) > 0 ){
            return Boolean.FALSE;
        } else if (posY.compareTo(BORDER_MIN) < 0 || posY.compareTo(BORDER_MAX) > 0 ){
            return Boolean.FALSE;
        } else
            return Boolean.TRUE;
    }
}
