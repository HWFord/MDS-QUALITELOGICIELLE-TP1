package com.tactfactory.tp1junit.model;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import com.tactfactory.tp1junit.manager.Jeu;

public class TU002 {
	@Test
	  public void testTU002CaseExiste() throws NoSuchMethodException, SecurityException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException {
		
		Jeu jeu = new Jeu(1, 1, 1);
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
        * caseExiste
        *
        * @param x
        * @param y
        * @param joueur
        */
       
        Method caseExiste = Jeu.class.getDeclaredMethod("caseExiste", int.class, int.class, int.class, Joueur.class);
        caseExiste.setAccessible(true);
        
        //Test case existe
        boolean resultCaseExiste = (boolean) caseExiste.invoke(joueur.getMap().get(0), 2, 2, joueur);
        assertTrue(resultCaseExiste);
        
        //Test placement bateau en 2 2 avec orientation 0
        boolean resultplacementBateau = (boolean) bateauPlacable.invoke(jeu, joueur.getMap().get(0), 2, 2, 2, joueur);
        assertTrue(resultplacementBateau);
        

	}
}
