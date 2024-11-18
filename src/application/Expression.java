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

		BorderPane navBar = new BorderPane();
		navBar.getStyleClass().add("navbar");

		ImageView reversoLogo = new ImageView(new Image(getClass().getResourceAsStream("/images/logo.png")));
		reversoLogo.setFitHeight(30);
		reversoLogo.setPreserveRatio(true);

		Button btnTraduction = new Button("Traduction");
		Button btnDefinition = new Button("Définition");
		Button btnExpression = new Button("Expression");
		btnExpression.setStyle("-fx-underline: true; -fx-background-color: #1b4f82;");
		Button btnCorrection = new Button("Correction");
		Button btnSynonymes = new Button("Synonymes");
		Button btnConjugaison = new Button("Conjugaison");

		btnDefinition.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Fermer Expression et ouvrir Def
				Stage pageActuelle = (Stage) btnDefinition.getScene().getWindow();
				pageActuelle.close();
				Definition pageDuBtn = new Definition();
				pageDuBtn.start(new Stage());
			}
		});

		Button btnInscription = new Button("Inscription");
		btnInscription.setId("btnInscription");

		btnInscription.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Fermer Expression et ouvrir Inscription
				Stage pageActuelle = (Stage) btnInscription.getScene().getWindow();
				pageActuelle.close();
				Inscription pageDuBtn = new Inscription();
				pageDuBtn.start(new Stage());
			}
		});

		ImageView logoUser = new ImageView(new Image(getClass().getResourceAsStream("/images/userLogo.png")));
		logoUser.setFitHeight(35);
		logoUser.setPreserveRatio(true);

		Button logoConnexion = new Button();
		logoConnexion.setGraphic(logoUser);
		logoConnexion.setStyle("-fx-background-color: transparent;");

		ComboBox<String> listeLanguesSite = new ComboBox<>();
		listeLanguesSite.getItems().addAll("FR", "EN", "ES", "IT", "RU");
		listeLanguesSite.setValue("FR");
		listeLanguesSite.getStyleClass().add("listeLanguesSite");

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

		HBox leftNav = new HBox(10);
		leftNav.setAlignment(Pos.CENTER);
		leftNav.setPadding(new Insets(0, 0, 0, 20));
		leftNav.getChildren().addAll(
				reversoLogo, btnTraduction, btnDefinition, btnExpression, btnCorrection, btnSynonymes, btnConjugaison);

		HBox rightNav = new HBox(10);
		rightNav.setAlignment(Pos.CENTER);
		rightNav.setPadding(new Insets(0, 20, 0, 0));
		rightNav.getChildren().addAll(
				btnInscription, logoConnexion, listeLanguesSite, btnTroisPoints);

		navBar.setLeft(leftNav);
		navBar.setRight(rightNav);

		// 
		//// Fin navbar ////
		//

		// 
		//// Début page ////
		//

		ImageView logoExpressio = new ImageView(new Image(getClass().getResourceAsStream("/images/expressio.png")));
		logoExpressio.setFitHeight(60);
		logoExpressio.setPreserveRatio(true);

		Label presentation = new Label("Les expressions françaises décortiquées");
		presentation.setStyle("-fx-font-size: 16px; -fx-font-weight: bold");

		TextField barreRecherche = new TextField();
		barreRecherche.setPromptText("Tapez un ou plusieurs mots pour trouver les expressions correspondantes");

		Button btnRecherche = new Button("Chercher");
		btnRecherche.getStyleClass().add("btnRecherche");

		HBox barreEtBouton = new HBox(10, barreRecherche, btnRecherche);
		barreEtBouton.setAlignment(Pos.CENTER);
		barreEtBouton.setPadding(new Insets(20));

		VBox hautPage = new VBox(15);
		hautPage.setAlignment(Pos.CENTER);
		hautPage.setPadding(new Insets(20, 0, 0, 0));
		hautPage.getChildren().addAll(logoExpressio, presentation, barreEtBouton);
		BorderPane.setAlignment(hautPage, Pos.CENTER);

		//////

		Label exprTitre = new Label("L'expression du jour :");
		exprTitre.setStyle("-fx-font-size: 15px");

		Label exprPhrase = new Label("Avoir le bras long");
		exprPhrase.setStyle("-fx-font-size: 17px; -fx-font-weight: bold");

		Button btnHasard = new Button("Une au hasard");
		btnHasard.getStyleClass().add("btnHasard");

		VBox titreEtPhrase = new VBox(10);
		VBox.setMargin(exprPhrase, new Insets(0, 0, 0, 20));
		titreEtPhrase.getChildren().addAll(exprTitre, exprPhrase);

		BorderPane expressionDuJour = new BorderPane();
		expressionDuJour.setLeft(titreEtPhrase);
		expressionDuJour.setRight(btnHasard);
		expressionDuJour.setPadding(new Insets(20));
		expressionDuJour.getStyleClass().add("expressionJour-page");

		//////

		Label expressionsTitre = new Label("Quelques expressions choisies :");
		BorderPane.setAlignment(expressionsTitre, Pos.CENTER_LEFT);
		BorderPane.setMargin(expressionsTitre, new Insets(10, 0, 10, 0));

		VBox colonneGauche = new VBox(5);
		colonneGauche.getChildren().addAll(
				new Label("• C'est les voleurs qui crient au voleur"),
				new Label("• Ne pas pousser mémé dans les orties"),
				new Label("• Être maquillée comme une voiture volée"),
				new Label("• Ne pas payer de mine"),
				new Label("• Peigner la girafe"));

		VBox colonneDroite = new VBox(5);
		colonneDroite.getChildren().addAll(
				new Label("• Voir midi à sa porte"),
				new Label("• C'est pas la petite bête qui va manger la grosse"),
				new Label("• C'est pas la mer à boire"),
				new Label("• C'est pas au vieux singe qu'on apprend à faire des grimaces"),
				new Label("• Ça casse pas trois pattes à un canard"));

		HBox deuxColonnes = new HBox(50);
		deuxColonnes.setAlignment(Pos.CENTER_LEFT);
		deuxColonnes.getChildren().addAll(colonneGauche, colonneDroite);
		deuxColonnes.setStyle("-fx-font-size: 16px;");
		BorderPane.setMargin(deuxColonnes, new Insets(20));

		Button btnVoirTout = new Button("Voir toutes les expressions");
		btnVoirTout.getStyleClass().add("btnVoirTout");
		BorderPane.setAlignment(btnVoirTout, Pos.BOTTOM_RIGHT);
		BorderPane.setMargin(btnVoirTout, new Insets(10, 10, 10, 10));

		BorderPane expressionsListe = new BorderPane();
		expressionsListe.setTop(expressionsTitre);
		expressionsListe.setCenter(deuxColonnes);
		expressionsListe.setBottom(btnVoirTout);
		expressionsListe.setPadding(new Insets(10, 20, 10, 20));
		BorderPane.setAlignment(expressionsListe, Pos.CENTER);
		BorderPane.setMargin(expressionsListe, new Insets(20, 0, 50, 0));
		expressionsListe.getStyleClass().add("expressionListe-page");

		///////

		BorderPane page = new BorderPane();
		page.setTop(hautPage);
		page.setCenter(expressionDuJour);
		page.setBottom(expressionsListe);

		//
		// Fin de la page //
		//

		// BorderPane final
		BorderPane root = new BorderPane();
		root.setTop(navBar);
		root.setCenter(page);
		root.setStyle("-fx-background-color: #f6fafd;");

		Scene scene = new Scene(root, 1280, 720);
		scene.getStylesheets().add(getClass().getResource("navbar.css").toExternalForm());
		scene.getStylesheets().add(getClass().getResource("expression.css").toExternalForm());

		primaryStage.setTitle("Reverso Expression");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
