package jeudeplateau;

import java.util.ArrayList;
import cases.CaseAllerPrison;
import cases.CaseChance;
import cases.CaseCommunaute;
import cases.CaseDepart;
import cases.CaseGare;
import cases.CaseImpots;
import cases.CaseParcGratuit;
import cases.CasePrison;
import cases.CaseServicePublic;
import cases.CaseTerrain;
import fenetres.FenetrePrincipale;
import javafx.scene.shape.Polygon;
import jeumonopoly.JoueurMonopoly;
import jeumonopoly.PlateauMonopoly;

/**
 * Définit les cases du Monopoly
*@author HEGEL MOTOKOUA
*/

public abstract class Case {

	private String nom;
	private int id = 0;
	private int valeur = 0;

	/* ON A RIEN VU */
	private Polygon marqueur = new Polygon();
	public ArrayList<Polygon> maisons = new ArrayList<Polygon>();

	/**
	 * Définit le nom de la case
	 * @param nom String
	 * @param valeur int
	 */
	public Case(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;

		/* OUI ON SAIT QUE C'EST PAS BIEN, PARDON */
		for(int i=0; i<6; i++) {
			Polygon maison = new Polygon();
			maisons.add(maison);
		}
	}

	/**
	 * Renvoie le nom de la case
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Définit l'identifiant de la case
	 * @return id
	 */
	public int getId(){
		return id;
	}

	/**
	 * Met à jour l'identifiant de la case
	 * @param id int
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 * Renvoie le prix de la case
	 * @return prix
	 */
	public int getPrix() {
		return valeur;
	}

	/**
	 * Définit le prix de la case
	 * @param valeur int
	 */
	public void setPrix(int valeur) {
		this.valeur = valeur;
	}

	/* PARTIE GRAPHIQUE (déso pas déso) */

	/**
	 * Renvoie le marqueur de possession d'une case d'un joueur
	 * @return marqueur
	 */
	public Polygon getMarqueur(){
		return this.marqueur;
	}

	/**
	 * Définit un marqueur de possession d'une case
	 * @param r Polygon
	 */
	public void setMarqueur(Polygon r){
		this.marqueur = r;
	}

	/* PARTIE ABSTRAITE */

	/**
	 * Renvoie le joueur propriétaire d'une case
	 * @return proprietaire
	 */
	public abstract JoueurMonopoly getProprietaire();

	/**
	 * Renvoie la couleur de la case
	 * @return couleur
	 */
	public abstract String getCouleur();

	/**
	 * Renvoie le loyer du terrain en fonction du nombre de maisons posées sur ledit terrain
	 * @return apayer
	 */
	public abstract int getLoyer();

	/**
	 * Renvoie le prix d'une maison
	 * @return prixMaison
	 */
	public abstract int getPrixMaison();

	/**
	 * Renvoie le nombre de maisons posées sur un terrain
	 * @return nbMaison
	 */
	public abstract int getNbMaison();

	/**
	 * Renvoie la réponse à une question (Pour l'achat d'un terrain par exemple)
	 * @return reponseQuestion
	 */
	public abstract boolean getReponseQuestion();

	/**
	 * Permet de savoir si un joueur peut poser une maison ou non, il peut si : <br>
	 * <ul>
	 * <li> Il possède tous les terrains d'une même couleur;</li>
	 * <li>Le nombre de maisons sur chaque terrain doit être identique pour en rajouter (cad 1 maison sur chaque terrain pour pouvoir en poser une deuxième);</li>
	 * </ul>
	 * @return boolean
	 * @see JoueurMonopoly
	 */
	public abstract boolean getPeutMettreMaison();

	/**
	 * Définit le propriétaire de la case.
	 * @param j : {@link JoueurMonopoly}
	 */
	public abstract void setProprietaire(JoueurMonopoly j);

	/**
	 * Permet de définir la réponse de l'utilisateur choisit via les boutons de l'interface, ou aléatoirement si la partie est en mode automatique.
	 * @param b : boolean
	 */
	public abstract void setReponseQuestion(boolean b);

	/**
	 * Appelle la fenêtre d'action de la case (ex: 'Acheter un terrain', 'Tirer une carte', etc.)
	 * @param fp : {@link FenetrePrincipale}
	 */
	public abstract void fenetreAction(FenetrePrincipale fp);

	/**
	 * Action de la case lorsqu'un joueur tombe dessus
	 * @param joueur JoueurMonopoly
	 * @param plateau PlateauMonopoly
	 * @param fp FenetrePrincipale
	 * @see CaseDepart
	 * @see CaseCommunaute
	 * @see CaseImpots
	 * @see CaseGare
	 * @see CaseChance
	 * @see CasePrison
	 * @see CaseServicePublic
	 * @see CaseParcGratuit
	 * @see CaseAllerPrison
	 * @see CaseTerrain
	 */
	public abstract void actionCase(JoueurMonopoly joueur, PlateauMonopoly plateau, FenetrePrincipale fp);


	@Override
	public String toString() {
		return "Case [nom=" + nom + ", id=" + id + ", valeur=" + valeur + "]";
	}

}
