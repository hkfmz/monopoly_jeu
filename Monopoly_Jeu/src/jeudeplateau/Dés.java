package jeudeplateau;

import java.util.Random;

/**
 * Crée les dés utilisés pour le jeu
*@author HEGEL MOTOKOUA
*/

public class Dés {

	private int de1;
	private int de2;
	private Random rand = new Random();

	/**
	 * Renvoie le nombre obtenu par le lancé de dé
	 * @return nombreLancé
	 */
	public int getDes() {
		return (this.de1 + this.de2);
	}

	/**
	 * Renvoie le chiffre obtenu par le premier dé
	 * @return de1
	 */
	public int getDe1(){
		return this.de1;
	}

	/**
	 * Renvoie le chiffre obtenu par le deuxième dé
	 * @return de2
	 */
	public int getDe2(){
		return this.de2;
	}

	/**
	 * Attribue un nombre aléatoire aux 2 dés et les additionne
	 * @return nombreDés
	 */
	public int lancerDes() {
		this.de1 = 1+this.rand.nextInt(6);
		this.de2 = 1+this.rand.nextInt(6);

		return getDes();
	}

}