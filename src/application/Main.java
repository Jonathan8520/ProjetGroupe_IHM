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
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

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
	Button btnContext = new Button("Context");
	Button btnCorrection = new Button("Correction");
	Button btnSynonymes = new Button("Synonymes");
	Button btnConjugaison = new Button("Conjugaison");

	// Création de l'image pour le logo utilisateur
	ImageView userLogo = new ImageView(new Image(getClass().getResource("/images/userLogo.png").toExternalForm()));
	userLogo.setFitHeight(35);
	userLogo.setPreserveRatio(true);

	// Création du MenuButton avec l'image en tant que graphique
	MenuButton userMenuButton = new MenuButton("", userLogo);

	// Ajout des éléments de menu "Inscription" et "Connexion"
	MenuItem inscriptionItem = new MenuItem("Inscription");
	MenuItem connexionItem = new MenuItem("Connexion");
	userMenuButton.getItems().addAll(inscriptionItem, connexionItem);

	// Appliquer des styles spécifiques si nécessaire
	userMenuButton.getStyleClass().add("user-menu-button");

	// Menu déroulant pour les langues
	ComboBox<String> languageDropdown = new ComboBox<>();
	languageDropdown.getItems().addAll("FR", "EN", "ES");
	languageDropdown.setValue("FR");
	languageDropdown.getStyleClass().add("language-dropdown");

	// Menu avec trois points
	ImageView optButton = new ImageView(new Image(getClass().getResource("/images/optButton.png").toExternalForm()));
	optButton.setFitHeight(30);
	optButton.setPreserveRatio(true);
	MenuButton optionsButton = new MenuButton("", optButton);
	optionsButton.getItems().addAll(new MenuItem("À propos de Reverso"), new MenuItem("Reverso pour les entreprises"), new MenuItem("Newsletter"), new MenuItem("Contactez-nous"));
	optionsButton.getStyleClass().add("options-menu-button");

	// Crée un espace flexible
	Region spacer = new Region();
	HBox.setHgrow(spacer, Priority.ALWAYS); // Permet à l'espace de prendre tout l'espace disponible

	// Ajout des éléments dans la barre de navigation
	navBar.getChildren().addAll(reversoLogo, btnTranslation, btnDefinition, btnContext, btnCorrection, btnSynonymes,
		btnConjugaison, spacer, userMenuButton, languageDropdown, optionsButton);

	HBox leftNav = new HBox(10);
	leftNav.setAlignment(Pos.CENTER); // Centrer verticalement
	leftNav.getChildren().addAll(reversoLogo, btnTranslation, btnDefinition, btnContext, btnCorrection,
		btnSynonymes, btnConjugaison);
	leftNav.setPadding(new Insets(0, 0, 0, 20)); // 20 à gauche

	HBox rightNav = new HBox(10);
	rightNav.setAlignment(Pos.CENTER); // Centrer verticalement
	rightNav.getChildren().addAll(userMenuButton, languageDropdown, optionsButton);
	rightNav.setPadding(new Insets(0, 20, 0, 0)); // 20 à droite

	// Ajout des éléments dans un BorderPane
	navBar.setLeft(leftNav);
	navBar.setRight(rightNav);

	// Zone de recherche
	VBox searchBox = new VBox(10);
	searchBox.setPadding(new Insets(20));
	searchBox.getStyleClass().add("search-container");

	Label titleLabel = new Label(
		"Dictionnaire Français en ligne : traduction des mots et expressions, définition, synonymes");

	TextField searchField = new TextField();
	searchField.setPromptText("Saisir un mot ou une expression");
	searchField.getStyleClass().add("text-field");

	Button searchButton = new Button("Chercher la définition");
	searchButton.getStyleClass().add("search-button");

	HBox searchFieldBox = new HBox(10);
	searchFieldBox.getChildren().addAll(searchField, searchButton);

	searchBox.getChildren().addAll(titleLabel, searchFieldBox);

	// Layout principal
	BorderPane root = new BorderPane();
	root.setTop(navBar);
	root.setCenter(searchBox);

	Scene scene = new Scene(root, 1280, 720);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	primaryStage.setTitle("Mockup Reverso");
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }
}
