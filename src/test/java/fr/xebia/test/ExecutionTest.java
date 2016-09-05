package fr.xebia.test;

import fr.xebia.test.bo.Mouvement;
import fr.xebia.test.bo.Orientation;
import fr.xebia.test.bo.Tondeuse;
import fr.xebia.test.commandes.Commandes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by Grégory SOH on 05/09/2016.
 */
public class ExecutionTest {



        private Tondeuse tondeuse;




        @Before
        public void init() throws Exception {

             tondeuse = new Tondeuse(1, 2, Orientation.N);

        }




        @Test
        public void testPivoterDroit() {
            Mouvement mouv = Mouvement.Droite;
            Commandes.pivoter(tondeuse, mouv);
            assertEquals(Integer.valueOf(1), tondeuse.getCoordonneeX());
            assertEquals(Integer.valueOf(2), tondeuse.getCoordonneeY());
            assertEquals(Orientation.E, tondeuse.getOrientation());

            Commandes.pivoter(tondeuse, mouv);
            assertEquals(Integer.valueOf(1), tondeuse.getCoordonneeX());
            assertEquals(Integer.valueOf(2), tondeuse.getCoordonneeY());
            assertEquals(Orientation.S, tondeuse.getOrientation());

            Commandes.pivoter(tondeuse, mouv);
            assertEquals(Integer.valueOf(1), tondeuse.getCoordonneeX());
            assertEquals(Integer.valueOf(2), tondeuse.getCoordonneeY());
            assertEquals(Orientation.W, tondeuse.getOrientation());

            Commandes.pivoter(tondeuse, mouv);
            assertEquals(Integer.valueOf(1), tondeuse.getCoordonneeX());
            assertEquals(Integer.valueOf(2), tondeuse.getCoordonneeY());
            assertEquals(Orientation.N, tondeuse.getOrientation());

        }




        @Test
        public void testPivoterGauche() {

        Mouvement mouv = Mouvement.Gauche;
        Commandes.pivoter(tondeuse, mouv);
        assertEquals(Integer.valueOf(1), tondeuse.getCoordonneeX());
        assertEquals(Integer.valueOf(2), tondeuse.getCoordonneeY());
        assertEquals(Orientation.W, tondeuse.getOrientation());

        Commandes.pivoter(tondeuse, mouv);
        assertEquals(Integer.valueOf(1), tondeuse.getCoordonneeX());
        assertEquals(Integer.valueOf(2), tondeuse.getCoordonneeY());
        assertEquals(Orientation.S, tondeuse.getOrientation());

        Commandes.pivoter(tondeuse, mouv);
        assertEquals(Integer.valueOf(1), tondeuse.getCoordonneeX());
        assertEquals(Integer.valueOf(2), tondeuse.getCoordonneeY());
        assertEquals(Orientation.E, tondeuse.getOrientation());

        Commandes.pivoter(tondeuse, mouv);
        assertEquals(Integer.valueOf(1), tondeuse.getCoordonneeX());
        assertEquals(Integer.valueOf(2), tondeuse.getCoordonneeY());
        assertEquals(Orientation.N, tondeuse.getOrientation());

        }


        @Test
        public void testAvancer() {

            Commandes.avancer(tondeuse);
            assertEquals(Integer.valueOf(1), tondeuse.getCoordonneeX());
            assertEquals(Integer.valueOf(3), tondeuse.getCoordonneeY());
            assertEquals(Orientation.N, tondeuse.getOrientation());

            Commandes.avancer(tondeuse);
            assertEquals(Integer.valueOf(1), tondeuse.getCoordonneeX());
            assertEquals(Integer.valueOf(4), tondeuse.getCoordonneeY());
            assertEquals(Orientation.N, tondeuse.getOrientation());

            Commandes.avancer(tondeuse);
            assertEquals(Integer.valueOf(1), tondeuse.getCoordonneeX());
            assertEquals(Integer.valueOf(5), tondeuse.getCoordonneeY());
            assertEquals(Orientation.N, tondeuse.getOrientation());

            tondeuse.setOrientation(Orientation.W);
            Commandes.avancer(tondeuse);
            assertEquals(Integer.valueOf(0), tondeuse.getCoordonneeX());
            assertEquals(Integer.valueOf(5), tondeuse.getCoordonneeY());
            assertEquals(Orientation.W, tondeuse.getOrientation());
        }

        @Test
        public void testTondeuseOnBorders() {


            assertFalse(Commandes.isTondeuseOnBorder(tondeuse));

            tondeuse.setCoordonneeX(0);
            tondeuse.setOrientation(Orientation.W);
            assertTrue(Commandes.isTondeuseOnBorder(tondeuse));

            tondeuse.setCoordonneeY(5);
            tondeuse.setOrientation(Orientation.N);
            assertTrue(Commandes.isTondeuseOnBorder(tondeuse));

            tondeuse.setCoordonneeX(5);
            tondeuse.setOrientation(Orientation.E);
            assertTrue(Commandes.isTondeuseOnBorder(tondeuse));

            tondeuse.setCoordonneeY(0);
            tondeuse.setOrientation(Orientation.S);
            assertTrue(Commandes.isTondeuseOnBorder(tondeuse));

        }

    @Test
    public void testTondeuseOnField() {


        assertTrue(Commandes.isTondeuseIntoField(tondeuse));

        tondeuse.setCoordonneeX(-1);
        assertFalse(Commandes.isTondeuseIntoField(tondeuse));

        tondeuse.setCoordonneeY(6);
        assertFalse(Commandes.isTondeuseIntoField(tondeuse));

        tondeuse.setCoordonneeX(8);
        assertFalse(Commandes.isTondeuseIntoField(tondeuse));

        tondeuse.setCoordonneeY(-4);
        assertFalse(Commandes.isTondeuseIntoField(tondeuse));

        tondeuse.setCoordonneeX(0);
        tondeuse.setCoordonneeY(0);
        assertTrue(Commandes.isTondeuseIntoField(tondeuse));

        tondeuse.setCoordonneeX(5);
        assertTrue(Commandes.isTondeuseIntoField(tondeuse));

        tondeuse.setCoordonneeY(5);
        assertTrue(Commandes.isTondeuseIntoField(tondeuse));

    }


        @After
        public void fin() throws Exception {
            tondeuse = null;
        }




}
