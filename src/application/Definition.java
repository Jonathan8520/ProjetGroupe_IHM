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

		BorderPane navBar = new BorderPane();
		navBar.getStyleClass().add("navbar");

		ImageView reversoLogo = new ImageView(new Image(getClass().getResourceAsStream("/images/logo.png")));
		reversoLogo.setFitHeight(30);
		reversoLogo.setPreserveRatio(true);

		Button btnTraduction = new Button("Traduction");
		Button btnDefinition = new Button("Définition");
		btnDefinition.setStyle("-fx-underline: true; -fx-background-color: #1b4f82;");
		Button btnExpression = new Button("Expression");
		Button btnCorrection = new Button("Correction");
		Button btnSynonymes = new Button("Synonymes");
		Button btnConjugaison = new Button("Conjugaison");

		btnExpression.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Fermer Def et ouvrir Expression
				Stage pageActuelle = (Stage) btnExpression.getScene().getWindow();
				pageActuelle.close();
				Expression pageDuBtn = new Expression();
				pageDuBtn.start(new Stage());
			}
		});

		Button btnInscription = new Button("Inscription");
		btnInscription.setId("btnInscription");

		btnInscription.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Fermer Def et ouvrir Inscription
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

		Label presentation = new Label("Votre référence en ligne pour des définitions claires et précises");
		presentation.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

		VBox hautPage = new VBox(10);
		hautPage.getChildren().addAll(navBar, presentation);
		hautPage.setAlignment(Pos.CENTER);

		Label txtSaisir = new Label("Saisir un mot ou une expression :");
		txtSaisir.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-alignment: center;");

		TextField barreRecherche = new TextField();
		barreRecherche.getStyleClass().add("text-field");

		ImageView logoClavier = new ImageView(new Image(getClass().getResourceAsStream("/images/clavier.png")));
		logoClavier.setFitHeight(20);
		logoClavier.setPreserveRatio(true);

		StackPane barreEtLogo = new StackPane();
		barreEtLogo.getChildren().addAll(barreRecherche, logoClavier);
		barreEtLogo.setMaxWidth(470); // c'est le max width de searchField pour mettre le logo à l'interieur de la barre
		StackPane.setAlignment(logoClavier, Pos.CENTER_RIGHT);
		StackPane.setMargin(logoClavier, new Insets(0, 10, 0, 0));

		ComboBox<String> listeLangueDuMot = new ComboBox<>();
		listeLangueDuMot.getItems().addAll("Allemand", "Anglais", "Arabe", "Chinois", "Coréen", "Espagnol", "Français",
				"Hébreu", "Italien", "Japonais", "Néerlandais", "Polonais", "Portugais", "Roumain", "Russe", "Suédois",
				"Turc", "Ukrainien");
		listeLangueDuMot.setValue("Français");
		listeLangueDuMot.getStyleClass().add("listeLangueDuMot");

		ImageView imgDrapeauFR = new ImageView(new Image(getClass().getResourceAsStream("/images/drapeauFR.png")));
		imgDrapeauFR.setFitHeight(16);
		imgDrapeauFR.setPreserveRatio(true);

		HBox listeLangueEtDrapeau = new HBox(5);
		listeLangueEtDrapeau.setAlignment(Pos.CENTER_LEFT);
		listeLangueEtDrapeau.getChildren().addAll(imgDrapeauFR, listeLangueDuMot);
		listeLangueEtDrapeau.getStyleClass().add("listeLangueEtDrapeau");

		ImageView logoRecherche = new ImageView(new Image(getClass().getResourceAsStream("/images/search.png")));
		logoRecherche.setFitHeight(16);
		logoRecherche.setPreserveRatio(true);

		Button btnRecherche = new Button("Chercher la définition");
		btnRecherche.getStyleClass().add("btnRecherche");
		btnRecherche.setGraphic(logoRecherche);
		btnRecherche.setContentDisplay(ContentDisplay.RIGHT);

		HBox listeLangueEtBtnRecherche = new HBox(130);
		listeLangueEtBtnRecherche.setAlignment(Pos.CENTER);
		listeLangueEtBtnRecherche.getChildren().addAll(listeLangueEtDrapeau, btnRecherche);

		Label def = new Label(
				"Le français ne cesse jamais d'étonner par la variété de ses expressions, jeux de mots, ambigüités.\n Notre dictionnaire de définitions vous donne les clés pour éviter les pièges de la langue française et être à l'aise à l'écrit comme à l'oral.");
		def.setStyle("-fx-font-size: 14px; -fx-text-alignment: center;");

		VBox centrePage = new VBox(15);
		centrePage.setAlignment(Pos.CENTER);
		centrePage.setPadding(new Insets(10));
		centrePage.getStyleClass().add("page");
		centrePage.getChildren().addAll(txtSaisir, barreEtLogo, listeLangueEtBtnRecherche, def);

		ImageView imgAPropos = new ImageView(new Image(getClass().getResourceAsStream("/images/footer.png")));
		imgAPropos.setFitWidth(1280);
		imgAPropos.setPreserveRatio(true);

		HBox basPage = new HBox();
		basPage.setAlignment(Pos.CENTER);
		basPage.getChildren().add(imgAPropos);
		
		//
		// Fin de la page //
		//

		// BorderPane final
		BorderPane root = new BorderPane();
		root.setTop(hautPage);
		root.setCenter(centrePage);
		root.setBottom(basPage);
		root.setStyle("-fx-background-color: #f6fafd;");

		Scene scene = new Scene(root, 1280, 720);
		scene.getStylesheets().add(getClass().getResource("navbar.css").toExternalForm());
		scene.getStylesheets().add(getClass().getResource("definition.css").toExternalForm());

		primaryStage.setTitle("Reverso Dictionnaire");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
