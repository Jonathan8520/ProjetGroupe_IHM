package application;

import javafx.application.Application;
import javafx.application.Platform;
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

		// Barre de navigation
		BorderPane navBar = new BorderPane();
		navBar.getStyleClass().add("nav-bar");

		// Logo Reverso
		ImageView reversoLogo = new ImageView(new Image(getClass().getResource("/images/logo.png").toExternalForm()));
		reversoLogo.setFitHeight(30);
		reversoLogo.setPreserveRatio(true);

		// Boutons de navigation
		Button btnTranslation = new Button("Traduction");
		Button btnDefinition = new Button("Définition");
		Button btnExpression = new Button("Expression");
		btnExpression.setStyle("-fx-underline: true; -fx-background-color: #1b4f82;");
		Button btnCorrection = new Button("Correction");
		Button btnSynonymes = new Button("Synonymes");
		Button btnConjugaison = new Button("Conjugaison");

		btnDefinition.setOnAction(event -> {
			// Fermer la fenêtre actuelle et ouvrir la page Definition
			((Stage) btnDefinition.getScene().getWindow()).close();
			Definition mainApp = new Definition();
			mainApp.start(new Stage());
		});

		// image pour le logo utilisateur
		ImageView userLogo = new ImageView(new Image(getClass().getResource("/images/userLogo.png").toExternalForm()));
		userLogo.setFitHeight(35);
		userLogo.setPreserveRatio(true);

		// Bouton pour la connexion (logo utilisateur)
		Button userLoginButton = new Button();
		userLoginButton.setGraphic(userLogo);
		userLoginButton.setStyle("-fx-background-color: transparent;");

		// Bouton "Inscription"
		Button inscriptionButton = new Button("Inscription");
		inscriptionButton.setId("btnInscription");

		// Menu déroulant pour les langues
		ComboBox<String> languageDropdown = new ComboBox<>();
		languageDropdown.getItems().addAll("FR", "EN", "ES");
		languageDropdown.setValue("FR");
		languageDropdown.getStyleClass().add("language-dropdown");

		// Menu avec trois points
		ImageView optButton = new ImageView(
				new Image(getClass().getResource("/images/optButton.png").toExternalForm()));
		optButton.setFitHeight(30);
		optButton.setPreserveRatio(true);
		MenuButton optionsButton = new MenuButton("", optButton);
		optionsButton.getItems().addAll(
				new MenuItem("À propos de Reverso"),
				new MenuItem("Reverso pour les entreprises"),
				new MenuItem("Newsletter"),
				new MenuItem("Contactez-nous"));
		optionsButton.getStyleClass().add("options-menu-button");

		HBox leftNav = new HBox(10);
		leftNav.setAlignment(Pos.CENTER);
		leftNav.getChildren().addAll(
				reversoLogo, btnTranslation, btnDefinition, btnExpression, btnCorrection, btnSynonymes, btnConjugaison);
		leftNav.setPadding(new Insets(0, 0, 0, 20)); // 20 à gauche

		HBox rightNav = new HBox(10);
		rightNav.setAlignment(Pos.CENTER);
		rightNav.getChildren().addAll(
				inscriptionButton, userLoginButton, languageDropdown, optionsButton);
		rightNav.setPadding(new Insets(0, 20, 0, 0)); // 20 à droite

		// Ajout des éléments dans le BorderPane navBar
		navBar.setLeft(leftNav);
		navBar.setRight(rightNav);

		//
		// Fin de la navbar //
		//

		// Image du logo
		ImageView expressioLogo = new ImageView(
				new Image(getClass().getResource("/images/expressio.png").toExternalForm()));
		expressioLogo.setFitHeight(60);
		expressioLogo.setPreserveRatio(true);

		// Sous-titre
		Label subtitleLabel = new Label("Les expressions françaises décortiquées");
		subtitleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold");

		// Barre de recherche
		TextField searchField = new TextField();
		searchField.setPromptText("Tapez un ou plusieurs mots pour trouver les expressions correspondantes");
		searchField.getStyleClass().add("text-field");

		// Bouton pour la recherche
		Button searchButton = new Button("Chercher");
		searchButton.getStyleClass().add("search-button");

		// On met la barre de recherche + le bouton Recherche ensemble
		HBox searchBox = new HBox(10, searchField, searchButton);
		searchBox.setAlignment(Pos.CENTER);
		searchBox.setPadding(new Insets(20));

		// On met tout dans un VBox
		VBox mainVBox = new VBox(15);
		mainVBox.setAlignment(Pos.CENTER);
		mainVBox.setPadding(new Insets(20, 0, 0, 0)); // 20 en haut
		mainVBox.getChildren().addAll(expressioLogo, subtitleLabel, searchBox);

		//////

		Label exprTitre = new Label("L'expression du jour :");
		exprTitre.setStyle("-fx-font-size: 15px");

		Label exprPhrase = new Label("Avoir le bras long");
		exprPhrase.setStyle("-fx-font-size: 17px; -fx-font-weight: bold");

		Button btnHasard = new Button("Une au hasard");
		btnHasard.getStyleClass().add("btn-hasard");

		// On met exprTitre + exprPhrase dans un VBox
		VBox titreEtPhrase = new VBox(10);
		VBox.setMargin(exprPhrase, new Insets(0, 0, 0, 20)); // 20px de marge à gauche
		titreEtPhrase.getChildren().addAll(exprTitre, exprPhrase);

		// On met tout dans un BorderPane
		BorderPane expressionDuJour = new BorderPane();
		expressionDuJour.setLeft(titreEtPhrase);
		expressionDuJour.setRight(btnHasard);
		expressionDuJour.setPadding(new Insets(20));
		expressionDuJour.getStyleClass().add("expressionJour-page");

		//////

		Label expressionsLabel = new Label("Quelques expressions choisies :");

		VBox column1 = new VBox(5); // Colonne de gauche
		column1.getChildren().addAll(
				new Label("• C'est les voleurs qui crient au voleur"),
				new Label("• Ne pas pousser mémé dans les orties"),
				new Label("• Être maquillée comme une voiture volée"),
				new Label("• Ne pas payer de mine"),
				new Label("• Peigner la girafe"));

		VBox column2 = new VBox(5); // Colonne de droite
		column2.getChildren().addAll(
				new Label("• Voir midi à sa porte"),
				new Label("• C'est pas la petite bête qui va manger la grosse"),
				new Label("• C'est pas la mer à boire"),
				new Label("• C'est pas au vieux singe qu'on apprend à faire des grimaces"),
				new Label("• Ça casse pas trois pattes à un canard"));

		// HBox pour les deux colonnes d'expressions
		HBox expressionsBox = new HBox(50); // Espacement entre les deux colonnes
		expressionsBox.setAlignment(Pos.CENTER_LEFT);
		expressionsBox.getChildren().addAll(column1, column2);
		expressionsBox.setStyle("-fx-font-size: 16px;");

		// Bouton pour voir toutes les expressions
		Button allExpressionsButton = new Button("Voir toutes les expressions");
		allExpressionsButton.getStyleClass().add("allExpression-button");

		// On met tout dans un BorderPane
		BorderPane expressionsList = new BorderPane();
		expressionsList.setTop(expressionsLabel);
		expressionsList.setCenter(expressionsBox);
		expressionsList.setBottom(allExpressionsButton);
		expressionsList.setPadding(new Insets(10, 20, 10, 20));

		expressionsList.getStyleClass().add("expressionListe-page");

		///////

		// Configurer l'alignement et les marges
		BorderPane.setAlignment(expressionsLabel, Pos.CENTER_LEFT);
		BorderPane.setAlignment(allExpressionsButton, Pos.BOTTOM_RIGHT);
		BorderPane.setAlignment(mainVBox, Pos.CENTER);
		BorderPane.setAlignment(expressionsList, Pos.CENTER);
		BorderPane.setMargin(expressionsLabel, new Insets(10, 0, 10, 0));
		BorderPane.setMargin(expressionsBox, new Insets(20));
		BorderPane.setMargin(allExpressionsButton, new Insets(10, 10, 10, 10));
		BorderPane.setMargin(expressionsList, new Insets(20, 0, 50, 0));

		// Conteneur principal avec BorderPane
		BorderPane page = new BorderPane();
		page.setTop(mainVBox);
		page.setCenter(expressionDuJour);
		page.setBottom(expressionsList);

		//
		// Fin de la page //
		//

		// Créer le BorderPane final
		BorderPane root = new BorderPane();
		root.setTop(navBar);
		root.setCenter(page);
		root.setStyle("-fx-background-color: #f6fafd;");

		Scene scene = new Scene(root, 1280, 720);
		scene.getStylesheets().add(getClass().getResource("expression.css").toExternalForm());

		primaryStage.setTitle("Reverso Expression");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
