package cases;

import java.util.Random;
import fenetres.FenetrePrincipale;
import io.Console;
import jeudeplateau.Case;
import jeumonopoly.JoueurMonopoly;
import jeumonopoly.PlateauMonopoly;

/**
 * Crée l'action de la case Service Public
*@author HEGEL MOTOKOUA
*/

public class CaseServicePublic extends Case {

	private JoueurMonopoly proprietaire;
	private boolean reponseQuestion = false;

	/**
	 * Indique le nom de la case et attribut un prix
	 * @param nom String
	 */
	public CaseServicePublic(String nom) {
		super(nom, 150);
	}

	@Override
	/**
	 * Méthode gérant l'appropriation d'un service public à un joueur <br />
	 * Gère le changement du loyer en fonction du nombre de service public possédé par un joueur
	 * @see Joueur
	 * @see Case
	 */
	public void actionCase(JoueurMonopoly joueur, PlateauMonopoly plateau, FenetrePrincipale fp) {

		Console es = new Console();

		if(this.getProprietaire() == null) {
			if(getReponseQuestion()) {
				if(acheterTerrain(joueur, fp))
					fp.setMarqueurProprietaire(joueur, this);
			}
			else {
				es.println(" > " + joueur.getNom() + " décide de ne pas acheter cette compagnie.");
				fp.afficherMessage(joueur.getNom() + " décide de ne pas acheter cette compagnie.");
			}
		}

		else if(this.getProprietaire() != joueur)
			payerLoyer(joueur, plateau, fp);

		else {
			es.println(" > " + joueur.getNom() + " possède la compagnie.");
			if(fp!=null) fp.afficherMessage("Le propriétaire est en prison. " + joueur.getNom() + " ne paye pas de loyer.");
		}
	}


	public boolean acheterTerrain(JoueurMonopoly joueur, FenetrePrincipale fp) {
		if((joueur.getArgent() - this.getPrix()) <= 0) {
			System.out.println("Vous n'avez pas assez d'argent!");
			return false;
		}
		else {
			setProprietaire(joueur);
			joueur.ajouterTerrain(this);
			joueur.retirerArgent(this.getPrix());
			joueur.setNbServices(joueur.getNbServices() + 1);

			System.out.println(" > " + joueur.getNom() + " achète " + this.getNom() + " pour " + this.getPrix() + "€");
			if(fp!=null) fp.afficherMessage(joueur.getNom() + " achète " + this.getNom() + " pour " + this.getPrix() + "€");
			return true;
		}
	}

	public void payerLoyer(JoueurMonopoly joueur, PlateauMonopoly pm, FenetrePrincipale fp) {
		String beneficiaire = "la Banque";

		if(!this.getProprietaire().getEstPrison()) {

			int loyer = pm.des.lancerDes();
			if(fp!=null) {
				fp.effacerDes();
				fp.afficherDes(pm);
			}

			if(this.getProprietaire().getNbServices() == 2) loyer*=10;
			else loyer*=4;

			System.out.println(" > " + joueur.getNom() + " lance les dés... [" + pm.des.getDe1() + "][" + pm.des.getDe2() + "]... et obtient un " + pm.des.getDes());
			joueur.retirerArgent(loyer);

			if(!this.getProprietaire().getEstBanqueroute()) {
				this.getProprietaire().ajouterArgent(loyer);
				beneficiaire = this.getProprietaire().getNom();
			}
			System.out.println(" > " + joueur.getNom() + " paye un loyer de " + loyer + "€ à " + beneficiaire);
			if(fp!=null) fp.afficherMessage(joueur.getNom() + " paye un loyer de " + loyer + "€ à " + beneficiaire);
		}
		else {
			System.out.println(" > Le propriétaire est en prison. " + joueur.getNom() + " ne paye pas de loyer.");
			if(fp!=null) fp.afficherMessage("Le propriétaire est en prison. " + joueur.getNom() + " ne paye pas de loyer.");
		}
	}

	@SuppressWarnings("static-access")
	@Override
	/**
	 * Affiche une fenêtre pour l'achat de la case et reprend le cours de la partie
	 */
	public void fenetreAction(FenetrePrincipale fp) {

		if(fp.getPartie().PARTIE_AUTO) {
			Random rand = new Random();
			if(rand.nextBoolean())
				reponseQuestion = true;
			fp.getPartie().reprendrePartie();
		}
		else if(this.getProprietaire() == null)
			fp.afficherFenetreAchatTerrain();
		else
			fp.getPartie().reprendrePartie();
	}


	/* ===========================
	   Méthodes abstraites de Case
	   =========================== */

	@Override
	public JoueurMonopoly getProprietaire() {
		return proprietaire;
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
		return reponseQuestion;
	}

	@Override
	public boolean getPeutMettreMaison() {
		return false;
	}

	@Override
	public void setProprietaire(JoueurMonopoly j) {
		this.proprietaire = j;
	}

	@Override
	public void setReponseQuestion(boolean b) {
		this.reponseQuestion = b;
	}

	@Override
	public String toString() {
		return "CaseServicePublic [" + super.toString() + ", proprietaire=" + (proprietaire==null?"null":proprietaire.getNom()) + "]";
	}


	public static void main(String[] args) {

		Console es = new Console();
		es.println("TEST DE LA CLASSE : CaseServicePublic");

		JoueurMonopoly j1 = new JoueurMonopoly("Yann", 0, 1000);
		JoueurMonopoly j2 = new JoueurMonopoly("Benoit", 1, 1000);
		PlateauMonopoly pm = new PlateauMonopoly(2);
		es.println(j1.toString()+"\n");

		CaseServicePublic c = (CaseServicePublic) pm.getCase(12);
		c.acheterTerrain(j1, null);

		es.println("== Nombres de SP de " + j1.getNom() + " : " + j1.getNbServices());

		c.payerLoyer(j2, pm, null);
		es.println("");

		c = (CaseServicePublic) pm.getCase(28);
		c.acheterTerrain(j1, null);
		es.println("== Nombres de SP de " + j1.getNom() + " : " + j1.getNbServices());

		c.payerLoyer(j2, pm, null);

		es.println("\n" + j1.toString());
	}

}
