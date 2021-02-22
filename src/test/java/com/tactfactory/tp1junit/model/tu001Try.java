package com.tactfactory.tp1junit.model;

import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.tactfactory.tp1junit.manager.Jeu;

public class tu001Try {
	
	@Test
	public void testNonModifiableBoat() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<Navire> carte = new ArrayList<Navire>();
		Jeu jeu = new Jeu(4,24,18);
		Navire navire = new PorteAvion();
							 
		Method placeBoat = Jeu.class.getDeclaredMethod("placeBateau");
		placeBoat.setAccessible(true);
		//invokes placeboat with jeu naivre and coordinates allows us to place boat
		placeBoat.invoke(jeu,navire, 0,0,0);
	

	}
	
//  private void placementBateau(Joueur joueur, Navire navire) {​​​​
//  }​​​​

//  private void placeBateau(Navire navire, int x, int y, int direction) {​​​​
//  }​​​​

//  private boolean bateauPlacable(Navire navire, int x, int y, int direction, Joueur joueur) {​​​​
//  }​​​​

//  private boolean caseExiste(int x, int y, Joueur joueur) {​​​​
//  }​​​​
	
}

//pose bateau sur carte et fonction qui test qu'un bateau est posable
//creer une carte, poser un 1er bateau et venir essaye de poser autre bateau
//navire possede list case qui represnte poisition du navire dans la carte
//avoir une carte (= liste de navire pour jouer) dans test creer liste navire
//
