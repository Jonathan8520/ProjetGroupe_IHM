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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Definition extends Application {

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
		btnDefinition.setStyle("-fx-underline: true; -fx-background-color: #1b4f82;");
		Button btnExpression = new Button("Expression");
		Button btnCorrection = new Button("Correction");
		Button btnSynonymes = new Button("Synonymes");
		Button btnConjugaison = new Button("Conjugaison");

		// Action pour le bouton Expression (ferme la page actuelle et ouvre la page Expression)
		btnExpression.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage pageActuelle = (Stage) navBar.getScene().getWindow(); // Récupérer la page actuelle grâce à un élément lui appartenant
				pageActuelle.close(); // Fermer la page actuelle
				Expression pageDuBtn = new Expression(); // Créer la page d'expressions
				pageDuBtn.start(new Stage()); // Ouvrir la page d'expressions
			}
		});

		// Bouton d'inscription
		Button btnInscription = new Button("Inscription");
		btnInscription.setId("btnInscription");

		// Action pour le bouton Inscription (ferme la page actuelle et ouvre la page Inscription)
		btnInscription.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Même principe que pour le bouton Expression
				Stage pageActuelle = (Stage) navBar.getScene().getWindow();
				pageActuelle.close();
				Inscription pageDuBtn = new Inscription();
				pageDuBtn.start(new Stage());
			}
		});

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
		leftNav.getChildren().addAll(
				reversoLogo, btnTraduction, btnDefinition, btnExpression, btnCorrection, btnSynonymes, btnConjugaison);

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

		// Texte de présentation du site
		Label presentation = new Label("Votre référence en ligne pour des définitions claires et précises");
		presentation.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

		VBox hautPage = new VBox(10);
		hautPage.getChildren().addAll(navBar, presentation);
		hautPage.setAlignment(Pos.CENTER);

		// Section de recherche
		Label txtSaisir = new Label("Saisir un mot ou une expression :");
		txtSaisir.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-alignment: center;");

		TextField barreRecherche = new TextField();
		barreRecherche.getStyleClass().add("text-field");

		// Logo de clavier
		ImageView logoClavier = new ImageView(new Image(getClass().getResourceAsStream("/images/clavier.png")));
		logoClavier.setFitHeight(20);
		logoClavier.setPreserveRatio(true);

		// StackPane pour combiner la barre de recherche et pour mettre le logo de clavier par dessus
		StackPane barreEtLogo = new StackPane();
		barreEtLogo.getChildren().addAll(barreRecherche, logoClavier);
		barreEtLogo.setMaxWidth(470); // Largeur maximale de la barre de recherche
		StackPane.setAlignment(logoClavier, Pos.CENTER_RIGHT);
		StackPane.setMargin(logoClavier, new Insets(0, 10, 0, 0)); // 10 à droite

		// ComboBox pour sélectionner la langue du mot à rechercher
		ComboBox<String> listeLangueDuMot = new ComboBox<>();
		listeLangueDuMot.getItems().addAll("Allemand", "Anglais", "Arabe", "Chinois", "Coréen", "Espagnol", "Français",
				"Hébreu", "Italien", "Japonais", "Néerlandais", "Polonais", "Portugais", "Roumain", "Russe", "Suédois",
				"Turc", "Ukrainien");
		listeLangueDuMot.setValue("Français");
		listeLangueDuMot.getStyleClass().add("listeLangueDuMot");

		// Icône de drapeau pour la langue sélectionnée
		ImageView imgDrapeauFR = new ImageView(new Image(getClass().getResourceAsStream("/images/drapeauFR.png")));
		imgDrapeauFR.setFitHeight(16);
		imgDrapeauFR.setPreserveRatio(true);

		// Box pour combiner la langue et le drapeau
		HBox listeLangueEtDrapeau = new HBox(5);
		listeLangueEtDrapeau.setAlignment(Pos.CENTER_LEFT);
		listeLangueEtDrapeau.getChildren().addAll(imgDrapeauFR, listeLangueDuMot);
		listeLangueEtDrapeau.getStyleClass().add("listeLangueEtDrapeau");

		// Bouton de recherche avec un logo
		ImageView logoRecherche = new ImageView(new Image(getClass().getResourceAsStream("/images/search.png")));
		logoRecherche.setFitHeight(16);
		logoRecherche.setPreserveRatio(true);

		Button btnRecherche = new Button("Chercher la définition");
		btnRecherche.getStyleClass().add("btnRecherche");
		btnRecherche.setGraphic(logoRecherche);
		btnRecherche.setContentDisplay(ContentDisplay.RIGHT);

		// Section pour la recherche avec la langue et le bouton de recherche
		HBox listeLangueEtBtnRecherche = new HBox(130);
		listeLangueEtBtnRecherche.setAlignment(Pos.CENTER);
		listeLangueEtBtnRecherche.getChildren().addAll(listeLangueEtDrapeau, btnRecherche);

		// Description de la page pour expliquer le service de définition
		Label def = new Label(
				"Le français ne cesse jamais d'étonner par la variété de ses expressions, jeux de mots, ambigüités.\n Notre dictionnaire de définitions vous donne les clés pour éviter les pièges de la langue française et être à l'aise à l'écrit comme à l'oral.");
		def.setStyle("-fx-font-size: 14px; -fx-text-alignment: center;");

		// Combiner tous les éléments du centre de la page
		VBox centrePage = new VBox(15);
		centrePage.setAlignment(Pos.CENTER);
		centrePage.setPadding(new Insets(10));
		centrePage.getStyleClass().add("page");
		centrePage.getChildren().addAll(txtSaisir, barreEtLogo, listeLangueEtBtnRecherche, def);

		// Image de pied de page
		ImageView imgAPropos = new ImageView(new Image(getClass().getResourceAsStream("/images/footer.png")));
		imgAPropos.setFitWidth(1280);
		imgAPropos.setPreserveRatio(true);

		// On met l'image dans une HBox pour la centrer
		HBox basPage = new HBox();
		basPage.setAlignment(Pos.CENTER);
		basPage.getChildren().add(imgAPropos);

		//
		//// Fin de la page ////
		//

		// BorderPane final qui combine tout
		BorderPane root = new BorderPane();
		root.setTop(hautPage);
		root.setCenter(centrePage);
		root.setBottom(basPage);
		root.setStyle("-fx-background-color: #f6fafd;");

		// Création de la scène et application des styles
		Scene scene = new Scene(root, 1280, 720);
		scene.getStylesheets().add(getClass().getResource("navbar.css").toExternalForm());
		scene.getStylesheets().add(getClass().getResource("definition.css").toExternalForm());

		// Titre de la fenêtre et affichage
		primaryStage.setTitle("Reverso Dictionnaire");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
