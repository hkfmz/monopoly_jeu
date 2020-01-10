package jeudeplateau;

/**
 * Définit le joueur
*@author HEGEL MOTOKOUA
*/

public abstract class Joueur {

	private String nom;
	private int id;
	private int position = 0;

	/**
	 * Définit un joueur avec un nom et son identifiant
	 * @param nom String
	 * @param id int
	 */
	public Joueur(String nom, int id) {
		setNom(nom);
		setID(id);
	}

	/**
	 * Renvoie le nom du joueur
	 * @return nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Définit le nom d'un joueur (s'il est nul, une exception est levée)
	 * @param nom String
	 */
	public void setNom(String nom) {
		if(nom == null || nom.isEmpty())
			throw new IllegalArgumentException("Le nom ne peux pas être vide ou null");
		this.nom = nom;
	}
	/**
	 * Renvoie l'identifiant du joueur
	 * @return id
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * Définit l'identifiant d'un joueur
	 * @param id int
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * Renvoie la position d'un joueur
	 * @return position
	 */
	public int getPosition() {
		return this.position;
	}

	/**
	 * Définit la position d'un joueur
	 * @param pos int
	 */
	public void setPosition(int pos) {
		this.position = pos;
	}

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", id=" + id + ", position=" + position + "]";
	}

}
