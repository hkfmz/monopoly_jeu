package cartes;

import fenetres.FenetrePrincipale;
import io.Console;
import jeudeplateau.Carte;
import jeumonopoly.JoueurMonopoly;
import jeumonopoly.PlateauMonopoly;

/**
 * Type de {@link Carte} pour les payements des joueurs.<br><br>
 * &nbsp; <b>Liste des champs :</b>
 * <ul><li><b>montant</b> : int - montant à retirer au joueur.</li></ul>
 * @see Carte
 */
public class CartePayerArgent extends Carte {
	
	private int montant;
	
	/**
	 * Unique constructeur de la clase {@link CartePayerArgent}.
	 * @param titre String
	 * @param description String
	 * @param montant int
	 */
	public CartePayerArgent(String titre, String description, int montant) {
		super(titre, description);
		this.montant = montant;
	}

	/**
	 * Méthode réalisant l'action de la carte. 
	 * @param joueur JoueurMonopoly
	 * @param plateau PlateauMonopoly
	 * @param fp FenetrePrincipale
	 */
	@Override
	public void actionCarte(JoueurMonopoly joueur, PlateauMonopoly plateau, FenetrePrincipale fp) {
		
		Console es = new Console();
		
		if(getNom().equals("Président du conseil d'administration")) {
			for(int i=0; i<plateau.getNbJoueurs(); i++) {
				if(plateau.getJoueur(i) != joueur && !plateau.getJoueur(i).getEstBanqueroute()) {
					plateau.getJoueur(i).ajouterArgent(50);
					joueur.retirerArgent(50);
				}
			}
			es.println(" > "+joueur.getNom()+" verse 50€ à chaque joueur.");
			if(fp!=null)
				fp.afficherMessage(joueur.getNom()+" verse 50€ à chaque joueur.");
		}
		else {
			joueur.retirerArgent(montant);
			plateau.getCase(20).setPrix(plateau.getCase(20).getPrix() + montant);
			es.println(" > "+joueur.getNom()+" dépose "+montant+"€ au parc gratuit");
			if(fp !=null)
				fp.afficherMessage(joueur.getNom()+" dépose "+montant+"€ au parc gratuit");
		}
	}
	public int getMontant(){
		return this.montant;
	}

	@Override
	public String toString() {
		return "CartePayerArgent ["+ super.toString() +", montant= " + montant + "]";
	}
}
