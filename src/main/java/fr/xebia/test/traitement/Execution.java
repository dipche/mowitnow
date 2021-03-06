package fr.xebia.test.traitement;


import fr.xebia.test.bo.Mouvement;
import fr.xebia.test.bo.Orientation;
import fr.xebia.test.bo.Tondeuse;
import fr.xebia.test.commandes.Commandes;
import fr.xebia.test.utils.IoUtils;
import org.apache.log4j.Logger;


import java.io.*;

/**
 * Created by Grégory SOH on 31/08/2016.
 */
class Execution {
    private static Logger LOGGER = Logger.getLogger(Execution.class.getName());

    public static void main (String [] args){


        IoUtils.controlArgs(args[0], args[1]);


        LOGGER.info("Début du Traitement");

        String  thisLine;
        Tondeuse tondeuse = null;
        BufferedReader reader = null;
        OutputStream oups = null;
        String messageOut;
        try {

            reader = IoUtils.lectureFichier(args[0]);

            reader.readLine();

            oups = new FileOutputStream(args[1]);

            while ((thisLine = reader.readLine()) != null) {
                String[] coordonnees = thisLine.split(" ");

                if (coordonnees.length > 1){
                  tondeuse = new Tondeuse(Integer.valueOf(coordonnees[0]),
                          Integer.valueOf(coordonnees[1]), Orientation.valueOf(coordonnees[2]));
                       LOGGER.info("Position initiale tondeuse : " + tondeuse.toString());
                       messageOut = "Position initiale tondeuse : " + tondeuse.toString();
                       IoUtils.ecrireFichier(oups, messageOut);
                } else{
                    for(int i = 0; i < thisLine.length(); i++) {
                        char command = thisLine.charAt(i);
                        if (command == 'A'){
                            if ( Commandes.isTondeuseOnBorder(tondeuse) )
                                continue;
                            else {
                                tondeuse = Commandes.avancer(tondeuse);
                            }
                        } else if (command == 'D'){
                            Commandes.pivoter(tondeuse, Mouvement.Droite);
                        } else {
                            Commandes.pivoter(tondeuse, Mouvement.Gauche);
                        }
                    }
                    assert tondeuse != null;
                    LOGGER.info("Position finale tondeuse : " + tondeuse.toString());
                    messageOut = "Position finale tondeuse : " + tondeuse.toString();
                    IoUtils.ecrireFichier(oups, messageOut);
                }
            }
        }catch(IOException ioe){
            LOGGER.error("Exception Buffer reader " + ioe.getMessage(), ioe);
        } finally {
            try {
                IoUtils.closeInputStream(reader);
            } catch (IOException e) {
                    LOGGER.error("Erreur à la fermeture du flux " + e.getMessage(), e);
            }
            if (oups != null){
                try {
                    oups.close();
                } catch (IOException e) {
                    LOGGER.error("Erreur à la fermeture du flux " + e.getMessage(), e);
                }
            }
        }
    }
}
