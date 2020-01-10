package cases;

import fenetres.FenetrePrincipale;
import io.Console;
import jeudeplateau.Case;
import jeumonopoly.JoueurMonopoly;
import jeumonopoly.PlateauMonopoly;

/**
 * Crée l'action de la case Parc Gratuit
*@author HEGEL MOTOKOUA
*/
public class CaseParcGratuit extends Case {

	/**
	 * Indique le nom de la case et initialise sa valeur
	 */
	public CaseParcGratuit() {
		super("Parc Gratuit", 0);
	}

	/**
	 * Méthode permettant à un joueur de récupérer l'argent de la case Parc Gratuit, réinitialisant ensuite celle-ci à 0
	 * @see jeudeplateau.Joueur
	 * @see Case
	 */
	public void actionCase(JoueurMonopoly joueur, PlateauMonopoly plateau, FenetrePrincipale fp) {

		Console es = new Console();

		es.println(" > " + joueur.getNom() + " ramasse " + this.getPrix() + "€ du Parc Gratuit !");
		if(fp!=null)
			fp.afficherMessage(joueur.getNom() + " ramasse " + this.getPrix() + "€ du Parc Gratuit !");
		joueur.ajouterArgent(this.getPrix());
		this.setPrix(0);
	}

	public static void main(String[] args){

		System.out.println("TEST DE LA CLASSE : CaseParcGratuit");
		JoueurMonopoly j = new JoueurMonopoly("Yann", 0, 1000);
		PlateauMonopoly p = new PlateauMonopoly(4);

		CaseParcGratuit c = (CaseParcGratuit) p.getCase(20);

		c.setPrix(300);
		System.out.println("Initialisation de la case Parc Gratuit à 300€ : "+ c.toString());
		System.out.println("Joueur avant le parc gratuit : "+ j.toString());
		j.setPosition(20);
		c.actionCase(j, p, null);

		System.out.println("Case Parc Gratuit après le passage du joueur : " + c.toString());
		System.out.println("Joueur après le parc gratuit : " + j.toString());
	}

	@Override
	/**
	 * Reprend le cours de la partie
	 */
	public void fenetreAction(FenetrePrincipale fp) {
		fp.getPartie().reprendrePartie();
	}


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
		return "CaseParcGratuit [" + super.toString() + "]";
	}

}
