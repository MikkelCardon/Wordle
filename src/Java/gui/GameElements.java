package gui;

import controller.Controller;
import gui.customElement.Block;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameElements {
    private Controller controller;

    public GameElements(Controller controller) {
        this.controller = controller;

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(15));
        initLayout(root);
        initTextFields(root);
        PrimaryWindow.getStackPane().getChildren().add(root);
    }

    private void initLayout(VBox root) {
        Label titel = new Label("WORDLE by Cardon");
        titel.setFont(Font.font("Impact", FontWeight.BOLD, 24));

        root.getChildren().add(titel);

        root.setOnKeyReleased(event -> controller.keyPressed(event.getCode(), event.getText()));
    }

    private void initTextFields(VBox root){
        GridPane boxGridPane = new GridPane();
        boxGridPane.setVgap(5);
        boxGridPane.setHgap(5);

        for (int outer = 0; outer < 6; outer++) {
            for (int inner = 0; inner < 5; inner++) {
                boxGridPane.add(new Block(), inner, outer+1);
            }
        }
        root.getChildren().add(boxGridPane);
        boxGridPane.getStyleClass().add("primary-gridpane");
    }
}
