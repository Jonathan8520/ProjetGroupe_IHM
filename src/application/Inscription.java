package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Inscription extends Application {

	@Override
	public void start(Stage primaryStage) {

		// Création de la barre de navigation (Navbar)
		BorderPane navBar = new BorderPane();
		navBar.getStyleClass().add("navbar");

		// Logo Reverso
		ImageView reversoLogo = new ImageView(new Image(getClass().getResourceAsStream("/images/logo.png")));
		reversoLogo.setFitHeight(30);
		reversoLogo.setPreserveRatio(true);

		// Boutons de la navbar pour différentes pages
		Button btnTraduction = new Button("Traduction");
		Button btnDefinition = new Button("Définition");
		Button btnExpression = new Button("Expression");
		Button btnCorrection = new Button("Correction");
		Button btnSynonymes = new Button("Synonymes");
		Button btnConjugaison = new Button("Conjugaison");

		// Action pour le bouton Définition (ferme la page actuelle et ouvre la page Définition)
		btnDefinition.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Fermer la page actuelle et ouvrir la page de définition
				Stage pageActuelle = (Stage) navBar.getScene().getWindow(); // Récupérer la page actuelle grâce à un élément lui appartenant
				pageActuelle.close(); // Fermer la page actuelle
				Definition pageDuBtn = new Definition(); // Créer la page de définition
				pageDuBtn.start(new Stage()); // Ouvrir la page de définition
			}
		});

		// Action pour le bouton Expression (ferme la page actuelle et ouvre la page Expression)
		btnExpression.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Même principe que pour le bouton Définition
				Stage pageActuelle = (Stage) navBar.getScene().getWindow();
				pageActuelle.close();
				Expression pageDuBtn = new Expression();
				pageDuBtn.start(new Stage());
			}
		});

		// Bouton d'inscription
		Button btnInscription = new Button("Inscription");
		btnInscription.setStyle("-fx-underline: true; -fx-background-color: #1b4f82;");
		btnInscription.setId("btnInscription");

		// Logo utilisateur (icône de connexion)
		ImageView logoUser = new ImageView(new Image(getClass().getResourceAsStream("/images/userLogo.png")));
		logoUser.setFitHeight(35);
		logoUser.setPreserveRatio(true);

		// Bouton de connexion avec une icône (sans fond)
		Button logoConnexion = new Button();
		logoConnexion.setGraphic(logoUser);
		logoConnexion.setStyle("-fx-background-color: transparent;");

		// Liste déroulante pour sélectionner la langue du site
		ComboBox<String> listeLanguesSite = new ComboBox<>();
		listeLanguesSite.getItems().addAll("FR", "EN", "ES", "IT", "RU");
		listeLanguesSite.setValue("FR");
		listeLanguesSite.getStyleClass().add("listeLanguesSite");

		// MenuButton avec options (à propos, conctact, etc.)
		ImageView imgTroisPoints = new ImageView(new Image(getClass().getResourceAsStream("/images/optButton.png")));
		imgTroisPoints.setFitHeight(30);
		imgTroisPoints.setPreserveRatio(true);

		MenuButton btnTroisPoints = new MenuButton();
		btnTroisPoints.setGraphic(imgTroisPoints);
		btnTroisPoints.getItems().addAll(
				new MenuItem("À propos de Reverso"),
				new MenuItem("Reverso pour les entreprises"),
				new MenuItem("Newsletter"),
				new MenuItem("Contactez-nous"));
		btnTroisPoints.getStyleClass().add("btnTroisPoints");

		// HBox pour le côté gauche de la barre de navigation
		HBox leftNav = new HBox(10);
		leftNav.setAlignment(Pos.CENTER);
		leftNav.setPadding(new Insets(0, 0, 0, 20));
		leftNav.getChildren().addAll(reversoLogo, btnTraduction, btnDefinition, btnExpression, btnCorrection,
				btnSynonymes, btnConjugaison);

		// HBox pour le côté droit de la barre de navigation
		HBox rightNav = new HBox(10);
		rightNav.setAlignment(Pos.CENTER);
		rightNav.setPadding(new Insets(0, 20, 0, 0));
		rightNav.getChildren().addAll(
				btnInscription, logoConnexion, listeLanguesSite, btnTroisPoints);

		// Insertion des éléments dans la Navbar
		navBar.setLeft(leftNav);
		navBar.setRight(rightNav);

		//
		//// Fin de la barre de navigation ////
		//
		//// Début de la page ////
		//

		// Création du formulaire d'inscription
		Label label = new Label("Adresse e-mail :");
		label.setStyle("-fx-text-fill: #1b4f82; -fx-font-weight: bold;");
		TextField text = new TextField();
		text.setPromptText("Entrez votre mail");
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(label, text);
		hbox.setAlignment(Pos.CENTER_RIGHT);

		Label label1 = new Label("Mot de passe :");
		label1.setStyle("-fx-text-fill: #1b4f82; -fx-font-weight: bold;");
		TextField text1 = new TextField();
		text1.setPromptText("Entrez votre mot de passe");
		HBox hbox1 = new HBox(20);
		hbox1.getChildren().addAll(label1, text1);
		hbox1.setAlignment(Pos.CENTER_RIGHT);

		Label label2 = new Label("Confirmez votre mot de passe :");
		label2.setWrapText(true); // retour à la ligne si le texte est trop long
		TextField text2 = new TextField();
		text2.setPromptText("Entrez votre mot de passe");
		HBox hbox2 = new HBox(20);
		hbox2.getChildren().addAll(label2, text2);
		hbox2.setAlignment(Pos.CENTER_RIGHT);

		// Groupement des champs dans un VBox
		VBox groupe = new VBox(15, hbox, hbox1, hbox2);
		VBox.setMargin(groupe, new Insets(0, 250, 0, 250)); // Centrer le groupe sur la page

		// Case à cocher pour la newsletter
		CheckBox checkbox1 = new CheckBox("Je souhaite être informé des nouveautés de Reverso.");
		checkbox1.setStyle("-fx-font-weight: bold;");

		// Bouton d'inscription
		Button boutonInscrire = new Button("S'inscrire");
		boutonInscrire.getStyleClass().add("blue-button");

		// Texte pour les conditions d'utilisation
		Text partiephrase = new Text("en vous inscrivant, vous acceptez nos");
		partiephrase.setStyle("-fx-font-weight: bold;");
		Hyperlink lien = new Hyperlink("conditions d'utilisation");
		TextFlow phrase = new TextFlow(partiephrase, lien);

		HBox hboxphrase = new HBox(phrase);
		hboxphrase.setAlignment(Pos.CENTER); // Centrer le texte

		// Séparateurs et boutons pour s'inscrire via les réseaux sociaux
		Separator separatorGauche = new Separator();
		Label label3 = new Label("Ou s'inscrire avec");
		Separator separatorDroit = new Separator();

		separatorGauche.setPrefWidth(150);
		separatorDroit.setPrefWidth(150);

		HBox lignehaut = new HBox(10, separatorGauche, label3, separatorDroit);
		lignehaut.setAlignment(Pos.CENTER);
		lignehaut.setPadding(new Insets(10));
		lignehaut.setPrefWidth(400);

		// Icônes des réseaux sociaux
		ImageView iconeFacebook = new ImageView(new Image(getClass().getResourceAsStream("/images/facebook.png")));
		ImageView iconeGoogle = new ImageView(new Image(getClass().getResourceAsStream("/images/google.png")));
		ImageView iconeApple = new ImageView(new Image(getClass().getResourceAsStream("/images/apple.png")));

		// Mise en forme des icônes
		iconeFacebook.setFitHeight(40);
		iconeFacebook.setFitWidth(40);
		iconeFacebook.setStyle("-fx-cursor: hand");

		iconeGoogle.setFitHeight(40);
		iconeGoogle.setFitWidth(40);
		iconeGoogle.setStyle("-fx-cursor: hand");

		iconeApple.setFitHeight(40);
		iconeApple.setFitWidth(40);
		iconeApple.setStyle("-fx-cursor: hand");

		// Ajout des icônes dans un HBox
		HBox troisIcones = new HBox(50, iconeFacebook, iconeGoogle, iconeApple);
		troisIcones.setAlignment(Pos.CENTER);
		troisIcones.setPadding(new Insets(10));

		// Séparateur final
		Separator separatorBas = new Separator();
		separatorBas.setMaxWidth(400);

		// Lien pour se connecter si on a déjà un compte
		Text partiephrase1 = new Text("Vous avez déjà un compte ? ");
		Hyperlink lien1 = new Hyperlink("Connexion");
		TextFlow phrase1 = new TextFlow(partiephrase1, lien1);

		// Centrer le texte
		HBox hboxphrase1 = new HBox(phrase1);
		hboxphrase1.setAlignment(Pos.CENTER);

		// Construction de la page
		VBox page = new VBox(15);
		page.setPadding(new Insets(30));
		page.setAlignment(Pos.CENTER);
		page.getStyleClass().add("page");
		page.getChildren().addAll(groupe, checkbox1, boutonInscrire, hboxphrase, lignehaut,
				troisIcones, separatorBas, hboxphrase1);

		//
		//// Fin de la page ////
		//

		// BorderPane final qui combine tout
		BorderPane root = new BorderPane();
		root.setTop(navBar);
		root.setCenter(page);
		root.setStyle("-fx-background-color: #f6fafd;");
		
		// Création de la scène
		Scene scene = new Scene(root, 1280, 720);
		scene.getStylesheets().add(getClass().getResource("navbar.css").toExternalForm());
		scene.getStylesheets().add(getClass().getResource("inscription.css").toExternalForm());

		// Titre de la fenêtre et affichage
		primaryStage.setTitle("Reverso Inscription");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
