package jeudeplateau;

import fenetres.FenetrePrincipale;
import jeumonopoly.JoueurMonopoly;
import jeumonopoly.PlateauMonopoly;

/**
 * Définit les cartes du Monopoly
*@author HEGEL MOTOKOUA
*/

public abstract class Carte {

	private String titre;
	private String description;

	/**
	 * Définit une carte avec un titre et une description
	 * @param titre String
	 * @param description String
	 */
	public Carte(String titre, String description) {
		this.titre = titre;
		this.description = description;
	}

	/**
	 * Renvoie le titre de la carte
	 * @return titre
	 */
	public String getNom() {
		return this.titre;
	}

	/**
	 * Renvoie la description de la carte
	 * @return description
	 */
	public String getDesc() {
		return this.description;
	}

	/**
	 * Action de la carte en fonction du joueur, sur le plateau
	 * @param joueur JoueurMonopoly
	 * @param plateau PlateauMonopoly
	 * @param fp FenetrePrincipale
	 * @see cartes.CarteDeplacement
	 * @see cartes.CartePayerArgent
	 * @see cartes.CarteRecevoirArgent
	 * @see cartes.CarteSortirPrison
	 */
	public abstract void actionCarte(JoueurMonopoly joueur, PlateauMonopoly plateau, FenetrePrincipale fp);

	@Override
	public String toString() {
		return "Carte [titre=" + titre + ", description=" + description + "]";
	}
}
