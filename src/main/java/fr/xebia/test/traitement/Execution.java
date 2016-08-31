package fr.xebia.test.traitement;


import fr.xebia.test.bo.Mouvement;
import fr.xebia.test.bo.Orientation;
import fr.xebia.test.bo.Tondeuse;
import fr.xebia.test.commandes.Commandes;
import fr.xebia.test.utils.IoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Grégory SOH on 31/08/2016.
 */
public class Execution {
    //private static Logger LOGGER = LoggerFactory.getLogger(Execution.class);

    public static void main (String [] args){

        //1 contrôle de fichier présent en entrée
        //InputStream fileIn = IoUtils.createStreamFromFile("commands.txt");

        //2 Ecrire Timestamp début traitement dans le fichier résultat
        //LOGGER.info("Début du Traitement");


        String  thisLine = null;
        Tondeuse tondeuse = null;
        try {
            //3 Ouvrir le fichier et lire tant que pas fini
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

            //4 lecture première ligne du fichier repère du grillage
            reader.readLine();

            //5 lecture seconde ligne du fichier
            while ((thisLine = reader.readLine()) != null) {
                System.out.println(thisLine);

                String[] coordonnees = thisLine.split(" ");
                // Test pour différencier une ligne de coordonnées d'une ligne de commande
                if (coordonnees.length > 1){
                  tondeuse = new Tondeuse(Integer.valueOf(coordonnees[0]),
                          Integer.valueOf(coordonnees[1]), Orientation.valueOf(coordonnees[2]));
                   // LOGGER.info("Position initiale tondeuse : " + tondeuse.toString());
                    System.out.println("Position initiale tondeuse : " + tondeuse.toString());
                } else{
                    // c'est une ligne de commande reçue
                    for(int i = 0; i < thisLine.length(); i++) {
                        char command = thisLine.charAt(i);
                        if (command == 'A'){
                            if ( Commandes.isTondeuseOnBorder(tondeuse) )
                                continue;
                            else {
                                Commandes.avancer(tondeuse);
                            }

                        } else if (command == 'D'){
                            Commandes.pivoter(tondeuse, Mouvement.Droite);
                        } else {
                            Commandes.pivoter(tondeuse, Mouvement.Gauche);
                        }
                    }
                    //LOGGER.info("Position finale tondeuse : " + tondeuse.toString());
                    System.out.println("Position finale tondeuse : " + tondeuse.toString());
                }
            }

            //IoUtils.closeInputStream(reader);
        }catch(Exception e){
            //LOGGER.error("Exception Buffer reader " + e.getMessage(), e);
            System.out.println("Position finale tondeuse : " + tondeuse.toString());
        }







        //6 écrire coordonnées de début de la première tondeuse dans le fichier

        //7 instancier la prmeière tondeuse

        //8 lecture troisième ligne du fichier

        //9 traitement de la ligne élément par élément selon la commande tant que ligne non finie

        //10 test fin de ligne ligne de commande traité

        //11 reprendre à 5 tant que fin de fichier pas atteinte
    }
}
