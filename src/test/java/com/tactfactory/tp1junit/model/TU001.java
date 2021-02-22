package com.tactfactory.tp1junit.model;
	 

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test; 

import com.tactfactory.tp1junit.manager.Jeu;
import com.tactfactory.tp1junit.model.Case;
import com.tactfactory.tp1junit.model.Navire;
import com.tactfactory.tp1junit.model.PorteAvion;

public class TU001 {

	   /**
	    * Test TU-001 par validation de la fonction placeBateau
	    * @throws NoSuchMethodException
	    * @throws SecurityException
	    * @throws IllegalAccessException
	    * @throws IllegalArgumentException
	    * @throws InvocationTargetException
	    */
	  @Test
	  public void testTU001ParPlaceBateau() throws NoSuchMethodException, SecurityException, IllegalAccessException,
	            IllegalArgumentException, InvocationTargetException {
	        List<Navire> map = new ArrayList<Navire>();//list de navires avec des portes avions
	        Navire navire1 = new PorteAvion();
	        Navire navire2 = new PorteAvion();
	        map.add(navire1);
	        map.add(navire2);

	 
	        //déclarer jeu comme nouveau jeu
	        Jeu jeu = new Jeu(4, 24, 18);
	        Method method = Jeu.class.getDeclaredMethod("placeBateau", Navire.class, int.class, int.class, int.class);
	        method.setAccessible(true);

	 

	        // Placement du premier bateau en 0 0 avec orientation 0
	        method.invoke(jeu, map.get(0), 0, 0, 0);

	 

//	        for (Case item : map.get(0).getCases()) {
//	            System.out.println(item.getX() + " : " + item.getY());
//	        }

	 

	        // Placement du deuxième bateau en 0 0 avec orientation 0
	        method.invoke(jeu, map.get(1), 0, 0, 0);

	 

//	        for (Case item : map.get(1).getCases()) {
//	            System.out.println(item.getX() + " : " + item.getY());
//	        }

	 
	        //recupere liste de cases
	        List<Case> caseErros = new ArrayList<Case>();

	 

	        // Les deux bateaux on la même taille donc je regarde la taille du bateau 1 et
	        // regarde si le bateau 2 est positionné sur au moins une des cases prises par
	        // le bateau 1
	        //verfier que lelement est bien insérer
	        for (int i = 0; i < map.get(0).getCases().size(); i++) {
	            if (map.get(0).getCases().get(i).getX() == map.get(1).getCases().get(i).getX()
	                    && map.get(0).getCases().get(i).getY() == map.get(0).getCases().get(i).getY()) {
	                caseErros.add(map.get(0).getCases().get(i));
	            }
	        }

	 

	        // Si il existe au moins une case commune alors c'est une erreur
	        //si la case n'est pas vide j'ai une erreur, un bateau est deja sur cette case
	        if (!caseErros.isEmpty()) {
	            StringBuilder errors = new StringBuilder();

	 

	            for (int i = 0; i < caseErros.size() - 1; i++) {
	                errors.append(caseErros.get(i).getX() + ":" + caseErros.get(i).getY() + " |");
	            }
	            errors.append(caseErros.get(caseErros.size() - 1).getX() + ":" + caseErros.get(caseErros.size() - 1).getY());

	 

	            fail("Les cases du bateau 1 et du bateau 2 sont identique aux positions : " + errors.toString());
	        }
	    }

	  	/** Test TU-001 par validation de la fonction bateauPlacable.
	     *
	     * @throws NoSuchMethodException
	     * @throws SecurityException
	     * @throws IllegalAccessException
	     * @throws IllegalArgumentException
	     * @throws InvocationTargetException
	     */
	    @Test
	    public void testTU001ParBateauPlacable() throws NoSuchMethodException, SecurityException, IllegalAccessException,
	            IllegalArgumentException, InvocationTargetException {

	        Jeu jeu = new Jeu(4, 24, 18);
	        Joueur joueur = jeu.getJoueurs().get(0);

	        /** bateauPlacable
	         *
	         * @param navire
	         * @param x
	         * @param y
	         * @param direction : 0 | 1
	         * @param joueur
	         * @return boolean
	         */
	        Method bateauPlacable = Jeu.class.getDeclaredMethod("bateauPlacable", Navire.class, int.class, int.class,
	                int.class, Joueur.class);
	        bateauPlacable.setAccessible(true);

	        /**
	         * placeBateau
	         *
	         * @param navire
	         * @param x
	         * @param y
	         * @param direction
	         */
	        Method method = Jeu.class.getDeclaredMethod("placeBateau", Navire.class, int.class, int.class, int.class);
	        method.setAccessible(true);

	        // Test Placement du premier bateau en 0 0 avec orientation 0
	        boolean result = (boolean) bateauPlacable.invoke(jeu, joueur.getMap().get(0), 0, 0, 0, joueur);
	        assertTrue(result);

	        // Placement du premier bateau en 0 0 avec orientation 0
	        method.invoke(jeu, joueur.getMap().get(0), 0, 0, 0);

	        // Test Placement du second bateau en 0 0 avec orientation 0
	        result = (boolean) bateauPlacable.invoke(jeu, joueur.getMap().get(1), 0, 0, 0, joueur);
	        assertFalse(result);
	    }


	}
	

