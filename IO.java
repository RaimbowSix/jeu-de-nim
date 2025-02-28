package jeu-de-nim;

import java.util.Scanner;

// Fonctions d'entr�es de base
// lecture d'entiers, de flottant, de bool�ens, de chaine

public final class IO {
	
	private static Scanner entree = new Scanner(System.in);
	
	/**
	 * lit l'entier (type int) suivant sur l'entr�e standard et le retourne
	 * @return l'entier lu
	 */
	public static int lireInt() {
		int lu = entree.nextInt();
		return lu;
	}
	/**
	 * lit le flottant (type double) suivant sur l'entr�e standard et le retourne
	 * @return le double lu
	 */
	public static double lireDouble() {
		double lu = entree.nextDouble();
		return lu;
	}
	/**
	 * lit un caract�re (le premier caract�re du prochain mot lu)
	 * ce caract�re ne peut �tre ni un espace, ni un passage � la ligne
	 * @return le caract�re lu
	 */
	public static char LireChar() {
		char lu = entree.next(".").charAt(0);
		while (Character.isSpaceChar(lu)) {
			lu = entree.next(".").charAt(0);
		}
		return lu;
		
	}
	/** lit sur l'entr�e standard et retourne le prochain mot
	 *  (entre espaces ou retour � la ligne) 
	 * @return le mot lu
	 */
	public static String lireString() {
		String lu = entree.next();
		return lu;
	}
	
	/** lit une ligne non vide 
	 * @return la ligne lue
	 */
	public static String lireLigne() {
		String lu = entree.nextLine();
		while (lu.isBlank()) {
			lu = entree.nextLine();
		}
		return lu;
	}
	
}
