package gui.cutomElement;

import gui.PrimaryWindow;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class PopUp extends GridPane {
    private String titel;
    private String message;

    public PopUp() {
        super(50, 30);
        styling();
        showPopUp();
    }

    private void styling() {
        this.setAlignment(Pos.CENTER);
        this.getStyleClass().add("popup-gridpane");
        //this.setBackground(Background.fill(Color.GRAY));

        Label titelLabel = new Label(titel);
        titelLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        Label messageLabel = new Label(message);
        messageLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #555;");

        Button newGameButton = new Button("New Game");
        //newGameButton.setOnAction(event -> );

        this.add(titelLabel, 0, 0);
        this.add(messageLabel, 0, 1);
        this.add(newGameButton, 0, 2);
    }

    private void showPopUp() {
        PrimaryWindow.getStackPane().getChildren().add(this);
    }
}
