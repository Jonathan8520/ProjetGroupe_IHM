package application;

import javafx.application.Application;
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
		btnDefinition.setStyle("-fx-underline: true; -fx-background-color: #1b4f82;");
		Button btnExpression = new Button("Expression");
		Button btnCorrection = new Button("Correction");
		Button btnSynonymes = new Button("Synonymes");
		Button btnConjugaison = new Button("Conjugaison");

		btnExpression.setOnAction(event -> {
			// Fermer la fenêtre actuelle et ouvrir la page Expression
			((Stage) btnExpression.getScene().getWindow()).close();
			Expression mainApp = new Expression();
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
			reversoLogo, btnTranslation, btnDefinition, btnExpression, btnCorrection,btnSynonymes, btnConjugaison);
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

		// Label de présentation à afficher sous la barre de navigation
		Label presentationLabel = new Label(
				"Votre référence en ligne pour des définitions claires et précises");
		presentationLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

		// Créer un VBox pour empiler la barre de navigation et le label de présentation
		VBox topSection = new VBox(10); // Espace entre la navBar et le label
		topSection.getChildren().addAll(navBar, presentationLabel);
		topSection.setAlignment(Pos.CENTER);

		// Conteneur principal de la page
		VBox page = new VBox(15);
		page.setAlignment(Pos.CENTER);
		page.setPadding(new Insets(10));
		page.getStyleClass().add("container-page");

		// Titre
		Label titleLabel = new Label("Saisir un mot ou une expression :");
		titleLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-alignment: center;");

		// Barre de recherche
		TextField searchField = new TextField();
		searchField.getStyleClass().add("text-field");

		// Icone clavier
		ImageView keyboardIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/clavier.png")));
		keyboardIcon.setFitHeight(20);
		keyboardIcon.setPreserveRatio(true);

		// Placer l'icone à l'intérieur de la barre, sur la droite
		StackPane searchFieldWithIcon = new StackPane();
		searchFieldWithIcon.getChildren().addAll(searchField, keyboardIcon);
		searchFieldWithIcon.setMaxWidth(470); // max width de searchField
		StackPane.setAlignment(keyboardIcon, Pos.CENTER_RIGHT);
		StackPane.setMargin(keyboardIcon, new Insets(0, 10, 0, 0));

		// Menu déroulant des langues
		ComboBox<String> langDropdown = new ComboBox<>();
		langDropdown.getItems().addAll("Allemand", "Anglais", "Arabe", "Chinois", "Coréen", "Espagnol", "Français",
				"Hébreu", "Italien", "Japonais", "Néerlandais", "Polonais", "Portugais", "Roumain", "Russe", "Suédois",
				"Turc", "Ukrainien");
		langDropdown.setValue("Français");
		langDropdown.getStyleClass().add("lang-dropdown");

		// Icône du drapeau France
		ImageView dropdownIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/drapeauFR.png")));
		dropdownIcon.setFitHeight(16);
		dropdownIcon.setPreserveRatio(true);

		// Conteneur horizontal pour l'icône et le menu déroulant
		HBox langDropdownWithIcon = new HBox(5);
		langDropdownWithIcon.setAlignment(Pos.CENTER_LEFT);
		langDropdownWithIcon.getChildren().addAll(dropdownIcon, langDropdown);
		langDropdownWithIcon.getStyleClass().add("lang-dropdown-button");

		// Bouton Chercher la définition
		Button searchButton = new Button("Chercher la définition");
		searchButton.getStyleClass().add("search-button");

		// Icone de recherche
		ImageView searchIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/search.png")));
		searchIcon.setFitHeight(16);
		searchIcon.setPreserveRatio(true);
		searchButton.setGraphic(searchIcon);
		searchButton.setContentDisplay(ContentDisplay.RIGHT); // Placer l'icône à droite du texte

		// Conteneur pour menu Langues et bouton Recherche
		HBox langAndButtonBox = new HBox(10);
		langAndButtonBox.setAlignment(Pos.CENTER);
		langAndButtonBox.getChildren().addAll(langDropdownWithIcon, searchButton);
		langAndButtonBox.setSpacing(130);

		Label defLabel = new Label(
				"Le français ne cesse jamais d'étonner par la variété de ses expressions, jeux de mots, ambigüités.\n" + //
						"Notre dictionnaire de définitions vous donne les clés pour éviter les pièges de la langue française et être à l'aise à l'écrit comme à l'oral.");
		defLabel.setWrapText(true);
		defLabel.setStyle("-fx-font-size: 14px; -fx-text-alignment: center;");

		// Ajouter tous les éléments au conteneur principal
		page.getChildren().addAll(titleLabel, searchFieldWithIcon, langAndButtonBox, defLabel);

		ImageView footer = new ImageView(new Image(getClass().getResourceAsStream("/images/footer.png")));
		footer.setFitWidth(1280);
		footer.setPreserveRatio(true);
		StackPane footerPane = new StackPane();
		footerPane.getChildren().add(footer);
		StackPane.setAlignment(footer, Pos.CENTER);

		//
		// Fin de la page //
		//

		// Créer le BorderPane final
		BorderPane root = new BorderPane();
		root.setTop(topSection);
		root.setCenter(page);
		root.setBottom(footerPane);
		root.setStyle("-fx-background-color: #f6fafd;");

		Scene scene = new Scene(root, 1280, 720);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setTitle("Reverso Dictionnaire");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
