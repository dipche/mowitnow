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
        Integer posX = tondeuse.getCoordonneeX();
        Integer posY = tondeuse.getCoordonneeY();

        switch ( tondeuse.getOrientation() ){
            case North :
                posY++;
            case East :
                posX++;
            case South :
                posY--;
            case West :
                posX--;
        }
        tondeuse.setCoordonneeX(posX);
        tondeuse.setCoordonneeY(posY);

        return tondeuse;
    }

    public static Tondeuse pivoter(Tondeuse tondeuse, Mouvement mouv){
        Orientation orient = tondeuse.getOrientation();

        switch ( orient ){
            case North:
                if (mouv == Mouvement.Droite)
                    tondeuse.setOrientation(Orientation.East);
                else if (mouv == Mouvement.Gauche)
                    tondeuse.setOrientation(Orientation.West);
            case East:
                if (mouv == Mouvement.Droite)
                    tondeuse.setOrientation(Orientation.South);
                else if (mouv == Mouvement.Gauche)
                    tondeuse.setOrientation(Orientation.North);
            case South:
                if (mouv == Mouvement.Droite)
                    tondeuse.setOrientation(Orientation.West);
                else if (mouv == Mouvement.Gauche)
                    tondeuse.setOrientation(Orientation.East);
            case West:
                if (mouv == Mouvement.Droite)
                    tondeuse.setOrientation(Orientation.North);
                else if (mouv == Mouvement.Gauche)
                    tondeuse.setOrientation(Orientation.South);
        }
        return tondeuse;
    }

    public static Boolean isTondeuseOnBorder(Tondeuse tondeuse){
        Integer posX = tondeuse.getCoordonneeX();
        Integer posY = tondeuse.getCoordonneeY();

        if ( posX.compareTo(BORDER_MIN) == 0 && tondeuse.getOrientation() == Orientation.West ){
           return Boolean.TRUE;
        } else if ( posY.compareTo(BORDER_MAX) == 0 && tondeuse.getOrientation() == Orientation.North ){
            return Boolean.TRUE;
        }  else if ( posX.compareTo(BORDER_MAX) == 0 && tondeuse.getOrientation() == Orientation.East ){
            return Boolean.TRUE;
        } else if ( posY.compareTo(BORDER_MIN) == 0 && tondeuse.getOrientation() == Orientation.South ){
            return Boolean.TRUE;
        } else
            return Boolean.FALSE;
    }
}
