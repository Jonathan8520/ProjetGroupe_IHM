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
import javafx.stage.Stage;

public class Expression extends Application {

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
		btnExpression.setStyle("-fx-underline: true; -fx-background-color: #1b4f82;");
		Button btnCorrection = new Button("Correction");
		Button btnSynonymes = new Button("Synonymes");
		Button btnConjugaison = new Button("Conjugaison");

		// Action pour le bouton Définition (ferme la page actuelle et ouvre la page Définition)
		btnDefinition.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage pageActuelle = (Stage) navBar.getScene().getWindow(); // Récupérer la page actuelle grâce à un élément lui appartenant
				pageActuelle.close(); // Fermer la page actuelle
				Definition pageDuBtn = new Definition(); // Créer la page de définition
				pageDuBtn.start(new Stage()); // Ouvrir la page de définition
			}
		});

		// Bouton d'inscription
		Button btnInscription = new Button("Inscription");
		btnInscription.setId("btnInscription");

		// Action pour le bouton Inscription (ferme la page actuelle et ouvre la page Inscription)
		btnInscription.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Même principe que pour le bouton Définition
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

		// Logo et présentation en haut de la page
		ImageView logoExpressio = new ImageView(new Image(getClass().getResourceAsStream("/images/expressio.png")));
		logoExpressio.setFitHeight(60);
		logoExpressio.setPreserveRatio(true);

		Label presentation = new Label("Les expressions françaises décortiquées");
		presentation.setStyle("-fx-font-size: 16px; -fx-font-weight: bold");

		// Barre de recherche pour les expressions
		TextField barreRecherche = new TextField();
		barreRecherche.setPromptText("Tapez un ou plusieurs mots pour trouver les expressions correspondantes");

		// Bouton pour lancer la recherche
		Button btnRecherche = new Button("Chercher");
		btnRecherche.getStyleClass().add("btnRecherche");

		// Disposition de la barre de recherche et du bouton
		HBox barreEtBouton = new HBox(10, barreRecherche, btnRecherche);
		barreEtBouton.setAlignment(Pos.CENTER);
		barreEtBouton.setPadding(new Insets(20));

		// Partie supérieure de la page (logo, présentation, barre de recherche)
		VBox hautPage = new VBox(15);
		hautPage.setAlignment(Pos.CENTER);
		hautPage.setPadding(new Insets(20, 0, 0, 0));
		hautPage.getChildren().addAll(logoExpressio, presentation, barreEtBouton);
		BorderPane.setAlignment(hautPage, Pos.CENTER);

		//////

		// "Expression du jour" avec une phrase
		Label exprTitre = new Label("L'expression du jour :");
		exprTitre.setStyle("-fx-font-size: 15px");

		Label exprPhrase = new Label("Avoir le bras long");
		exprPhrase.setStyle("-fx-font-size: 17px; -fx-font-weight: bold");

		// Bouton pour une expression au hasard
		Button btnHasard = new Button("Une au hasard");
		btnHasard.getStyleClass().add("btnHasard");

		// Combiner le titre et la phrase
		VBox titreEtPhrase = new VBox(10);
		VBox.setMargin(exprPhrase, new Insets(0, 0, 0, 20)); // 20 à gauche pour la phrase
		titreEtPhrase.getChildren().addAll(exprTitre, exprPhrase);

		BorderPane expressionDuJour = new BorderPane();
		expressionDuJour.setLeft(titreEtPhrase);
		expressionDuJour.setRight(btnHasard);
		expressionDuJour.setPadding(new Insets(20));
		expressionDuJour.getStyleClass().add("expressionJour-page");

		//////

		// Liste d'expressions choisies (divisée en deux colonnes)
		Label expressionsTitre = new Label("Quelques expressions choisies :");
		BorderPane.setAlignment(expressionsTitre, Pos.CENTER_LEFT);
		BorderPane.setMargin(expressionsTitre, new Insets(10, 0, 10, 0));

		// Colonne de gauche avec quelques expressions
		VBox colonneGauche = new VBox(5);
		colonneGauche.getChildren().addAll(
				new Label("• C'est les voleurs qui crient au voleur"),
				new Label("• Ne pas pousser mémé dans les orties"),
				new Label("• Être maquillée comme une voiture volée"),
				new Label("• Ne pas payer de mine"),
				new Label("• Peigner la girafe"));

		// Colonne de droite avec d'autres expressions
		VBox colonneDroite = new VBox(5);
		colonneDroite.getChildren().addAll(
				new Label("• Voir midi à sa porte"),
				new Label("• C'est pas la petite bête qui va manger la grosse"),
				new Label("• C'est pas la mer à boire"),
				new Label("• C'est pas au vieux singe qu'on apprend à faire des grimaces"),
				new Label("• Ça casse pas trois pattes à un canard"));

		// Disposition des deux colonnes
		HBox deuxColonnes = new HBox(50);
		deuxColonnes.setAlignment(Pos.CENTER_LEFT);
		deuxColonnes.getChildren().addAll(colonneGauche, colonneDroite);
		deuxColonnes.setStyle("-fx-font-size: 16px;");
		BorderPane.setMargin(deuxColonnes, new Insets(20));

		// Bouton pour voir toutes les expressions
		Button btnVoirTout = new Button("Voir toutes les expressions");
		btnVoirTout.getStyleClass().add("btnVoirTout");
		BorderPane.setAlignment(btnVoirTout, Pos.BOTTOM_RIGHT);
		BorderPane.setMargin(btnVoirTout, new Insets(10, 10, 10, 10));

		// Disposition des expressions choisies
		BorderPane expressionsListe = new BorderPane();
		expressionsListe.setTop(expressionsTitre);
		expressionsListe.setCenter(deuxColonnes);
		expressionsListe.setBottom(btnVoirTout);
		expressionsListe.setPadding(new Insets(10, 20, 10, 20));
		BorderPane.setAlignment(expressionsListe, Pos.CENTER);
		BorderPane.setMargin(expressionsListe, new Insets(20, 0, 50, 0));
		expressionsListe.getStyleClass().add("expressionListe-page");

		// Création de la page principale
		BorderPane page = new BorderPane();
		page.setTop(hautPage);
		page.setCenter(expressionDuJour);
		page.setBottom(expressionsListe);

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
		scene.getStylesheets().add(getClass().getResource("expression.css").toExternalForm());

		// Titre de la fenêtre et affichage
		primaryStage.setTitle("Reverso Expression");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
