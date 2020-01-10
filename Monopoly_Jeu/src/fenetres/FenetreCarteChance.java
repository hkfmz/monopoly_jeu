package fenetres;

import cases.CaseChance;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Fenêtre à afficher lorqu'on atterit sur une {@link CaseChance}.
 * @see FenetrePrincipale
 */
public class FenetreCarteChance {

	private FenetrePrincipale fp;
	private Stage stage;
	private HBox root;
	private VBox carte;
	private Button b_Ok;
	private Label l_Titre = new Label("CHANCE");
	private Label l_Description = new Label("?");
	
	/**
	 * Unique constructeur de la classe {@link FenetreCarteChance}, prenant en paramètre la {@link FenetrePrincipale} fp.
	 * @param fp FenetrePrincipale
	 * @see FenetrePrincipale
	 */
	public FenetreCarteChance(FenetrePrincipale fp) {
		
		this.fp = fp;
		
		this.stage = new Stage();
		this.stage.setTitle("Carte Chance");
		this.stage.initOwner(fp.getStage());
		this.stage.initModality(Modality.APPLICATION_MODAL);
		
		root = new HBox();
		initRoot();
		
		Scene scene = new Scene(root,440,200);
		stage.setScene(scene);
		
		stage.setOnHiding(new EvtQuitter());
	}
	
	/**
	 * Initialise la HBox root de la FenetreCarteChance avec une image, une description de la carte et un bouton OK.
	 */
	private void initRoot() {
		
		root.setFillHeight(true);
		root.setAlignment(Pos.CENTER_LEFT);
		root.setPadding(new Insets(10,10,10,10));
		root.setSpacing(15);
		root.setStyle("-fx-background-color: #CDE6D0; -fx-border-style: dashed; -fx-border-width: 3px; -fx-border-color: orange");
		
		Image i_chance = new Image("images/chance.jpg");
		ImageView iv_chance = new ImageView(i_chance);
		root.getChildren().add(iv_chance);
		
		this.carte = new VBox();
		carte.setFillWidth(true);
		
		l_Titre.setStyle("-fx-font-size: 20px");
		carte.getChildren().add(l_Titre);
		l_Description.setStyle("-fx-padding: 10px 0px");
		carte.getChildren().add(l_Description);
		
		b_Ok = new Button("OK");
		b_Ok.setDefaultButton(true);
		b_Ok.setOnAction(new EvtValider());
		carte.getChildren().add(b_Ok);
		
		root.getChildren().add(carte);
	}
	
	/**
	 * Renvoie la Stage de la fenêtre.
	 * @return stage Stage
	 */
	public Stage getStage() {
		return stage;
	}
	
	/**
	 * Définit le titre de la carte.
	 * @param titre String
	 */
	public void setTitre(String titre) {
		l_Titre = new Label("CHANCE");
	}
	/**
	 * Définit la description de la carte.
	 * @param description String
	 */
	public void setDescription(String description) {
		l_Description = new Label(description);
	}
	
	/**
	 * Affiche la fenêtre en réinitialisant la HBox root à chaque appel.
	 */
	public void afficherCarte() {
		root = new HBox();
		initRoot();
		
		Scene scene = new Scene(root,440,200);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Évènement qui ferme la fenêtre.
	 */
	private class EvtValider implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			stage.close();
			event.consume();
		}
	}
	
	/**
	 * Évènement qui reprend la partie quand la fenêtre se ferme.
	 */
	private class EvtQuitter implements EventHandler<WindowEvent> {

		@Override
		public void handle(WindowEvent event) {
			fp.getPartie().reprendrePartie();
			event.consume();
		}
	}
}
