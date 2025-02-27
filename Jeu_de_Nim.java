package jeu-de-nim;

import util.IO;

public class Jeu_de_Nim {
	/**
	 * lecture d'un nombre entre a et b : r�p�te la demande tant que le nombre n'est
	 * pas trouv�
	 * @param a minimum de l'intervalle
	 * @param b maximum de l'intervalle
	 * @return la valeur lue
	 * @Precondition a<=b (sinon boucle infinie)
	 */
	public static int lit_entre_intervalle(int a, int b) {
		int nb;
		nb = IO.lireInt();
		while ((nb<a) || (nb>b)) {
			System.out.print("Mauvaise valeur. Reessayez : ");
			nb = IO.lireInt();
		}
		return nb;
	}
	
	
	/**
	 * fonction principale du jeu. Beaucoup trop longue, � vous de la
	 * couper en fonctions interm�diaires.
	 * @param args (non utilis�)
	 */
	public static int mise_en_place() {

		/** presentation du jeu => en fonction, doit retourner la taille du tas **/
		System.out.println("Jeu de nim");
		System.out.println("----------");
		System.out.println("Vous avez un tas de batons.");
		System.out.println("A chaque tour, vous (ou l'ordinateur) prenez 1, 2 ou 3 batons.");
		System.out.println("Celui qui enleve le dernier baton a gagne.");
		System.out.println("L'ordinateur commence, mais vous pouvez choisir le nombre initial de batons.");
		System.out.print("Combien de batons au debut (entre 10 et 25) ? ");
		/** lecture entre 10 et 25 **/
		return lit_entre_intervalle(10,25);
	}
	
	public static int jeu_ordinateur(int pile){
		int nb;
		if (pile%4==0) {
			/* position perdante. On enleve entre 1 et 3 b�tons au hasard */
			nb=(int) (Math.random()*3)+1;
		} else {
			/* position gagnante */
			nb=pile%4;
		}
		return nb;
	}
	public static int jeu_humain(int pile) {
		/*** Le joueur joue. **/
		int mx_pions; /* on ne peut pas enlever plus de batons qu'il y en a :
        mx_pions va donc contenir le minimum entre 3 et le nombre de batons,
                              et indique le nombre de pions maximum que peut enlever le joueur */
		mx_pions=3;
		if (mx_pions>pile) {
			mx_pions = pile;
		}
		System.out.print("A vous de jouer. Combien de baton(s) a enlever (de 1 � " + mx_pions + ") : ");
		return lit_entre_intervalle(1,mx_pions);
	}

		/*** affichage de la fin, a mettre en fonction ***/
	public static void affiche_vainqueur(int joueur) {
		if (joueur==1) {
			/* c'est a l'ordinateur de jouer, donc c'est l'humain qui a enleve le dernier pion */
			System.out.println("Vous avez gagne. Bravo !");
		} else {
			System.out.println("L'ordinateur a gagne. A bientot pour la revanche.");
		}

	}
	public static void main(String[] args) {
		int joueur, pile;
		pile = mise_en_place();
		joueur = 1;
		while (pile>0) {
			int nb_a_retirer;
			System.out.println("Il reste " + pile + " batons");
			if(joueur==1) {
				nb_a_retirer = jeu_ordinateur(pile);
				System.out.println("L'ordinateur enlève "+nb_a_retirer+"baton(s).");
			}else {
				nb_a_retirer = jeu_humain(pile);
				System.out.println("Vous enlevez "+nb_a_retirer+" baton(s).");
			}
			pile = pile-nb_a_retirer;
			if(joueur==1) {
				joueur=2;
			}else {
				joueur=1;
			}
		}
		System.out.println("Le tas est vide. ");
		affiche_vainqueur(joueur);
	}
     
}
