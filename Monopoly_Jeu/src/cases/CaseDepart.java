package cases;

import fenetres.FenetrePrincipale;
import io.Console;
import jeudeplateau.Case;
import jeumonopoly.JoueurMonopoly;
import jeumonopoly.PlateauMonopoly;

/**
 * Crée l'action d'une case départ
*@author HEGEL MOTOKOUA
*/

public class CaseDepart extends Case {

	/**
	 * Indique le nom de la case
	 */
	public CaseDepart() {
		super("Depart", 0);
	}

	/**
	 * Ajoute l'argent du passage sur la case
	 * @see Case
	 */
	public void actionCase(JoueurMonopoly joueur, PlateauMonopoly plateau, FenetrePrincipale fp) {

		Console es = new Console();

		joueur.ajouterArgent(200);
		es.println(" > " + joueur.getNom() + " s'arrête sur la case départ: il reçoit 2000€ supplémentaire !");
		if(fp!=null) fp.afficherMessage(joueur.getNom() + " s'arrête sur la case départ et reçoit 4000€ !");
	}


	@Override
	/**
	 * Reprend la partie
	 */
	public void fenetreAction(FenetrePrincipale fp) {
		fp.getPartie().reprendrePartie();
	}


	public static void main(String[] args){

		System.out.println("TEST DE LA CLASSE : CaseDepart\n");
		JoueurMonopoly j = new JoueurMonopoly("Yann", 0, 1000);
		PlateauMonopoly p = new PlateauMonopoly(4);

		CaseDepart c = (CaseDepart) p.getCase(0);

		j.setPosition(38);
		System.out.println("\nLe joueur est sur la case " + p.getCase(j.getPosition()).toString()+"\n");
		p.deplacerJoueur(j, 2);
		c.actionCase(j, p, null);
		System.out.println("Le joueur possède : " + j.getArgent()+"€\n");

		j.setPosition(38);
		System.out.println("\nLe joueur est sur la case " + p.getCase(j.getPosition()).toString()+"\n");
		p.deplacerJoueur(j, 3);
		System.out.println("\nLe joueur est sur la case " + p.getCase(j.getPosition()).getNom()+"\n");
		System.out.println("Le joueur possède : " + j.getArgent()+"€\n");
	}

	/* ===========================
	   Méthodes abstraites de Case
	   =========================== */

	@Override
	public JoueurMonopoly getProprietaire() {
		return null;
	}

	@Override
	public String getCouleur() {
		return null;
	}

	@Override
	public int getLoyer() {
		return 0;
	}

	@Override
	public int getPrixMaison() {
		return 0;
	}

	@Override
	public int getNbMaison() {
		return 0;
	}

	@Override
	public boolean getReponseQuestion() {
		return false;
	}

	@Override
	public boolean getPeutMettreMaison() {
		return false;
	}

	@Override
	public void setProprietaire(JoueurMonopoly j) {}

	@Override
	public void setReponseQuestion(boolean b) {}

	@Override
	public String toString() {
		return "CaseDepart ["+super.toString()+"]";
	}

}
